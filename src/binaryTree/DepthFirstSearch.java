package binaryTree;

public class DepthFirstSearch {

	public static void main(String[] args) {
		BinaryTree root = BinaryTree.createBT();
//		System.out.println(root);

//		inOrderTraversal(root);
//		preOrderTraaversal(root);
		postOrderTraversal(root);

	}

	public static void postOrderTraversal(BinaryTree root) {
		if (root == null)
			return;

		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.key + " ");

	}

	public static void preOrderTraversal(BinaryTree root) {
		if (root == null)
			return;

		System.out.print(root.key + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);

	}

	public static void inOrderTraversal(BinaryTree root) {

		if (root == null)
			return;

		inOrderTraversal(root.left);
		System.out.print(root.key + " ");
		inOrderTraversal(root.right);

	}
	
	public static void inOrderTraversalChar(BinaryTree root) {

		if (root == null)
			return;

		inOrderTraversalChar(root.left);
		System.out.print(root.keyChar + " ");
		inOrderTraversalChar(root.right);

	}

}
