package binaryTree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ConstructBT {

	static int preIndex = 0;

	public static void main(String[] args) {

//		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
//      char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
//		int len = in.length;
//        
//		BinaryTree root = buildTreePreIn(in, pre, 0, len-1);
//		DepthFirstSearch.inOrderTraversalChar(root);

		int in[] = new int[] { 4, 8, 10, 12, 14, 20, 22 };
		int level[] = new int[] { 20, 8, 22, 4, 12, 10, 14 };

		BinaryTree root = buildTreeInLevel(in, level, 0, in.length - 1);

		System.out.print("InOrder=> ");
		DepthFirstSearch.inOrderTraversal(root);
		System.out.println();
		System.out.print("Level order=> ");
		BreadthFirstSearch.levelOrderTraversal(root);

	}

	private static BinaryTree buildTreeInLevel(int[] in, int[] level, int inStart, int inEnd) {

		if (inStart > inEnd)
			return null;

		// first element of level order is root
		BinaryTree node = new BinaryTree(level[0]);

		if (inStart == inEnd)
			return node;

		int inIndex = search(in, node.key, inStart, inEnd);
		HashSet<Integer> leftSet = new HashSet<>();
		HashSet<Integer> rightSet = new HashSet<>();

		for (int i = inStart; i <= inIndex - 1; i++) {
			leftSet.add(in[i]);
		}
		for (int i = inIndex + 1; i <= inEnd; i++) {
			rightSet.add(in[i]);
		}

		int left[] = new int[inIndex - inStart], right[] = new int[inEnd - inIndex];
		int leftCount = 0, rightCount = 0;

		for (int i = 1; i < level.length; i++) {
			int levelKey = level[i];
			if (!leftSet.isEmpty() && leftSet.contains(levelKey)) {
				left[leftCount++] = levelKey;
				leftSet.remove(levelKey);
			} else if (!rightSet.isEmpty() && rightSet.contains(levelKey)) {
				right[rightCount++] = levelKey;
				rightSet.remove(levelKey);
			}
		}

		node.left = buildTreeInLevel(in, left, inStart, inIndex - 1);
		node.right = buildTreeInLevel(in, right, inIndex + 1, inEnd);

		return node;
	}

	private static boolean arrayContains(int[] in, int levelInt, int inStart, int inEnd) {

		for (int i = inStart; i <= inEnd; i++) {
			if (levelInt == in[i])
				return true;
		}

		return false;
	}
	
	
	/* ALGORITHM
	 * 
	 * 1. Make the 1st element of preorder as root
	 * 2. find the index of root in inorder
	 * 3. Now the elements in inorder to the left of index belong to left subtree and vice versa
	 * 4. recursively call the function for constructing left and right subtree.
	 * 
	 * */
	private static BinaryTree buildTreePreIn(char[] in, char[] pre, int inStart, int inEnd) {

		if (inStart > inEnd)
			return null;

		BinaryTree node = new BinaryTree(pre[preIndex++]);

		if (inStart == inEnd)
			return node;

		int inIndex = searchChar(in, node.keyChar, inStart, inEnd);

		if (inIndex != -1) {
			node.left = buildTreePreIn(in, pre, inStart, inIndex - 1);
			node.right = buildTreePreIn(in, pre, inIndex + 1, inEnd);
		}

		return node;
	}

	private static int searchChar(char[] in, Character keyChar, int inStart, int inEnd) {

		for (int i = inStart; i <= inEnd; i++) {
			if (in[i] == keyChar)
				return i;
		}

		return -1;
	}

	private static int search(int[] in, int key, int inStart, int inEnd) {

		for (int i = inStart; i <= inEnd; i++) {
			if (in[i] == key)
				return i;
		}

		return -1;
	}
	
	public static BinaryTree buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		BinaryTree root = new BinaryTree(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<BinaryTree> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			BinaryTree currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new BinaryTree(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new BinaryTree(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

}
