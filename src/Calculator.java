class Calculator {

	protected void calculate(Expression expression) {

		switch (expression.operator) {
		case "+":
			expression.total = add(expression);
			break;
		case "-":
			expression.total = subtract(expression);
			break;
		case "*":
			expression.total = multiply(expression);
			break;
		case "/":
			expression.total = divide(expression);
			break;
		default:
			break;
		}
	}

	private double add(Expression expression) {
		return expression.firstOperand + expression.secondOperand;
	}

	private double subtract(Expression expression) {
		return expression.firstOperand - expression.secondOperand;
	}

	private double multiply(Expression expression) {
		return expression.firstOperand * expression.secondOperand;
	}

	private double divide(Expression expression) {
		return expression.firstOperand / expression.secondOperand;
	}
}