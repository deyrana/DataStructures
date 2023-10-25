package binarySearchTree;

import binaryTree.BinaryTree;

public class CheckBST {

	public static void main(String[] args) {
		
		long before = System.currentTimeMillis();
		
		BinaryTree root = new BinaryTree(8);
		root.left = new BinaryTree(3);
		root.right = new BinaryTree(10);

		root.left.left = new BinaryTree(1);
		root.left.right = new BinaryTree(7);

		root.right.left = new BinaryTree(9);
		root.right.right = new BinaryTree(14);
		
		
//		Boolean isBST = checkBST(root);
//		System.out.println("isBST - "+isBST);
		
		Boolean isBST = checkBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println("isBST - "+isBST);
		
		long after = System.currentTimeMillis();
		
		System.out.println("Time elapsed - "+(after-before));
	}
	
	

	private static Boolean checkBST2(BinaryTree root, int minValue, int maxValue) {
		if(root == null)
			return true;
		
		if(root.key < minValue || root.key > maxValue)
			return false;
		
		return checkBST2(root.left, minValue, root.key-1) && 
				checkBST2(root.right, root.key+1, maxValue);
	}



	private static Boolean checkBST(BinaryTree root) {
		
		if(root==null)
			return true;
		
		int key = root.key;
		int leftMax = maxValue(root.left);
		int rightMin = minValue(root.right);
		
		if(key > leftMax && key < rightMin && checkBST(root.left) && checkBST(root.right))
			return true;
		
		return false;
	}
	
	private static Integer maxValue(BinaryTree root) {

		if(root==null)
			return Integer.MIN_VALUE;
		
		int val = root.key;
		int leftMax = maxValue(root.left);
		int rightMax = maxValue(root.right);
		
		return Integer.max(val, Integer.max(leftMax, rightMax));
	}
	
	private static Integer minValue(BinaryTree root) {

		if(root==null)
			return Integer.MAX_VALUE;
		
		int val = root.key;
		int leftMin = minValue(root.left);
		int rightMin = minValue(root.right);
		
		return Integer.min(val, Integer.min(leftMin, rightMin));
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
