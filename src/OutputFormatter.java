import org.jetbrains.annotations.NotNull;

import java.lang.Math;
import java.lang.StringBuilder;

class OutputFormatter {

	protected StringBuilder format(Operation operation) {
		StringBuilder answer = new StringBuilder();
		String operator = " " + operation.operator + " ";
		
		if (isInteger(operation.firstOperand)) answer.append((int)operation.firstOperand);
		else answer.append(operation.firstOperand);
		
		answer.append(operator);
		
		if (isInteger(operation.secondOperand)) answer.append((int)operation.secondOperand);
		else answer.append(operation.secondOperand);
		
		answer.append(" = ");
		
		if (isInteger(operation.total)) answer.append((int)operation.total);
		else answer.append(operation.total);

		answer.append("\n");
		
		return answer;
	}
	
	private boolean isInteger(double number) {
		return number == Math.rint(number);
	}
}