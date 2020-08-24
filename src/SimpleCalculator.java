import java.util.ArrayList;

public class SimpleCalculator {

	public static void main(String[] args) {
		ArrayList<Object> expressionArray;
		InputRetriever userInput = new InputRetriever();
		Calculator simpleCalculator = new Calculator();
		OutputFormatter output = new OutputFormatter();

		System.out.println("SIMPLE CALCULATOR\n");

		do {
			expressionArray = userInput.getExpression();

			if (isNotEnd(expressionArray)) {
				double total = simpleCalculator.calculate(expressionArray);
				String finalOutput = output.formatOutput(expressionArray, total);
				System.out.println(finalOutput);
			}

		} while (isNotEnd(expressionArray));

		System.out.println("\nThanks for using Simple Calculator!");
	}

	private static boolean isNotEnd(ArrayList<Object> expressionArray) {
		return !expressionArray.get(0).equals("end");
	}
}
