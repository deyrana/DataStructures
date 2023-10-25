package linkedList;

public class LinkedList {

	int data;
	LinkedList next;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public LinkedList getNext() {
		return next;
	}

	public void setNext(LinkedList next) {
		this.next = next;
	}

	public LinkedList(int data, LinkedList next) {
		super();
		this.data = data;
		this.next = next;
	}

	public LinkedList(int data) {
		super();
		this.data = data;
		this.next = null;
	}
	
	

	public LinkedList() {
		super();
	}

	public static LinkedList createLL() {
		LinkedList head = new LinkedList(1, new LinkedList(2, new LinkedList(3, new LinkedList(4, new LinkedList(5)))));
		return head;
	}
	
	public static LinkedList createCircularLL() {
		LinkedList head = new LinkedList(1, new LinkedList(2, new LinkedList(3, new LinkedList(4, new LinkedList(5)))));
		LinkedList temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		
		temp.next = head;
		
		return head;
	}
	
	public static LinkedList createLoopedLL() {
		LinkedList head = new LinkedList(1);
		
		LinkedList node2 = new LinkedList(2);
		head.next = node2;
		
		LinkedList node3 = new LinkedList(3);
		node2.next = node3;
		
		LinkedList node4 = new LinkedList(4);
		node3.next = node4;
		
		LinkedList node5 = new LinkedList(5);
		node4.next = node5;
		
		node5.next = node3;
		
		return head;
		
	}
	
	public static LinkedList createLLfromArray(int[] arr) {
		LinkedList head = null, temp = null;
		int n = arr.length;
		
		for(int i=0; i<n;i++) {
			if(i==0) {
				head = new LinkedList(arr[i]);
				temp = head;
			} else {
				temp.next = new LinkedList(arr[i]);
				temp = temp.next;
			}
		}
		
		
		return head;
	}

	public static void printLinkedList(LinkedList head) {

		LinkedList temp = head;
		while (temp != null) {
			if (temp != head)
				System.out.print("->" + temp.data);
			else
				System.out.print(temp.data);
			temp = temp.next;
		}
		System.out.println();

	}

	@Override
	public String toString() {
		return "LinkedList [data=" + data + ", next=" + next + "]";
	}

}
