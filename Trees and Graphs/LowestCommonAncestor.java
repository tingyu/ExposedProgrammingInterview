/**
Lowest Common Ancestor


PROBLEM  Given the value of two nodes in a binary search tree, find the lowest
(nearest) common ancestor. You may assume that both values already exist in
the tree.
For example, using the tree shown in Figure 5-7, assume 4 and 14 are the two
given nodes. The lowest common ancestor would be 8 because it’s an ancestor to
both 4 and 14, and there is no node lower on the tree that is an ancestor to both 4
and 14.
*/

/*
Follow the lines up from each
of the nodes until they converge. To implement this algorithm, make lists
of all the ancestors of both nodes, and then search through these two
lists to find the first node where they differ. The node immediately above
this divergence is the lowest common ancestor. This is a good solution,
but there is a more efficient one
*/

/*
The root node is an ancestor to all nodes because there is a path from it to all other nodes. Therefore,
you can start at the root node and follow a path through the common ancestors of both nodes. When
your target values are both less than the current node, you go left. When they are both greater,
you go right. The first node you encounter that is between your target values is the lowest common
ancestor.
Based on this description, and referring to the values of the two nodes as value1 and value2, you
can derive the following algorithm:
Examine the current node
If value1 and value2 are both less than the current node's value
Examine the left child
If value1 and value2 are both greater than the current node's value
Examine the right child
Otherwise
The current node is the lowest common ancestor
*/

Node findLowestCommonAncestor(Node root, int value1, int value2){
	while( root != null){
		int value = root.getValue();

		if(value > value1 && value > value2){
			root = root.getLeft();
		} else if(value < value1 && value < value2){
			root = root.getRight();
		} else{
			return root;
		}
	}
	return null; //only if empty tree
}

/*
Recall that traveling a path to any one node takes O(log(n)). Therefore, this is an O(log(n)) algo-
rithm. In addition, this is slightly more efficient than a similar recursive solution because you don’t
have the overhead of repeated function calls.
*/

/**
The problem states that you’ll be given the value of two nodes in the tree, but it’s trivial to write an
overloaded wrapper for the function you just implemented that would cover the case where you’re
given references to the two nodes:
*/

Node findLowestCommonAncestor(Node root, Node child1, Node child2){
	if(root == null || child1 == null || child2 == null){
		return null;
	}

	return findLowestCommonAncestor(root, child1.getValue(), child2.getValue());
}