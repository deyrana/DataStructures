package stack;

import java.util.Stack;

public class BalancedBracketCheck {

	public static void main(String[] args) {
		String exp = "[()]{}{[()()]()}{}";
		System.out.println("Input bracket expression=> "+exp);
		boolean isBalanced = checkBalancedBrackets(exp);
		System.out.println("isBalanced=> "+isBalanced);
		

	}
	
	
	/* ALGORITHM - Check Balanced Parenthesis 
	 * 
	 * 1. Start reading the expression from left to right
	 * 2. if incoming symbol is opening brackets - ({[ - the push it into stack
	 * 3. If incoming symbol is closing bracket, the pop topmost element from stack
	 * 4. If the popped elements is the opening bracket of same nature as the incoming 
	 * 	  closing bracket then continue
	 * 5. If the popped elements is the opening bracket of different nature as the incoming 
	 * 	  closing bracket then return false
	 * 6. At the end of the loop, if stack is still not empty then return false
	 *    else vice-versa
	 * 
	 * */
	private static boolean checkBalancedBrackets(String exp) {
		
		char[] expArr = exp.toCharArray();
		Stack<String> stack = new Stack<>();
		int n = expArr.length;
		
		for(int i=0; i<n; i++) {
			String s = Character.toString(expArr[i]);
			// Opening braces
			if(s.equals("[") || s.equals("{") || s.equals("(")) {
				stack.push(s);
			} 
			// Closing brace
			else {
				// If closing brace encountered and stack is empty 
				// that means its unbalanced
				if(stack.isEmpty())
					return false;
				
				String check = null;
				switch(s) {
				case ")":
					check = stack.pop();
					if(check.equals("{") || check.equals("["))
						return false;
					break;
				
				case "]":
					check = stack.pop();
					if(check.equals("{") || check.equals("("))
						return false;
					break;
				
				case "}":
					check = stack.pop();
					if(check.equals("(") || check.equals("["))
						return false;
					break;
				}
				
			}
		}
		
		// if stack is empty after loop, then balanced
		return stack.isEmpty();
	}

}
