package binarySearchTree;

import binaryTree.BinaryTree;
import binaryTree.BreadthFirstSearch;

public class InsertBST {

	public static void main(String[] args) {
//		BinaryTree root = new BinaryTree(100);
//		
//		root.left = new BinaryTree(20);
//		root.right = new BinaryTree(500);
//		
//		root.left.left = new BinaryTree(10);
//		root.left.right = new BinaryTree(30);
//		System.out.println("Tree before insertion - ");
//		BreadthFirstSearch.levelOrderTraversal(root);
//		root = insertNode(root, 40);
//		
//		System.out.println("Tree after insertion - ");
//		BreadthFirstSearch.levelOrderTraversal(root);
		
		
		int arr[] = new int[] {100, 20, 50, 10, 30,110, 70, 130};
		BinaryTree root = null;
		
		for(int i=0; i<arr.length; i++) {
			root = insertNode(root, arr[i]);
		}
		
	}

	private static BinaryTree insertNode(BinaryTree root, int key) {

		if(root==null)
			return new BinaryTree(key);
		
		// Insert a new node at leaf
		if (root.left == null && root.right == null) {
			if (root.key > key)
				root.left = new BinaryTree(key);
			else
				root.right = new BinaryTree(key);
		}
		// Keep searching for right leaf
		else {
			if (root.key > key)
				root.left = insertNode(root.left, key);
			else
				root.right = insertNode(root.right, key);
		}

		return root;
	}

}
