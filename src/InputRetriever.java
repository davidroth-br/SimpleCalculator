import java.util.Scanner;

class InputRetriever {

	protected static String getExpression() {
		Scanner input = new Scanner(System.in);

		String expression;
		boolean validExpression;
		
		do {
			System.out.print("Please enter the expression you wish to calculate or 'end' to exit: ");
			expression = input.nextLine().replace(Constants.space, Constants.empty);

			validExpression = ExpressionValidator.isValid(expression);

			if (!validExpression && !expression.equalsIgnoreCase(Constants.end)) {
				System.out.println(expression + " = Invalid expression\n");
			}
		}
		while (!validExpression && !expression.equalsIgnoreCase(Constants.end));

		return expression;
	}
}
