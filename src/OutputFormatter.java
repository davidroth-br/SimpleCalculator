import java.lang.Math;
import java.util.ArrayList;

class OutputFormatter {

	protected String formatOutput(ArrayList<Object> expressionArray, double result) {
		String firstOperand = convertNumber((Double) expressionArray.get(0));
		String secondOperand = convertNumber((Double) expressionArray.get(2));
		String total = convertNumber(result);

		return firstOperand + " " + expressionArray.get(1) + " " + secondOperand + " = " + total + "\n";
	}

	private String convertNumber(double number) {
		String convertedNumber;

		if (number == Math.rint(number)) convertedNumber = String.valueOf((int) number);
		else convertedNumber = String.valueOf(number);

		return convertedNumber;
	}


}
