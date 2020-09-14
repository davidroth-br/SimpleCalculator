import java.util.Scanner;

public class InputRetriever {

	protected String getExpression() {
		Scanner input = new Scanner(System.in);
		String end = "end";
		String expression;
		boolean invalidExpression;
		
		do {
			System.out.print("Please enter the expression you wish to calculate or 'end' to exit: ");
			expression = input.nextLine();

			expression = InputFormatter.formatInput(expression);
			invalidExpression = ExpressionValidator.isNotValid(expression);

			if (invalidExpression && !expression.equalsIgnoreCase(end)) {
				System.out.println(expression + " = Invalid expression\n");
			}
		}
		while (invalidExpression && !expression.equalsIgnoreCase(end));

		return expression;
	}
}
