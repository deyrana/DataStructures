package binarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;

import binaryTree.BinaryTree;
import binaryTree.BreadthFirstSearch;
import binaryTree.FindHeight;

public class BSTpractice {

	public static void main(String[] args) {
//		BinaryTree root = new BinaryTree(50);
//
//		root.left = new BinaryTree(30);
//		root.right = new BinaryTree(70);
//
//		root.left.left = new BinaryTree(20);
//		root.left.right = new BinaryTree(40);
//
//		root.right.left = new BinaryTree(60);
//		root.right.right = new BinaryTree(80);
//		
//		ArrayList<Integer> arr = new ArrayList<>();
//		arr = decOrderTraversal(root, arr);
//		
//		for(int i = 1; i<arr.size(); i++) {
//			int res = arr.get(i) + arr.get(i-1);
//			arr.set(i, res);
//		}
//		
//		root = modifyTree(root, arr);
//		BreadthFirstSearch.levelOrderTraversal(root);

//		System.out.println("Before conversion - ");
//		BreadthFirstSearch.levelOrderTraversal(root);
//		
//		root = convertToBST(root);
//		System.out.println("After conversion - ");
//		BreadthFirstSearch.levelOrderTraversal(root);

//		int kLargest = kthLargest(root, 2);

//		Boolean isBalanced = checkBalancedBST(root);
//		
//		System.out.println("isBalanced - "+isBalanced);

//		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//		BinaryTree root = arrayToBST(arr, 0, arr.length - 1);
//		BreadthFirstSearch.levelOrderTraversal(root);

//		int[] post = new int[] { 1, 7, 5, 50, 40, 10};
//		BinaryTree root = constructTree(post, post.length);
//		BreadthFirstSearch.levelOrderTraversal(root);
//		DepthFirstSearch.inOrderTraversal(root);
		
//		BreadthFirstSearch.levelOrderTraversal(root);
		
//		BinaryTree node = LCA(root, 20, 19);
//		System.out.println("LCA = "+node.key);
		
//		BinaryTree root = new BinaryTree(20);
//		root.left = new BinaryTree(8);
//		root.right = new BinaryTree(22);
//
//		root.left.left = new BinaryTree(4);
//		root.left.right = new BinaryTree(12);
//
//		root.left.right.left = new BinaryTree(10);
//		root.left.right.right = new BinaryTree(14);
		
//		BinaryTree root = buildTree("16 2 18 1 8 17 19 N N 6 10 N N N 20");
//		
//		int dist = DistBwNodes(root, 20, 17);
//		System.out.println(dist);
		
		Vector<Integer> v = new Vector<>();
		v.add(100); v.add(200);	v.add(300);	v.add(400);
		System.out.println(v.get(v.indexOf(200)+1));

	}
	
	private static int DistBwNodes(BinaryTree root, int n1, int n2) {
		int cnt1 = 0, cnt2 = 0;
		
		BinaryTree lca = LCA(root, n1, n2);
		BinaryTree temp = lca;
		
		while(temp.key != n1) {
			cnt1++;
			if (temp.key > n1) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		
		temp = lca;
		while(temp.key != n2) {
			cnt2++;
			if (temp.key > n2) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		
		return cnt1+cnt2;
	}

	static BinaryTree LCA(BinaryTree root, int n1, int n2) {

		if (root == null)
			return root;
		Queue<BinaryTree> q = new LinkedList<>();

		BinaryTree temp = root;

		while (temp.key != n1) {
			q.add(temp);
			if (temp.key > n1) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		q.add(temp);

		temp = root;
		BinaryTree res = root;
		while (temp.key != n2) {
			if (!q.isEmpty() && temp.key == q.peek().key) {
				res = q.poll();
			}

			if (temp.key > n2) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		
		if (!q.isEmpty() && temp.key == q.peek().key) {
			res = q.poll();
		}

		return res;
	}
	
	static BinaryTree buildTree(String str) {

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

	public static BinaryTree constructTree(int post[], int n) {

		BinaryTree root = preToBST(post, 0, n - 1);
		return root;
	}

	private static BinaryTree preToBST(int[] post, int start, int end) {

		if (start > end)
			return null;

		BinaryTree root = new BinaryTree(post[start]);
		int key = post[start];

		int[] left = new int[end - start], right = new int[end - start];
		int lcnt = 0, rcnt = 0;

		for (int i = start + 1; i <= end; i++) {
			if (post[i] < key) {
				left[lcnt++] = post[i];
			} else {
				right[rcnt++] = post[i];
			}
		}

		root.left = preToBST(left, 0, lcnt - 1);
		root.right = preToBST(right, 0, rcnt - 1);

		return root;
	}

	private static BinaryTree modifyTree(BinaryTree root, ArrayList<Integer> arr) {
		if (root == null)
			return root;

		root.right = modifyTree(root.right, arr);
		root.key = arr.get(0);
		arr.remove(0);
		root.left = modifyTree(root.left, arr);

		return root;
	}

	private static ArrayList<Integer> decOrderTraversal(BinaryTree root, ArrayList<Integer> arr) {

		if (root == null)
			return arr;

		arr = decOrderTraversal(root.right, arr);
		arr.add(root.key);
		arr = decOrderTraversal(root.left, arr);

		return arr;

	}

	private static BinaryTree arrayToBST(int[] arr, int start, int end) {

		if (start > end)
			return null;

		int mid = (start + end) / 2;
		BinaryTree root = new BinaryTree(arr[mid]);
		root.left = arrayToBST(arr, start, mid - 1);
		root.right = arrayToBST(arr, mid + 1, end);

		return root;
	}

	private static Boolean checkBalancedBST(BinaryTree root) {

		if (root == null)
			return Boolean.TRUE;

		int hLeft = FindHeight.findHeight(root.left);
		int hRight = FindHeight.findHeight(root.right);
		int hDiff = Math.abs(hRight - hLeft);

		if (hDiff <= 1 && checkBalancedBST(root.left) && checkBalancedBST(root.right))
			return Boolean.TRUE;

		return Boolean.FALSE;
	}

	private static int kthLargest(BinaryTree root, int k) {
		Vector<Integer> inorder = new Vector<>();
		inorder = constructArray(root, inorder);
		int n = inorder.size();

		return inorder.get(n - k);
	}

	private static BinaryTree convertToBST(BinaryTree root) {

		Vector<Integer> inorder = new Vector<>();
		inorder = constructArray(root, inorder);
		Collections.sort(inorder);

		root = constructProperBST(root, inorder);

		return root;
	}

	private static BinaryTree constructProperBST(BinaryTree root, Vector<Integer> inorder) {

		if (root == null)
			return root;

		root.left = constructProperBST(root.left, inorder);
		root.key = inorder.firstElement();
		inorder.remove(0);
		root.right = constructProperBST(root.right, inorder);

		return root;
	}

	private static Vector<Integer> constructArray(BinaryTree root, Vector<Integer> inorder) {

		if (root == null)
			return inorder;

		inorder = constructArray(root.left, inorder);
		inorder.add(root.key);
		inorder = constructArray(root.right, inorder);

		return inorder;
	}

}
