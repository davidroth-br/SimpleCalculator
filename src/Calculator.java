import java.util.ArrayList;

class Calculator {

	protected double calculate(ArrayList<Object> expressionArray) {
		double firstOperand = (Double) expressionArray.get(0);
		String operator = (String) expressionArray.get(1);
		double secondOperand = (Double) expressionArray.get(2);
		double total = 0;


		switch (operator) {
		case "+":
			total = firstOperand + secondOperand;
			break;
		case "-":
			total = firstOperand - secondOperand;
			break;
		case "*":
			total = firstOperand * secondOperand;
			break;
		case "/":
			total = firstOperand / secondOperand;
			break;
		default:
			break;
		}
		return total;
	}
}
