import java.util.Scanner;

public class InputRetriever {
	Scanner input = new Scanner(System.in);
	Operation operation = new Operation();
	double testedOperand;
	
	protected Operation expression() {
		String fullOperation;
		String firstOperand;
		String secondOperand;
		int operatorIndex;
		boolean error = true;
		
		while (error) {
			System.out.print("Please enter the operation you wish to perform (ex. 2+2): ");
			fullOperation = input.nextLine();
			
			if (!isValidOperator(fullOperation)) continue;
			
			operatorIndex = fullOperation.indexOf(operation.operator);
			firstOperand = fullOperation.substring(0, operatorIndex);
			secondOperand = fullOperation.substring(operatorIndex + 1);
			
			if (isValidOperand(firstOperand)) operation.firstOperand = testedOperand;
			else continue;
			
			if (isValidOperand(secondOperand)) operation.secondOperand = testedOperand;
			else continue;
			
			if ((operation.secondOperand == 0) && (operation.operator.equals("/"))) {
				System.out.println("You cannot divide by zero.");
				continue;
			}
			error = false;
		}
		return operation;
	}
	
	private boolean isValidOperator(String expression) {
		
		if (expression.contains("+")) operation.operator = "+";
		else if (expression.contains("-")) operation.operator = "-";
		else if (expression.contains("*")) operation.operator = "*";
		else if (expression.contains("/")) operation.operator = "/";
		else {
			System.out.println("Invalid operator. (+, -, *, /)");
			return false;
		}
		return true;
	}
	
	private boolean isValidOperand(String operand) {
		try {
			testedOperand = Double.parseDouble(operand);
		} catch (Exception e) {
			System.out.println("Invalid operand.");
			return false;
		}
		return true;
	}
	
	protected Boolean isAnotherExpression() {
		String choice = "";
		
		while (!choice.toUpperCase().equals("Y") && !choice.toUpperCase().equals("N")) {
			System.out.print("Would you like to perform another calculation (Y/N)? ");
			choice = input.nextLine();
			System.out.println();
		}
		return choice.toUpperCase().equals("Y");
	}
}