/**
Preorder Traversal, No Recursion

PROBLEM  Perform a preorder traversal of a binary search tree, printing the
value of each node, but this time you may not use recursion.
*/

/*
Because a stack is a last-in-first-out data structure, push the right node onto the stack first, followed
by the left node. Instead of examining the left child explicitly, simply pop the first node from the
stack, print its value, and push both of its children onto the stack in the correct order. If you start
the procedure by pushing the root node onto the stack and then pop, print, and push as described,
you can emulate the recursive preorder traversal. To summarize:
Create the stack
Push the root node on the stack
While the stack is not empty
Pop a node
Print its value
If right child exists, push the node's right child
If left child exists, push the node's left child
*/

void preorderTraversal(Node root){
	NodeStack stack = new NodeStack();
	stack.push(root);
	while(stack.size() > 0){
		Node curr = stack.pop();
		curr.printValue();
		Node n = curr.getRight();
		if(n !=null) stack.push(n);
		n = curr.getLeft();
		if(n !=null) stack.push(n);
	}
}