package stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

import linkedList.DeleteLinkedList;
import linkedList.InsertLinkedList;
import linkedList.LinkedList;

public class StackPractice {

	public static void main(String[] args) {
//		Stack<Integer> st = new Stack<>();
//		
//		System.out.println("Stack empty - "+st.isEmpty());
//		
//		System.out.println("Entering elements in Stack...");
//		
//		for(int i = 0; i< 5; i++) {
//			st.push(i);
//		}
//		
//		System.out.println("Stack empty - "+st.isEmpty());
//		
//		System.out.println("Stack peek - "+st.peek());
//		
//		int target = 10;
//		
//		System.out.println("Find "+target+" in stack - "+st.search(target));
//		
//		
//		System.out.println("Stack popping operation...");
//		while(!st.isEmpty()) {
//			System.out.println(st.pop());
//		}
//		
//		System.out.println("Stack empty - "+st.isEmpty());
		
//		String s = "A quick brown fox jumps over a lazy dog";
//		System.out.println("Original String=> "+s);
//		String rev = revString(s);
//		String rev = Arrays.asList(s.split(" "))
//                .stream()
//                .map(st -> new StringBuilder(st).reverse())
//                .collect(Collectors.joining(" "));
//		System.out.println("Reversed String=> "+rev);
		
		
		LinkedList stack = createStackFromLL();
		LinkedList.printLinkedList(stack);
		
		stack = pop(stack);
		System.out.println("Stack after popping - ");
		LinkedList.printLinkedList(stack);
		
		stack = push(stack, 23);
		System.out.println("Stack after pushing - ");
		LinkedList.printLinkedList(stack);
		
		stack = push(stack, 57);
		System.out.println("Stack after pushing - ");
		LinkedList.printLinkedList(stack);
		
		stack = pop(stack);
		System.out.println("Stack after popping - ");
		LinkedList.printLinkedList(stack);
		
	}

	private static LinkedList push(LinkedList stack, int target) {
		stack = InsertLinkedList.insertAtBeginning(stack, target);
		return stack;
	}

	private static LinkedList pop(LinkedList stack) {
		stack = DeleteLinkedList.deleteFirst(stack);
		return stack;
	}

	private static LinkedList createStackFromLL() {

		LinkedList stack = null;
		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				stack = new LinkedList(arr[i]);
			} else {
				stack = InsertLinkedList.insertAtBeginning(stack, arr[i]);
			}
		}

		return stack;
	}

	private static String revString(String s) {
		String rev = "";
		int n = s.length();
		
		Stack<String> st = new Stack<>();
		for(int i=0; i<n;i++) {
			String si = Character.toString(s.charAt(i));
			if(si.equals(" ")) {
				rev = rev.concat(revWord(st)).concat(si);
//				st = new Stack<>();
			} else {
				st.push(si);
			}
		}
		
		rev = rev.concat(revWord(st));
		
		return rev;
	}

	private static String revWord(Stack<String> st) {
		String res = "";
		while(!st.isEmpty()) {
			res = res.concat(st.pop());
		}
		return res;
	}

}
