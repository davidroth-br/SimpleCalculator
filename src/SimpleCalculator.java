import java.lang.StringBuilder;

public class SimpleCalculator {

	public static void main(String[] args) {
		boolean repeat = true;

		GetInput userInput = new GetInput();
		Operation operation = new Operation();
		Calculate simpleCalculator = new Calculate();
		FormatOutput output = new FormatOutput();
		
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
