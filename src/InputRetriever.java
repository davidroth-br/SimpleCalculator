import java.util.ArrayList;
import java.util.Scanner;

public class InputRetriever {
	Scanner input = new Scanner(System.in);

	protected ArrayList<Object> getExpression() {
		Object end = "end";
		String fullExpression;
		ArrayList<Object> expressionArray = new ArrayList<>();
		InputFormatter inputFormatter = new InputFormatter();
		ExpressionValidator validator = new ExpressionValidator();
		
		do {
			System.out.print("Please enter the expression you wish to calculate or 'end' to exit: ");
			fullExpression = input.nextLine();

			if (fullExpression.toLowerCase().equals(end)) {
				expressionArray.add(end);
				break;
			}

			expressionArray = inputFormatter.formatInput(fullExpression);
		}
		while (validator.isNotValid(expressionArray));

		return expressionArray;
	}
}
