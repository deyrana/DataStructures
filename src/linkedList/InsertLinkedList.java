package linkedList;

public class InsertLinkedList {

	public static void main(String[] args) {
		LinkedList head = LinkedList.createLL();
		LinkedList.printLinkedList(head);

		head = insertAtBeginning(head, 23);
		System.out.println("LL after insertion in beginning - ");
		LinkedList.printLinkedList(head);

		head = insertAtEnd(head, 57);
		System.out.println("LL after insertion in end - ");
		LinkedList.printLinkedList(head);

		head = insertAtPos(head, 75, 6);
		System.out.println("LL after insertion in pos - ");
		LinkedList.printLinkedList(head);

	}

	public static LinkedList insertAtPos(LinkedList head, int target, int pos) {

		if(pos==1)
			return insertAtBeginning(head, target);
		
		LinkedList temp = head, node = new LinkedList(target);
		int count = 1;

		while (count < pos - 1 && temp != null) {
			temp = temp.next;
			++count;
		}
		
		if (temp != null) {
			node.next = temp.next;
			temp.next = node;
		}

		return head;
	}

	public static LinkedList insertAtEnd(LinkedList head, int target) {
		LinkedList node = new LinkedList(target);

		LinkedList temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;

		return head;
	}

	public static LinkedList insertAtBeginning(LinkedList head, int target) {
		LinkedList node = new LinkedList(target);
		node.next = head;
		return node;
	}

}
