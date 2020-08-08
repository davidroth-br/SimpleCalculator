import java.lang.StringBuilder;

public class SimpleCalculator {

	public static void main(String[] args) {
		boolean repeat = true;

		InputRetriever userInput = new InputRetriever();
		Operation operation = new Operation();
		Calculator simpleCalculator = new Calculator();
		OutputFormatter output = new OutputFormatter();
		
		while (repeat) {
			System.out.println("SIMPLE CALCULATOR\n");

			operation = userInput.expression();
			
			simpleCalculator.calculate(operation);
			
			StringBuilder finalOutput = output.format(operation);
			
			System.out.println(finalOutput);
			
			repeat = userInput.isAnotherExpression();
		}
		
		System.out.println("Goodbye");
	}
}
