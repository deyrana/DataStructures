package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BinaryTreePractice {
	

	public static void main(String[] args) {

//		BinaryTree root = new BinaryTree(44);
//		root.left = new BinaryTree(10);
//		root.right = new BinaryTree(12);
//
//		root.left.left = new BinaryTree(7);
//		root.left.right = new BinaryTree(3);
//
//		root.right.left = new BinaryTree(4);
//		root.right.right = new BinaryTree(8);

//		boolean isSum = checkSumTree(root);
//		System.out.println("isSum - " + isSum);

//		BinaryTree root = new BinaryTree(6);
//		root.left = new BinaryTree(3);
//		root.right = new BinaryTree(5);
//
//		root.left.left = new BinaryTree(7);
//		root.left.right = new BinaryTree(8);
//
//		root.right.left = new BinaryTree(1);
//		root.right.right = new BinaryTree(13);

//		MapData mapData = createMap(root);
//
//		Boolean isCounsin = checkCousin(mapData, root.left.right, root.right.left);
//		System.out.println("isCounsin - " + isCounsin);
		
		
		BinaryTree root = new BinaryTree(6);
		root.left = new BinaryTree(3);
		root.right = new BinaryTree(5);

		root.left.left = new BinaryTree(7);
		root.left.right = new BinaryTree(8);

		root.right.left = new BinaryTree(1);
		root.right.right = new BinaryTree(13);
		
//		int h = FindHeight.findHeight(root);
//		
//		Boolean isPerfectBT = chechPerfectBT(root, h-1, 0);
//		System.out.println("isPerfectBT - "+isPerfectBT);
//		
//		Boolean isCompleteBT = checkCompleteBT(root, h-1, 0);
//		System.out.println("isCompleteBT - "+isCompleteBT);
		
//		int size = findSizeBT(root);
//		System.out.println("size - "+size);\
		
		BinaryTree root2 = new BinaryTree(6);
		root2.left = new BinaryTree(3);
		root2.right = new BinaryTree(5);

		root2.left.left = new BinaryTree(7);
		root2.left.right = new BinaryTree(8);

		root2.right.left = new BinaryTree(1);
		root2.right.right = new BinaryTree(123);
		
		Boolean isIdentical = checkIdentical(root, root2);
		System.out.println("isIdentical - "+isIdentical);

	}

	private static Boolean checkIdentical(BinaryTree root, BinaryTree root2) {
		if(root==null && root2==null)
			return true;
		else if(root==null && root2!=null)
			return false;
		else if(root!=null && root2==null)
			return false;
		
		if(root.key == root2.key && checkIdentical(root.left, root2.left) && checkIdentical(root.right, root2.right))
			return true;
		
		return false;
	}

	public static int findSizeBT(BinaryTree root) {
		
		if(root==null)
			return 0;
		
		return 1 + findSizeBT(root.left) + findSizeBT(root.right);
	}

//	public static Boolean checkCompleteBT(BinaryTree root, int h, int level) {
//		// Leaf nodes
//		if (level == h) {
//			if (root.left == null && root.right == null) {
//				return true;
//			} else {
//				return false;
//			}
//		}
//		// Internal nodes
//		else {
//			if (root.left != null && root.right != null && checkCompleteBT(root.left, h, level + 1)
//					&& checkCompleteBT(root.right, h, level + 1)) {
//				return true;
//			} else if (root.left != null && root.right == null && checkCompleteBT(root.left, h, level + 1)) {
//				return true;
//			} else if (root.left == null && root.right == null ) {
//				return true;
//			}
//			else {
//				return false;
//			}
//		}
//	}
	
	public static boolean checkCompleteBT(BinaryTree root) {

		if (root == null)
			return true;

		Queue<BinaryTree> queue = new LinkedList<>();
		ArrayList<Integer> ar = new ArrayList<Integer>();
		queue.add(root);
		ar.add(root.key);
		
		

		while (!queue.isEmpty()) {
			BinaryTree node = queue.poll();

			if (node.left != null) {
				ar.add(node.left.key);
				queue.add(node.left);
			} else {
				ar.add(Integer.MIN_VALUE);
			}
			if (node.right != null) {
				ar.add(node.right.key);
				queue.add(node.right);
			} else {
				ar.add(Integer.MIN_VALUE);
			}
		}
		
		while(!ar.isEmpty()) {
			Integer i = ar.remove(0);
			if(i == Integer.MIN_VALUE && !ar.isEmpty() && ar.get(0) != Integer.MIN_VALUE)
				return false;
		}

		return true;
	}
	
	public static boolean checkCompleteBTRecur(BinaryTree root, int i, int totalNodes) {
		if(root == null)
			return true;
		
		if(i >= totalNodes)
			return false;
		return checkCompleteBTRecur(root.left, 2*i+1, totalNodes) && checkCompleteBTRecur(root.right, 2*i+2, totalNodes);
		
	}
	
	public static int countTotalNodes(BinaryTree root) {
		if(root == null) {
			return 0;
		}
		
		return 1 + countTotalNodes(root.left) + countTotalNodes(root.right);
	}
	
//	public static boolean checkCompleteBT(BinaryTree root, int h) {
//
//		if (root == null)
//			return true;
//
//		int level = 0;
//		Queue<BinaryTree> queue = new LinkedList<>();
//		queue.add(root);
//		queue.add(null);
//		boolean flag = false;
//
//		while (!queue.isEmpty()) {
//			BinaryTree node = queue.poll();
//
//			if (node == null) {
//				flag = false;
//				++level;
//			}
//
//			if (node != null) {
//				if (node.left != null) {
//					if (flag) {
//						return false;
//					}
//					queue.add(node.left);
//				} else {
//					if (level + 1 < h)
//						return false;
//					flag = true;
//				}
//				if (node.right != null) {
//					if (flag) {
//						return false;
//					}
//					queue.add(node.right);
//				} else {
//					if (level + 1 < h)
//						return false;
//					flag = true;
//				}
//			} else if (!queue.isEmpty()) {
//				queue.add(null);
//			}
//		}
//
//		return true;
//	}

	private static Boolean chechPerfectBT(BinaryTree root, int h, int level) {

		// Leaf nodes
		if (level == h) {
			if (root.left == null && root.right == null) {
				return true;
			} else {
				return false;
			}
		}
		// Internal nodes
		else {
			if (root.left != null && root.right != null 
					&& chechPerfectBT(root.left, h, level + 1)
					&& chechPerfectBT(root.right, h, level + 1)) {
				return true;
			} else {
				return false;
			}
		}
	}

	private static Boolean checkCousin(MapData mapData, BinaryTree node1, BinaryTree node2) {

		Map<BinaryTree, Integer> levelMap = mapData.getLevelMap();
		Map<BinaryTree, BinaryTree> parentMap = mapData.getParentMap();

		System.out.println("Info on Node 1");
		System.out.println(
				"Key - " + node1.key + "; level - " + levelMap.get(node1) + "; Parent - " + parentMap.get(node1).key);
		System.out.println("Info on Node 2");
		System.out.println(
				"Key - " + node2.key + "; level - " + levelMap.get(node2) + "; Parent - " + parentMap.get(node2).key);

		Boolean isCousin = (levelMap.get(node1) == levelMap.get(node2))
				&& (parentMap.get(node1) != parentMap.get(node2));

		return isCousin;
	}

	private static boolean checkSameLevel(BinaryTree left, BinaryTree right, Map<BinaryTree, Integer> map) {
		return map.get(left) == map.get(right);
	}

	private static MapData createMap(BinaryTree root) {

		Queue<BinaryTree> queue = new LinkedList<>();
		Map<BinaryTree, Integer> levelMap = new HashMap<>();
		Map<BinaryTree, BinaryTree> parentMap = new HashMap<>();

		if (root == null)
			return new MapData();

		queue.add(root);
		queue.add(null);
		int level = 0;

		while (!queue.isEmpty()) {
			BinaryTree node = queue.poll();

			if (node != null) {
				levelMap.put(node, level);
			} else {
				++level;
			}

			if (node != null) {
				if (node.left != null) {
					queue.add(node.left);
					parentMap.put(node.left, node);
				}
				if (node.right != null) {
					queue.add(node.right);
					parentMap.put(node.right, node);
				}
			} else if (!queue.isEmpty()) {
				queue.add(null);
			}
		}

		MapData md = new MapData();
		md.setLevelMap(levelMap);
		md.setParentMap(parentMap);

		return md;
	}

	static class MapData {
		private Map<BinaryTree, Integer> levelMap;
		private Map<BinaryTree, BinaryTree> parentMap;

		public Map<BinaryTree, Integer> getLevelMap() {
			return levelMap;
		}

		public void setLevelMap(Map<BinaryTree, Integer> levelMap) {
			this.levelMap = levelMap;
		}

		public Map<BinaryTree, BinaryTree> getParentMap() {
			return parentMap;
		}

		public void setParentMap(Map<BinaryTree, BinaryTree> parentMap) {
			this.parentMap = parentMap;
		}

	}

	private static boolean checkSumTree(BinaryTree root) {
		if (root == null || (root.left == null && root.right == null))
			return true;

		int leftSum = findSum(root.left);
		int rightSum = findSum(root.right);

		if (root.key == leftSum + rightSum && checkSumTree(root.left) && checkSumTree(root.right))
			return true;

		return false;
	}

	private static int findSum(BinaryTree root) {

		if (root == null)
			return 0;

		return root.key + findSum(root.left) + findSum(root.right);
	}

}
