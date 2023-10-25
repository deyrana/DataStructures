package queue;

public class Queue {
	
	int[] data;
	int cap, rear;
	public Queue(int cap) {
		this.cap = cap;
		data = new int[this.cap];
		rear = -1;
	}
	
	public void enqueue(int key) {
		int n = this.data.length;
		if(this.rear == cap-1) {
			System.out.println("Queue already full");
		} else {
			for(int i = n-2; i>=0; i--) {
				this.data[i+1] = this.data[i];
			}
			data[0] = key;
			++this.rear;
		}
	}
	
	public void dequeue() {
		if(this.rear==-1) {
			System.out.println("Queue is already empty");
			return;
		}
		this.data[rear] = 0;
		--this.rear;
	}
	
	public static void printQueue(Queue q) {
		if(q==null)
			return;
		for(int i =0; i<=q.rear; i++) {
			System.out.print(q.data[i]+" ");
		}
		
		System.out.println();
	}
	
	

}
