package linkedList;

public class SearchLinkedList {
	
	public static void main(String[] args) {
		
		LinkedList head = LinkedList.createLL();
		LinkedList.printLinkedList(head);
//		LinkedList node = searchLL(head, 5);
//		if(node!=null)
//			System.out.println(node.toString());
		
//		int target = 6;
//		boolean isFound = find(head, target);
//		System.out.println(target+" isFound - "+isFound);
		
//		int l = findLLlength(head);
		int lrec = findLLlenRec(head);
		System.out.println("the length is "+lrec);
		
	}

	private static int findLLlenRec(LinkedList head) {
		if(head==null)
			return 0;
		return 1+findLLlenRec(head.next);
	}

	private static int findLLlength(LinkedList head) {
		int count = 0;
		LinkedList temp = head;
		while(temp!=null) {
			++count;
			temp = temp.next;
		}
		return count;
	}

	private static boolean find(LinkedList head, int target) {
		if(head==null)
			return false;
		
		if(head.data == target)
			return true;
		return find(head.next, target);
	}

	private static LinkedList searchLL(LinkedList head, int target) {
		LinkedList temp = head;
		
		while(temp!=null && temp.data!=target)
			temp = temp.next;
		
		if(temp!=null)
			System.out.println(target+" has been found");
		else
			System.out.println(target+" has not been found");
		
		return temp;
	}

	
	

}
