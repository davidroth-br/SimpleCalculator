class Calculator {
// nao eh bom modificar um paramento dentro de uma funcao.
// o melhor seria retornar TOTAL
//protected doulbe calculate(Expression expression) 
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
