/**
Binary Tree to Heap

PROBLEM  You are given a set of integers in an unordered binary tree. Use an
array sorting routine to transform the tree into a heap that uses a balanced binary
tree as its underlying data structure.
*/

public static Node heapifyBinaryTree(Node root){
	int size = traverse(root, 0, null); //count nodes

	Node[] nodeArray = new Node[size];
	traverse(root, 0, nodeArray); //load nodes into array

	//sort array of nodes based on their values, using comparator oject
	Arrays.sort(nodeArray, new Comparator<Node>()){
		@Override public int compare(Node m, Node n){
			int mv = m.getValue(), nv = n.getValue();
			return (mv < nv? -1: (mv==nv? 0: 1));
		}
	});
	
	//Reassign children for each node
	for(int i = 0; i < size; i++){
		int left = 2*i +1;
		int right = left + 1;
		nodeArray[i].setLeft(left >=size? null: nodeArray[left]);
		nodeArray[i].setRight(right >= size? null: nodeArray[right]);
	}
	return nodeArray[0];//return new root node
}

public static int traverse(Node node, int count, Node[] arr){
	if(node == null)
		return count;
	if(arr != null)
		arr[count] = node;
	count++;
	count = traverse(node.getLeft(), count, arr);
	count = traverse(node.getRight(), count, arr);
	return count;
}