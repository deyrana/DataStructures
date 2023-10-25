package stack;

public class  StackUtil {
	
	// true if any operand A,B,a,b,1,3,5
	// false if any operator like + - * etc
	public static boolean checkOperand(Character op) {
		if (op.equals('*') || 
			op.equals('/') || 
			op.equals('+') || 
			op.equals('-') || 
			op.equals('(') || 
			op.equals(')') || 
			op.equals('^'))
			return false;
		return true;
	}
	
	public static int checkPrecedence(Character op) {

		switch (op) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;

	}

}
