package linkedList;

import java.util.Stack;

public class ReverseLinkedList {

	public static void main(String[] args) {
		
		LinkedList head = LinkedList.createLL();
		System.out.println("The OG linked list - ");
		LinkedList.printLinkedList(head);
		
//		head = reverseLinkedList(head);
//		System.out.println("The reversed linked list - ");
//		LinkedList.printLinkedList(head);
//		
//		head = reverseLinkedListRec(head);
//		System.out.println("The reversed linked list recursive - ");
//		LinkedList.printLinkedList(head);
		
		head = reverseLLusingStack(head);
		System.out.println("The reversed linked list using stack - ");
		LinkedList.printLinkedList(head);
		
		
	}

	private static LinkedList reverseLLusingStack(LinkedList head) {
		
		if(head == null)
			return head;
		
		Stack<LinkedList> st = new Stack<>();
		LinkedList temp = head;
		while(temp.next!=null) {
			st.push(temp);
			temp = temp.next;
		}
		head = temp;
		
		while(!st.isEmpty()) {
			
			temp.next = st.peek();
			st.pop();
			temp = temp.next;
		}
		temp.next = null;
		
		
		return head;
	}

	private static LinkedList reverseLinkedListRec(LinkedList head) {
		
		if(head == null || head.next == null)
			return head;
		
		LinkedList rest = reverseLinkedListRec(head.next);
		head.next.next = head;
		
		head.next = null;
		
		return rest;
	}

	public static LinkedList reverseLinkedList(LinkedList head) {
		if(head==null || head.next == null)
			return head;
		
		LinkedList cur = head, next = head.next, prev = null;
		
		while(next!=null) {
			cur.next = prev;
			prev = cur;
			cur = next;
			next = next.next;
		}
		
		cur.next = prev;
		
		
		return cur;
	}

}
