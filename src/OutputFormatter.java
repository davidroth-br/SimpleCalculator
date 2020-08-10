import java.lang.Math;

class OutputFormatter {

	protected String format(Expression expression) {
		String firstOperand = convertNumber(expression.firstOperand);
		String secondOperand = convertNumber(expression.secondOperand);
		String total = convertNumber(expression.total);

		return firstOperand + " " + expression.operator + " " + secondOperand + " = " + total + "\n";
	}

	private String convertNumber(double number) {
		String convertedNumber;

		if (number == Math.rint(number)) convertedNumber = String.valueOf((int) number);
		else convertedNumber = String.valueOf(number);

		return convertedNumber;
	}
}