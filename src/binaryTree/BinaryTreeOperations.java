package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeOperations {

	public static void main(String[] args) {
		BinaryTree root = BinaryTree.createBT();
		System.out.println("BT before insertion");
		BreadthFirstSearch.levelOrderTraversal(root);

//		root = insertInBT(root, 9);
//		System.out.println("BT after insertion");
//		BreadthFirstSearch.levelOrderTraversal(root);
//		System.out.println();
//		
//		DepthFirstSearch.inOrderTraversal(root);

		root = deleteInBT(root, 4);
		System.out.println("BT after deleting key " + 8);
		BreadthFirstSearch.levelOrderTraversal(root);

	}

	public static BinaryTree deleteInBT(BinaryTree root, int key) {

		if (root == null)
			return root;

		Queue<BinaryTree> queue = new LinkedList<>();
		queue.add(root);
		BinaryTree keyNode = null, deepestNode = null;

		while (!queue.isEmpty()) {
			BinaryTree temp = queue.poll();
			deepestNode = temp;

			if (temp.key == key) {
				System.out.println("The given key " + key + " found in the Binary Tree");
				keyNode = temp;
			}

			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);

		}

		if (keyNode != null) {
			int x = deepestNode.key;
			deleteDeepest(root, deepestNode);
			keyNode.key = x;
		}

		return root;

	}

	public static void deleteDeepest(BinaryTree root, BinaryTree delNode) {

		Queue<BinaryTree> queue = new LinkedList<>();
		queue.add(root);
		BinaryTree node = null;

		while (!queue.isEmpty()) {
			node = queue.poll();

			if (node == delNode) {
				node = null;
				return;
			}

			if (node.right != null) {
				if (node.right == delNode) {
					node.right = null;
					return;
				} else {
					queue.add(node.right);
				}
			}

			if (node.left != null) {
				if (node.left == delNode) {
					node.left = null;
					return;
				} else {
					queue.add(node.left);
				}
			}

		}

	}

	public static BinaryTree insertInBT(BinaryTree root, int key) {
		if (root == null)
			return root;
		Queue<BinaryTree> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			BinaryTree node = queue.poll();

			if (node.left == null) {
				node.left = new BinaryTree(key);
				break;
			} else {
				queue.add(node.left);
			}

			if (node.right == null) {
				node.right = new BinaryTree(key);
				break;
			} else {
				queue.add(node.right);
			}
		}

		return root;
	}

}
