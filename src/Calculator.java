class Calculator {

	protected void calculate(Expression expression) {

		switch (expression.operator) {
		case "+":
			expression.total = expression.firstOperand + expression.secondOperand;
			break;
		case "-":
			expression.total = expression.firstOperand - expression.secondOperand;
			break;
		case "*":
			expression.total = expression.firstOperand * expression.secondOperand;
			break;
		case "/":
			expression.total = expression.firstOperand / expression.secondOperand;
			break;
		default:
			break;
		}
	}
}