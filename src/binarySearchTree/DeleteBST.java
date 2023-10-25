package binarySearchTree;

import binaryTree.BinaryTree;
import binaryTree.BreadthFirstSearch;

public class DeleteBST {

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(50);

		root.left = new BinaryTree(30);
		root.right = new BinaryTree(70);

		root.left.left = new BinaryTree(20);
		root.left.right = new BinaryTree(40);

		root.right.left = new BinaryTree(60);
		root.right.right = new BinaryTree(80);

		System.out.println("BST before deletion - ");
		BreadthFirstSearch.levelOrderTraversal(root);

		root = deleteNodeBST(root, 50);
		System.out.println("BST after deletion - ");
		BreadthFirstSearch.levelOrderTraversal(root);

	}

	
	/* ALGORITHM
	 * 
	 * 1. Recursively search through the tree for the node to be deleted
	 * 2. Once node found, check if node has 1/0 child or 2 children
	 * 3. In case of 0/1 child, just replace the given node with their right/left child
	 * 4. in case of 2 child, find the in-order successor of the given node, i.e., 
	 * 	  the leftmost node to the right of given node to be deleted
	 * 5. Now substitute the successors right to the parents left/right depending on situation
	 * 6. Replace the key value of the given node with successors value
	 * 
	 * */
	private static BinaryTree deleteNodeBST(BinaryTree root, int key) {

		if (root == null)
			return root;

		if (root.key > key)
			root.left = deleteNodeBST(root.left, key);
		else if (root.key < key)
			root.right = deleteNodeBST(root.right, key);
		else {
			// 0/1 Child case
			if (root.left == null) {
				BinaryTree node = root.right;
				return node;
			} else if (root.right == null) {
				BinaryTree node = root.left;
				return node;
			} else {
				BinaryTree succParent = root, succ = root.right;

				// Find Inorder successor - i.e. - leftmost node
				while (succ.left != null) {
					succParent = succ;
					succ = succ.left;
				}

				if (succParent != root) {
					succParent.left = succ.right;
				} else {
					succParent.right = succ.right;
				}

				root.key = succ.key;
			}
		}

		return root;
	}

}
