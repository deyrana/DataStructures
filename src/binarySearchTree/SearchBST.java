package binarySearchTree;

import binaryTree.BinaryTree;
import binaryTree.BreadthFirstSearch;

public class SearchBST {

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(100);

		root.left = new BinaryTree(20);
		root.right = new BinaryTree(500);

		root.left.left = new BinaryTree(10);
		root.left.right = new BinaryTree(30);
		System.out.println("Tree - ");
		BreadthFirstSearch.levelOrderTraversal(root);
		
		Boolean isFound = searchBST(root, 31);
		System.out.println("isFound - "+isFound);
		
	}

	private static Boolean searchBST(BinaryTree root, int key) {
		if(root==null)
			return false;
		
		if(root.key == key)
			return true;
		else if(root.key > key)
			return searchBST(root.left, key);
		else 
			return searchBST(root.right, key);
	}

}
