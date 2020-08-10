import java.util.Scanner;

public class InputRetriever {
	Scanner input = new Scanner(System.in);
	Expression expression = new Expression();
	private double validOperand;

	protected Expression getExpression() {
		String fullExpression;
		
		// e se digitarem 2+2+2?
		// e 2+-2?
		// vopce podia tentar fazer uns JUnits
		do {
			System.out.print("Please enter the expression you wish to calculate (ex. 2+2): ");
			fullExpression = input.nextLine();
		}
		while (isNotValidExpression(fullExpression));

		return expression;
	}

	private boolean isNotValidExpression(String fullExpression) {
		int operatorIndex;
		String firstOperand;
		String secondOperand;

		if (isNotValidOperator(fullExpression)) return true;

		operatorIndex = fullExpression.indexOf(expression.operator);
		firstOperand = fullExpression.substring(0, operatorIndex);
		secondOperand = fullExpression.substring(operatorIndex + 1);

		//voce gosta de if/else assim? acho mais lisivel quebrando a linha
		if (isValidOperand(firstOperand)) expression.firstOperand = validOperand;
		else return true;

		if (isValidOperand(secondOperand)) expression.secondOperand = validOperand;
		else return true;

		if (isDivisionByZero()) return true;

		return false;
	}

	private boolean isDivisionByZero() {
		if ((expression.secondOperand == 0) && (expression.operator.equals("/"))) {
			System.out.println("You cannot divide by zero.");
			return true;
		}
		return false;
	}

	private boolean isNotValidOperator(String expression) {

		if (expression.contains("+")) this.expression.operator = "+";
		else if (expression.contains("-")) this.expression.operator = "-";
		else if (expression.contains("*")) this.expression.operator = "*";
		else if (expression.contains("/")) this.expression.operator = "/";
		else {
			System.out.println("Invalid operator. (+, -, *, /)");
			return true;
		}
		return false;
	}
	
	//nao sei se a syntax ta certa :D :D
	//public class Operand {
	// boolean valid;
	// double value;
	//}
	
	//porque nao? Operand GetValidOperand(String operand)
	private boolean isValidOperand(String operand) {
		try {
			validOperand = Double.parseDouble(operand);
		} catch (Exception e) {
			System.out.println("Invalid operand.");
			return false;
		}
		return true;
	}
	
	protected Boolean isAnotherExpression() {
		String choice;
		
		do {
			System.out.print("Would you like to perform another calculation (Y/N)? ");
			// podia colocar .toUpperCase() aqui:
			// choice = input.nextLine().toUpperCase();
			// e evitar repetir?
			choice = input.nextLine();
			System.out.println();
		}
		while (!choice.toUpperCase().equals("Y") && !choice.toUpperCase().equals("N"));

		return choice.toUpperCase().equals("Y");
	}
}
