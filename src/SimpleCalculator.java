import java.util.ArrayList;

public class SimpleCalculator {

	public static void main(String[] args) {
		boolean repeat = true;

		ArrayList<Object> expressionArray;
		InputRetriever userInput = new InputRetriever();
		Calculator simpleCalculator = new Calculator();
		OutputFormatter output = new OutputFormatter();
		
		while (repeat) {
			System.out.println("SIMPLE CALCULATOR\n");

			expressionArray = userInput.getExpression();
			
			double total = simpleCalculator.calculate(expressionArray);
			
			String finalOutput = output.formatOutput(expressionArray, total);
			
			System.out.println(finalOutput);
			
			repeat = userInput.isAnotherExpression();
		}
		
		System.out.println("Thanks for using Simple Calculator!");
	}
}
