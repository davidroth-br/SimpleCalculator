import java.util.ArrayList;
import java.util.Scanner;

public class InputRetriever {
	Scanner input = new Scanner(System.in);

	protected ArrayList<Object> getExpression() {
		String fullExpression;
		ArrayList<Object> expressionArray;
		InputFormatter inputFormatter = new InputFormatter();
		ExpressionValidator validator = new ExpressionValidator();
		
		do {
			System.out.print("Please enter the expression you wish to calculate (ex. 2+2): ");
			fullExpression = input.nextLine();

			expressionArray = inputFormatter.formatInput(fullExpression);
		}
		while (validator.isNotValid(expressionArray));

		return expressionArray;
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
