public class SimpleCalculator {

	public static void main(String[] args) {
		boolean repeat = true;

		Expression expression;
		InputRetriever userInput = new InputRetriever();
		Calculator simpleCalculator = new Calculator();
		OutputFormatter output = new OutputFormatter();
		
		while (repeat) {
			System.out.println("SIMPLE CALCULATOR\n");

			expression = userInput.getExpression();
			
			simpleCalculator.calculate(expression);
			
			String finalOutput = output.format(expression);
			
			System.out.println(finalOutput);
			
			repeat = userInput.isAnotherExpression();
		}
		
		System.out.println("Thanks for using Simple Calculator!");
	}
}