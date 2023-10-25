package queue;

import java.util.Stack;

public class QueueUsingStack {

	public static void main(String[] args) {
		Stack<Integer> queue = new Stack<>();
		queue = enqueue(queue, 1);
		queue = enqueue(queue, 2);
		queue = enqueue(queue, 3);
		queue = enqueue(queue, 4);
		System.out.println("OG Queue=> "+queue);
		queue = dequeue(queue);
		System.out.println(queue);
		
		queue = dequeue(queue);
		System.out.println(queue);
		
		queue = enqueue(queue, 5);
		System.out.println(queue);
	}

	private static Stack<Integer> dequeue(Stack<Integer> queue) {
		int i = queue.pop();
		System.out.println("Item popped - "+i);
		return queue;
	}

	private static Stack<Integer> enqueue(Stack<Integer> queue, int target) {
		
		if(queue.isEmpty())
			queue.push(target);
		else {
			queue = insertAtBottom(queue, target);
		}
		return queue;
	}

	private static Stack<Integer> insertAtBottom(Stack<Integer> queue, int target) {
		
		if(queue.isEmpty()) {
			queue.push(target);
			return queue;
		}
		
		int i = queue.pop();
		queue = insertAtBottom(queue, target);
		queue.push(i);
		
		return queue;
	}

}
