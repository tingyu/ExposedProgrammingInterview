/**
Preorder Traversal

PROBLEM  Informally, a preorder traversal involves walking around the tree in
a counter-clockwise manner starting at the root, sticking close to the edges, and
printing out the nodes as you encounter them. For the tree shown in Figure 5-6,
the result is 100, 50, 25, 75, 150, 125, 110, and 175. Perform a preorder traversal
of a binary search tree, printing the value of each node.
*/

//key: to think in terms of subtreees

void preorderTraversal(Node root){
	if(root == null) return;
	root.printValue();
	preorderTraversal(root.getLeft());
	preorderTraversal(root.getRight());
}


void inorderTraveral(Node root){
	if(root == null) return;
	inorderTraveral(root.getLeft());
	root.printValue();
	inorderTraveral(root.getRight());
}


void postorderTraversal(Node root){
	if(root == null) return;
	postorderTraversal(root.getLeft());
	postorderTraversal(root.getRight());
	root.printValue();
}