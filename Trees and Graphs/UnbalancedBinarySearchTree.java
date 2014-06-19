/**
unbalanced binary search tree

ProbLem Given an unbalanced binary search tree with more nodes in the left subtree than the right, 
reorganize the tree to improve its balance while maintain- ing the properties of a binary search tree
*/


/*
In a balanced BST, half of the nodes are less than or equal to the root and half are greater or equal. 

Since there’s no case in which the properties of a BST will be violated by the transformation you’ve devised, 
this algorithm can be applied to any BST. Moreover, it can be applied to any subtree within a BST. 
You can imagine that a badly unbalanced tree could be balanced by applying this procedure repeatedly; 
a tree unbalanced to the right could be improved by applying the procedure with the sides reversed.
At some point during this problem, you may recognize that the algorithm you’re deriving is 
a tree rotation (specifically, a right rotation). 
Tree rotations are the basic operations of many self-balancing trees, including AVL trees and red-black trees.
*/

//Right rotation can be implemented as:
public static Node rotateRight(Node oldRoot){
	Node newRoot = oldRoot.getLeft();
	oldRoot.setLeft(newRoot.getRight());
	newRoot.setRight(oldRoot);
	return newRoot;
}

//An equivalent implementation as a non-static method of the Node class is better object-oriented design
public Node rotateRight(){
	Node newRoot = left;
	left = newRoot.right;
	newRoot.right = this;
	return newRoot;
}