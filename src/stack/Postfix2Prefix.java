package stack;

import java.util.Stack;

public class Postfix2Prefix {

	public static void main(String[] args) {

		String exp = "ABC/-AK/L-*";
		System.out.println("Postfix expression=> " + exp);
		String prefix = postfix2prefix(exp);
		System.out.println("Prefix expression=> " + prefix);

	}

	/* ALGORITHM - Postfix to Prefix
	 * 
	 * 1. Start reading the given expression from left to right
	 * 2. If incoming symbol is operand, the push in into the stack
	 * 3. If incoming symbol is operator, the pop 2 consecutive operands from stack
	 * 4. Create a string expression like => operator + operand2 + operand1
	 * 5. Push the formed expression into the stack
	 * 6. Repeat same step till the end of the string expression
	 * 7. At the end, the stack is left with only 1 entry which is the answer
	 * 8. Pop the stack and return it
	 * 
	 * */
	private static String postfix2prefix(String exp) {

		char[] expArr = exp.toCharArray();
		String result = "";
		Stack<String> stack = new Stack<>();
		int n = expArr.length;

		for (int i = 0; i < n; i++) {
			Character ch = expArr[i];

			// Operand
			if (StackUtil.checkOperand(ch)) {
				stack.push(Character.toString(ch));
			}
			// Operator
			else {
				String op1 = stack.pop();
				String op2 = stack.pop();
				String tempExp = ch + op2 + op1;
				stack.push(tempExp);
			}
		}

		if (!stack.isEmpty())
			result = stack.pop();

		return result;

	}

}
