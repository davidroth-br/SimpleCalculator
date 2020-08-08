public class Calculate {

	public void calculate(Operation operation) {

		switch (operation.operator) {
		case "+":
			operation.total = operation.firstOperand + operation.secondOperand;
			break;
		case "-":
			operation.total = operation.firstOperand - operation.secondOperand;
			break;
		case "*":
			operation.total = operation.firstOperand * operation.secondOperand;
			break;
		case "/":
			operation.total = operation.firstOperand / operation.secondOperand;
			break;
		default:
			break;
		}
	}
}
