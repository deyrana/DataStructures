package stack;

import java.util.Stack;

public class EvaluateExpression {

	public static void main(String[] args) {
		
		String exp = "(2+4)*(4+6)";
		System.out.println("The given expression - "+exp);
		Integer result = evaluateExpression(exp);
		System.out.println("The result is - "+result);

	}

	private static Integer evaluateExpression(String exp) {
		String postfix = Infix2Postfix.infix2postfix(exp);

		char[] expChar = postfix.toCharArray();
		int n = expChar.length;
		Stack<String> stack = new Stack<>();
		Integer finalResult = 0;

		for (int i = 0; i < n; i++) {
			Character ch = expChar[i];
			if (StackUtil.checkOperand(ch)) {
				stack.push(Character.toString(ch));
			} else {
				Integer op1 = Integer.parseInt(stack.pop());
				Integer op2 = Integer.parseInt(stack.pop());
				Integer result = evaluate(ch, op1, op2);
				stack.push(Integer.toString(result));
			}
		}

		if (!stack.isEmpty()) {
			finalResult = Integer.parseInt(stack.pop());
		}

		return finalResult;
	}

	private static Integer evaluate(Character ch, Integer op1, Integer op2) {
		Integer result = null;
		switch(ch) {
		case '+':
			result = op1+op2;
			break;
		case '-':
			result = op1-op2;
			break;
		case '*':
			result = op1*op2;
			break;
		case '/':
			result = op1/op2;
			break;
		case '^':
			result = op1^op2;
			break;
		}
		return result;
	}

}
