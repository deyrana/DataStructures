package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	public static void main(String[] args) {
		BinaryTree root = BinaryTree.createBT();

		levelOrderTraversal(root);
	}

	@SuppressWarnings("unused")
	public static void levelOrderTraversal(BinaryTree root) {
		if (root == null)
			return;
		Queue<BinaryTree> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {
			BinaryTree node = queue.poll();

			if (node == null) {
				System.out.println();
			} else {
				System.out.print(node.key + " ");
			}

			if (node != null) {
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			} else if (!queue.isEmpty()) {
				queue.add(null);
			}
		}

	}

	@SuppressWarnings("unused")
	public static void levelOrderTraversalChar(BinaryTree root) {
		if (root == null)
			return;
		Queue<BinaryTree> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {
			BinaryTree node = queue.poll();

			if (node == null) {
				System.out.println();
			} else {
				System.out.print(node.keyChar + " ");
			}

			if (node != null) {
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			} else if (!queue.isEmpty()) {
				queue.add(null);
			}
		}

	}

}
