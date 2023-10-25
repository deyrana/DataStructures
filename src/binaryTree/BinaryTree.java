package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	public Integer key;
	public Character keyChar;
	public BinaryTree left, right;

	public BinaryTree(Integer key) {
		super();
		this.key = key;
		this.left = null;
		this.right = null;
	}

	public BinaryTree(Character keyChar) {
		super();
		this.keyChar = keyChar;
		this.left = null;
		this.right = null;
	}

	public BinaryTree() {
		super();
		this.key = null;
		this.keyChar = null;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return "BinaryTree [key=" + key + ", left=" + left + ", right=" + right + "]";
	}

	public String toStringChar() {
		return "BinaryTree [keyChar=" + keyChar + ", left=" + left.toStringChar() + ", right=" + right.toStringChar()
				+ "]";
	}

	public static BinaryTree createBT() {
		BinaryTree root = new BinaryTree(1);

		root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);

		root.left.left = new BinaryTree(4);
		root.left.right = new BinaryTree(5);

		root.left.left.left = new BinaryTree(8);

		root.right.left = new BinaryTree(6);
		root.right.right = new BinaryTree(7);

		return root;
	}

	public static BinaryTree findDeepestNode(BinaryTree root) {
		if (root == null)
			return root;
		Queue<BinaryTree> queue = new LinkedList<>();
		queue.add(root);
		BinaryTree node = null;

		while (!queue.isEmpty()) {
			node = queue.poll();

			if (node.left != null) {
				queue.add(node.left);
			}

			if (node.right != null) {
				queue.add(node.right);
			}

		}

		return node;
	}

}
