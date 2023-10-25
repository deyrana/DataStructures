package linkedList;

public class DoublyLinkedList {

	private int data;
	private DoublyLinkedList prev;
	private DoublyLinkedList next;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DoublyLinkedList getPrev() {
		return prev;
	}

	public void setPrev(DoublyLinkedList prev) {
		this.prev = prev;
	}

	public DoublyLinkedList getNext() {
		return next;
	}

	public void setNext(DoublyLinkedList next) {
		this.next = next;
	}

	public DoublyLinkedList(int data) {
		super();
		this.data = data;
		this.prev = null;
		this.next = null;
	}

	@Override
	public String toString() {
		return "DoublyLinkedList [data=" + data + ", prev=" + prev + ", next=" + next + "]";
	}
	
	public static DoublyLinkedList createDublyLL() {
		DoublyLinkedList dll1 = new DoublyLinkedList(1);
		
		DoublyLinkedList dll2 = new DoublyLinkedList(2);
		dll1.next = dll2;
		dll2.prev = dll1;
		
		DoublyLinkedList dll3 = new DoublyLinkedList(3);
		dll2.next = dll3;
		dll3.prev = dll2;
		
		DoublyLinkedList dll4 = new DoublyLinkedList(4);
		dll3.next = dll4;
		dll4.prev = dll3;
		
		return dll1;
	}
	
	public static void printDoublyLL(DoublyLinkedList head) {
		
		System.out.println(head.toString());
		System.out.println("Print DLL forward");
		DoublyLinkedList temp = head;
		while(temp.next!=null) {
			if(temp.prev==null) {
				System.out.print(temp.data);
			} else {
				System.out.print("->"+temp.data);
			}
			temp = temp.next;
		}
		
	}

}
