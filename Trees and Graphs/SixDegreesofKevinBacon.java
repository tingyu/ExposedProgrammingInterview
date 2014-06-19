/**
six degrees of Kevin bacon

ProbLem The game “Six Degrees of Kevin Bacon” involves trying to find the shortest connection 
between an arbitrarily selected actor and Kevin Bacon. Two actors are linked if they appeared 
in the same movie. The goal of the game is to connect the given actor to Kevin Bacon using the fewest possible links.
Given a list of all major movies in history and their casts (assume that the names of movies 
and actors are unique identifiers), describe a data structure that could be constructed 
to efficiently solve Kevin Bacon problems. Write a routine that uses your data structure to 
determine the Bacon number (the minimum number of links needed to connect to Kevin Bacon) for any actor.
*/

//undirected graph, have each node object reference the other

public class ActorGraphNode{
	private String name;
	private Set<ActorGraphNode> linkedActors;
	public ActorGraphNode(String name){
		this.name = name;
		linkedActors = new HashSet<ActorGraphNode>();
	}

	public void linkCostar(ActorGraphNode costar){
		linkedActors.add(costar);
		costar.linkedActors.add(this);
	}
}

//BFS

/*
pseudo-code, algorithm:
Create a queue and initialize it with the start node
While the queue is not empty
	Remove the first node from the queue
	If it is the target node, return its Bacon number
	For each node adjacent to the current node 
	If the node is unvisited(Bacon number is -1)
		Set the Bacon number to current node's Bacon number + 1
		Add the adjacent node to the end of the queue
Return failure because the loop terminated without finding the target
*/

private int baconNumber = -1;

pulic int getBaconNumber() {return baconNumber;}

//To be called only on the Kevin Bacon node
public void setBaconNumbers(){
	baconNumber = 0;
	Queue<ActorGraphNode> queue = new LinkedList<ActorGraphNode>();
	queue.add(this);
	ActorGraphNode current;
	while((current == queue.poll()) != null){
		for(ActorGraphNode n: current.linkedActors){
			if(-1 == n.baconNumber){ //if node is unvisited
				n.baconNumber = current.baconNumber + 1;
				queue.add(n);
			}
		}
	}
}