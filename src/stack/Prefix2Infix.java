package stack;

import java.util.Stack;

public class Prefix2Infix {

	public static void main(String[] args) {
		String exp = "*-A/BC-/AKL";
		System.out.println("Prefix expression=> "+exp);
		String infix = prefix2infix(exp);
		System.out.println("Infix expression=> "+infix);
	}

	
	/* ALGORITHM - Prefix to Infix
	 * 
	 * 1. Start reading the given expression from right to left
	 * 2. If incoming symbol is operand, the push in into the stack
	 * 3. If incoming symbol is operator, the pop 2 consecutive operands from stack
	 * 4. Create a string expression like => "(" + operand1 + operator + operand2 + ")"
	 * 5. Push the formed expression into the stack
	 * 6. Repeat same step till the end of the string expression
	 * 7. At the end, the stack is left with only 1 entry which is the answer
	 * 8. Pop the stack and return it
	 * 
	 * */
	private static String prefix2infix(String exp) {
		char[] expArr = exp.toCharArray();
		String result = "";
		Stack<String> stack = new Stack<>();
		int n = expArr.length;
		
		for(int i=n-1; i>=0; i--) {
			Character ch = expArr[i];
			
			// Operand
			if(StackUtil.checkOperand(ch)) {
				stack.push(Character.toString(ch));
			}
			// Operator
			else {
				String op1 = stack.pop();
				String op2 = stack.pop();
				String tempExp = "(" + op1 + ch + op2 + ")";
				stack.push(tempExp);
			}
			
		}

		if(!stack.isEmpty())
			result = stack.pop();
		
		return result;
	}
	

}
