package heap;

import binaryTree.BinaryTree;
import binaryTree.BinaryTreePractice;
import binaryTree.ConstructBT;

public class HeapPractice {

	public static void main(String[] args) {
//		BinaryTree root = new BinaryTree(100);
//		root.left = new BinaryTree(50);
//		root.right = new BinaryTree(70);
//		root.left.left = new BinaryTree(20);
//		root.left.right = new BinaryTree(30);
//		root.right.left = new BinaryTree(60);
//		root.right.right = new BinaryTree(40);
		
		
//		BinaryTree root = ConstructBT.buildTree("50 25 28 12 10 N 23");
////		BreadthFirstSearch.levelOrderTraversal(root);
//		int isheap = isHeap(root);
//		System.out.println(isheap);
		
		int[] arr = new int[] {90, 15, 10, 7, 12, 2};
		boolean isHeap = isHeap(arr);
		System.out.println("isHeap - "+isHeap);
	}

	private static boolean isHeap(int[] arr) {
		int s = arr.length;
		for(int i=s-1; i>=0; i--) {
			int p = HeapOperations.parent(i);
			if(arr[i] > arr[p])
				return false;
		}
		return true;
	}

	public static int isHeap(BinaryTree root) {
		int totalNodes = BinaryTreePractice.countTotalNodes(root);
		boolean isCompleteBT = BinaryTreePractice.checkCompleteBTRecur(root, 0, totalNodes);
//		boolean isCompleteBT = BinaryTreePractice.checkCompleteBT(root);
		boolean isMaxHeap = checkMaxHeap(root);
		System.out.println("isCompleteBT - "+isCompleteBT);
		System.out.println("isMaxHeap - "+isMaxHeap);
		if(isCompleteBT && isMaxHeap)
			return 1;
		return 0;
	}

	public static boolean checkMaxHeap(BinaryTree root) {
		if(root == null)
			return true;
		int lkey = Integer.MIN_VALUE, rkey = Integer.MIN_VALUE;
		if(root.left != null)
			lkey = root.left.key;
		if(root.right != null)
			rkey = root.right.key;
		
		
		
		return (root.key > lkey) && (root.key > rkey) && checkMaxHeap(root.left) && checkMaxHeap(root.right);
	}

}
