package stack;

import java.util.Stack;

public class Infix2Postfix {

	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";

		System.out.println("Infix expression=>  " + exp);
		String postfix = infix2postfix(exp);
		System.out.println("Postfix expression=>  " + postfix);

	}

	
	/* ALGORITH - Infix to Postfix
	 * 
	 * 1. Start reading the expression from left to right
	 * 2. If incoming symbol is an operand, then add it to the final string
	 * 3. If incoming symbol is "(", then push it into the stack
	 * 4. If incoming symbol is ")", then continue popping from stack and add it to final string until "(" is found
	 * 5. If incoming symbol is an operator, the continue popping from stack and add to final string until 
	 * 	  the precedence of incoming operator is greater than the operator at the top of stack 
	 * 6. now push the incoming operator into the stack
	 * 7. Keep repeating the steps 2 to 6 until the expression string is over
	 * 8. Finally empty the stack by popping elements and adding it to final result
	 * 
	 * */
	public static String infix2postfix(String exp) {
		char[] expArr = exp.toCharArray();
		String result = "";
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < expArr.length; i++) {

			Character ch = expArr[i];

			// Any operand
			if (StackUtil.checkOperand(ch)) {
				result = result.concat(Character.toString(ch));
			}
			// Any operator
			else {
				if (ch.equals('(')) {
					stack.push(ch);
				} else if (ch.equals(')')) {
					while (!stack.isEmpty() && !stack.peek().equals('(')) {
						result = result.concat(Character.toString(stack.pop()));
					}
					stack.pop();
				}
				// Incoming Operator
				else {
					while(!stack.isEmpty() && 
							(StackUtil.checkPrecedence(ch) <= StackUtil.checkPrecedence(stack.peek()))) {
						result = result.concat(Character.toString(stack.pop()));
					}
					stack.push(ch);
				}
			}

		}
		
		// Empty the remaining stack
		while(!stack.isEmpty()) {
			result = result.concat(Character.toString(stack.pop()));
		}

		return result;
	}

}
