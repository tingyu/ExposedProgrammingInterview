/**
Height of a Tree

PROBLEM  The height of a tree (binary or not) is defined to be the maximum
distance from the root node to any leaf node. The tree in Figure 5-2, for example,
has a height of 4 because the path from A to F, G, or H involves four nodes.
Write a function to calculate the height of an arbitrary binary tree.
*/

//The Height of a tree equals the height of its tallest subtree plus one
//since the operation on each node are constant time, the overall running time is O(n)
public static int treeHeight(Node n){
	int(n == null) return 0;
	return 1 + Math.max(treeHeight(n.getLeft()).
						treeHeight(n.getRight());
}