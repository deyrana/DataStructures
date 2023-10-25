package linkedList;

import java.util.HashSet;
import java.util.Map;

public class LinkedListPractice {

	public static void main(String[] args) {
//		LinkedList head = LinkedList.createLL();
//		System.out.println("The OG LinkedList - ");
//		LinkedList.printLinkedList(head);
//		findMiddle(head);

//		LinkedList head = LinkedList.createCircularLL();
//		
//		boolean isCircular = checkCircularSlowFast(head);
//		System.out.println("isCircular - "+isCircular);

//		LinkedList head = LinkedList.createLoopedLL();
//		LinkedList head = LinkedList.createLL();
//		boolean isLoop = checkLoopLL(head);
//		boolean isLoop = checkLoopLL2Node(head);
//		System.out.println("isLoop - "+isLoop);

//		LinkedList head = LinkedList.createLL();
//		head = InsertLinkedList.insertAtPos(head, 6, 6);
//		LinkedList.printLinkedList(head);
//		
//		head = removeDuplicateSorted(head);
//		System.out.println("LL after removing duplicates - ");
//		LinkedList.printLinkedList(head);

//		LinkedList head1 = LinkedList.createLLfromArray(new int[] { 1, 2, 3, 4, 5, 6 });
//		LinkedList head2 = LinkedList.createLLfromArray(new int[] {5,6, 7, 8, 9, 10, 11 });
//		System.out.print("List 1=> ");
//		LinkedList.printLinkedList(head1);
//
//		System.out.print("List 2=> ");
//		LinkedList.printLinkedList(head2);
//
//		LinkedList result = createIntersectionList(head1, head2);
//		System.out.println("Intersected List - ");
//		LinkedList.printLinkedList(result);

//		LinkedList head1 = LinkedList.createLLfromArray(new int[] { 1, 3, 5, 7, 9, 11, 15 });
//		LinkedList head2 = LinkedList.createLLfromArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 });
//		System.out.print("List 1=> ");
//		LinkedList.printLinkedList(head1);
//
//		System.out.print("List 2=> ");
//		LinkedList.printLinkedList(head2);
//
//		LinkedList result = mergeSortedList(head1, head2);
//		System.out.println("merged Sorted List - ");
//		LinkedList.printLinkedList(result);
		
		LinkedList head = LinkedList.createLLfromArray(new int[] {2,9,8,12,7,10});
		System.out.print("OG list=> ");
		LinkedList.printLinkedList(head);
		LinkedList result = modifyList(head);
		System.out.println("Result - ");
		LinkedList.printLinkedList(result);
		

	}

	private static LinkedList modifyList(LinkedList head) {
		LinkedList temp = head, temp2 = null, rev = null;
		int len = 0, cnt = 0;

		while (temp != null) {
			++len;
			if (rev == null) {
				rev = new LinkedList(temp.data);
				temp2 = rev;
			} else {
				temp2.next = new LinkedList(temp.data);
				temp2 = temp2.next;
			}
			temp = temp.next;

		}

		rev = ReverseLinkedList.reverseLinkedList(rev);
		System.out.println("Rev LL - ");
		LinkedList.printLinkedList(rev);
		LinkedList ptr1 = head, ptr2 = rev;

		while (ptr1 != null && cnt < (len / 2)) {
			++cnt;
			ptr1.data = ptr1.data - ptr2.data;

			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		return head;
	}

	private static LinkedList mergeSortedList(LinkedList head1, LinkedList head2) {
		LinkedList temp1 = head1, temp2 = head2, result = null, temp3 = null;

		while (temp1 != null && temp2 != null) {
			if (temp1.data <= temp2.data) {
				if (result == null) {
					result = new LinkedList(temp1.data);
					temp3 = result;
				} else {
					temp3.next = new LinkedList(temp1.data);
					temp3 = temp3.next;
				}
				temp1 = temp1.next;
			} else {

				if (result == null) {
					result = new LinkedList(temp2.data);
					temp3 = result;
				} else {
					temp3.next = new LinkedList(temp2.data);
					temp3 = temp3.next;
				}
				temp2 = temp2.next;

			}
		}

		while (temp1 != null) {
			temp3.next = new LinkedList(temp1.data);
			temp3 = temp3.next;
			temp1 = temp1.next;
		}

		while (temp2 != null) {
			temp3.next = new LinkedList(temp2.data);
			temp3 = temp3.next;
			temp2 = temp2.next;
		}

		return result;
	}

	private static LinkedList createIntersectionList(LinkedList head1, LinkedList head2) {

		LinkedList temp1 = head1, temp2 = head2, result = null, temp3 = null;
		while (temp1 != null && temp2 != null) {
			if (temp1.data == temp2.data) {
				if (result == null) {
					result = new LinkedList(temp1.data);
					temp3 = result;
				} else {
					temp3.next = new LinkedList(temp1.data);
					temp3 = temp3.next;
				}
				temp1 = temp1.next;
				temp2 = temp2.next;
			} else if (temp1.data < temp2.data) {
				temp1 = temp1.next;
			} else {
				temp2 = temp2.next;
			}
		}

		return result;
	}

	private static LinkedList removeDuplicateSorted(LinkedList head) {
		if (head == null || head.next == null)
			return head;

		LinkedList prev = head, cur = head.next;

		while (cur != null) {
			if (prev.data == cur.data) {
				prev.next = cur.next;
			} else {
				prev = prev.next;
			}
			cur = cur.next;
		}

		return head;
	}

	private static boolean checkLoopLL2Node(LinkedList head) {
		if (head == null || head.next == null)
			return true;

		LinkedList slow = head, fast = head;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				return true;
		}

		return false;
	}

	private static boolean checkLoopLL(LinkedList head) {
		if (head == null || head.next == null)
			return true;

		HashSet<LinkedList> set = new HashSet<>();

		LinkedList temp = head;

		while (temp != null) {
			if (set.contains(temp))
				return true;
			set.add(temp);
			temp = temp.next;
		}

		return false;
	}

	private static boolean checkCircular(LinkedList head) {
		LinkedList temp = head;

		while (temp.next != null) {
			if (head == temp.next)
				return true;
			temp = temp.next;
		}

		return false;
	}

	private static boolean checkCircularSlowFast(LinkedList head) {
		LinkedList slow = head, fast = head.next;

		while (fast != null && fast.next != null) {
			if (slow == fast)
				return true;

			slow = slow.next;
			fast = fast.next.next;
		}

		return false;
	}

	private static void findMiddle(LinkedList head) {
		LinkedList fast = head, slow = head;

		if (head == null)
			System.out.println("Linked List is empty");

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast.next == null)
			System.out.println("the middle element is - " + slow.data);
		else if (fast.next.next == null)
			System.out.println("the middle element is - " + slow.next.data);
	}

}
