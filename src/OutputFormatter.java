import java.lang.Math;
import java.lang.StringBuilder;

public class OutputFormatter {

	public StringBuilder format(Operation operation) {
		StringBuilder answer = new StringBuilder("");
		String operator = " " + operation.operator + " ";
		
		if (checkIfInteger(operation.firstOperand)) answer.append((int)operation.firstOperand);
		else answer.append(operation.firstOperand);
		
		answer.append(operator);
		
		if (checkIfInteger(operation.secondOperand)) answer.append((int)operation.secondOperand);
		else answer.append(operation.secondOperand);
		
		answer.append(" = ");
		
		if (checkIfInteger(operation.total)) answer.append((int)operation.total);
		else answer.append(operation.total);
		
		return answer;
	}
	
	public boolean checkIfInteger(double number) {
		return number == Math.rint(number);
	}
}
