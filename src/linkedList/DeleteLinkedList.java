package linkedList;

public class DeleteLinkedList {

	public static void main(String[] args) {
		LinkedList head = LinkedList.createLL();
		LinkedList.printLinkedList(head);

//		head = deleteFirst(head);
//		System.out.println("LL after deleteing 1st element - ");
//		LinkedList.printLinkedList(head);
//		
//		head = deleteLast(head);
//		System.out.println("LL after deleteing last element - ");
//		LinkedList.printLinkedList(head);

//		head = deleteAKey(head, 7);
//		System.out.println("LL after deleteing Key element - ");
//		LinkedList.printLinkedList(head);

//		head = deleteKeyRec(head, 1);
//		System.out.println("LL after deleteing Key element recursively - ");
//		LinkedList.printLinkedList(head);

		int pos = 9;
		head = deleteAtPos(head, pos);
		System.out.println("LL after deleting element at position " + pos + " - ");
		LinkedList.printLinkedList(head);

	}

	private static LinkedList deleteAtPos(LinkedList head, int pos) {
		LinkedList temp = head, prev = null;
		int count = 1;
		while (temp != null && count < pos) {
			prev = temp;
			temp = temp.next;
			++count;
		}

		// delete 1st element
		if (prev == null)
			return deleteFirst(head);
		// Pos not found
		else if (prev != null && temp == null) {
			System.out.println("The given postion " + pos + " does not exist");
			return head;
		}
		// delete the element
		else
			prev.next = temp.next;

		return head;
	}

	private static LinkedList deleteKeyRec(LinkedList head, int key) {

		if (head == null)
			return head;

		if (head.data == key) {
			// Not the last element
			if (head.next != null) {
				head.data = head.next.data;
				head.next = head.next.next;
			}
			// delete last element
			else {
				head = null;
			}
		} else {
			head.next = deleteKeyRec(head.next, key);
		}

		return head;
	}

	private static LinkedList deleteAKey(LinkedList head, int key) {

		LinkedList temp = head;
		LinkedList prev = null;
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}

		// delete 1st element
		if (prev == null)
			return deleteFirst(head);
		// delete key not found
		else if (prev != null && temp == null) {
			System.out.println("key " + key + " to delete not found");
			return head;
		}
		// delete the element
		else
			prev.next = temp.next;

		return head;
	}

	private static LinkedList deleteLast(LinkedList head) {
		LinkedList temp = head;

		while (temp.next.next != null)
			temp = temp.next;

		temp.next = null;

		return head;
	}

	public static LinkedList deleteFirst(LinkedList head) {
		if(head!=null)
			return head.next;
		return head;
	}

}
