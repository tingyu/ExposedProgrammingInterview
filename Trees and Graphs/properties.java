/**
Trees
*/

public abstract class Node{
	private Node[] children;

	public Node(Node[] children){
		this.children = children;
	}

	public int getNumChildren(){
		return children.length;
	}

	public Node getChild(int index){
		return children[index];
	}
}

public class IntNode extends Node{
	private int value;

	public IntNode(Node[] children, int value){
		super(children);
		this.value = value;
	}

	public int getValue(){
		return value;
	}
}

/**
Binary Trees
*/
public class Node {
	private Node left;
	private Node right;
	private int value;

	public Node(Node left, Node right, int value){
		this.left = left;
		this.right = right;
		this.value = value;
	}

	public Node getLeft() {return left;}
	public Node getRight() {return right;}
	public Node getValue() {return value;}
}


/**
Binary Search Trees


Advantage: Lookup operation, used for data storage

Lookup is an O(log(n)) operation in a balanced binary search tree

Deletion and insertion are O(log(n)) operations in binary search tree
*/

Node findNode(Node root, int value){
	while(root != null){
		int currval = root.getValue();
		if(currval == value) break;
		if(currval < value){
			root = root.getRight();
		}else{
			root = root.getLeft();
		}
	}
	return root;
}


Node findNode(Node root, int value){
	if(root == null) return null;
	int currval = root.getValue();
	if(currval == value) return root;
	if(currval < value){
		return findNode(root.getRight(), value);
	} else{
		return findNode(root.getLeft(), value);
	}
}