package stack;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class StackReverse {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println("OG stack=> "+stack.toString());
//		Stack<Integer> revStack = revStackUsingQueue(stack);
		
		Stack<Integer> revStack = revStackUsingRec(stack);
		System.out.println("Reversed stack=> "+revStack.toString());

	}

	private static Stack<Integer> revStackUsingRec(Stack<Integer> stack) {
		
		if(!stack.isEmpty()) {
			
			Integer i = stack.pop();
			stack = revStackUsingRec(stack);
			
			stack = insertAtBottom(i, stack);
			
		}
		
		return stack;
	}

	private static Stack<Integer> insertAtBottom(Integer i, Stack<Integer> stack) {
		if(stack.isEmpty())
			stack.push(i);
		else {
			Integer j = stack.pop();
			stack = insertAtBottom(i, stack);
			stack.push(j);
		}
		return stack;
	}

	private static Stack<Integer> revStackUsingQueue(Stack<Integer> stack) {
		Queue<Integer> q = new ConcurrentLinkedQueue<>();
		
		while(!stack.isEmpty()) {
			q.add(stack.pop());
		}
		
		while(!q.isEmpty()) {
			stack.push(q.remove());
		}
		
		return stack;
	}

}
