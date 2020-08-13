import java.util.Scanner;

public class InputRetriever {
	Scanner input = new Scanner(System.in);
	Expression expression = new Expression();
	private double validOperand;

	protected Expression getExpression() {
		String fullExpression;
		String formattedExpression;
		
		do {
			System.out.print("Please enter the expression you wish to calculate (ex. 2+2): ");
			fullExpression = input.nextLine();
			formattedExpression = removeSpaces(fullExpression);
		}
		while (isNotValidExpression(formattedExpression));

		return expression;
	}

	private String removeSpaces(String fullExpression) {
		String space = " ";
		String empty = "";

		return fullExpression.replace(space, empty);
	}

	private boolean isNotValidExpression(String fullExpression) {
		int operatorIndex;
		String firstOperand;
		String secondOperand;

		if (isNotValidOperator(fullExpression)) return true;

		operatorIndex = fullExpression.indexOf(expression.operator);
		firstOperand = fullExpression.substring(0, operatorIndex);
		secondOperand = fullExpression.substring(operatorIndex + 1);

		if (isValidOperand(firstOperand)) expression.firstOperand = validOperand;
		else return true;

		if (isValidOperand(secondOperand)) expression.secondOperand = validOperand;
		else return true;

		if (isDivisionByZero()) return true;

		return false;
	}

	private boolean isNotValidOperator(String fullExpression) {

		if (fullExpression.contains("+")) expression.operator = "+";
		else if (fullExpression.contains("-")) expression.operator = "-";
		else if (fullExpression.contains("*")) expression.operator = "*";
		else if (fullExpression.contains("/")) expression.operator = "/";
		else {
			System.out.println("Invalid operator. (+, -, *, /)");
			return true;
		}
		return false;
	}
	
	private boolean isValidOperand(String operand) {

		try {
			validOperand = Double.parseDouble(operand);
		} catch (Exception e) {
			System.out.println("Invalid operand.");
			return false;
		}
		return true;
	}

	private boolean isDivisionByZero() {
		if ((expression.secondOperand == 0) && (expression.operator.equals("/"))) {
			System.out.println("You cannot divide by zero.");
			return true;
		}
		return false;
	}

	protected Boolean isAnotherExpression() {
		String choice;
		
		do {
			System.out.print("Would you like to perform another calculation (Y/N)? ");
			choice = input.nextLine().toUpperCase();
			System.out.println();
		}
		while (!choice.equals("Y") && !choice.equals("N"));

		return choice.equals("Y");
	}
}