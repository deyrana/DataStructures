package binaryTree;

public class FindHeight {

	public static void main(String[] args) {
		BinaryTree root = BinaryTree.createBT();
		
		int height = findHeight(root);
		System.out.println("Height of BT is - "+height);

	}

	public static int findHeight(BinaryTree root) {
		
		if(root==null) {
			return 0;
		}
		
		int h = 1 + Integer.max(findHeight(root.left), findHeight(root.right));
		
		return h;
	}

}
