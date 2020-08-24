import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressionValidator {

    protected boolean isNotValid(ArrayList<Object> expressionArray) {
        int expressionSize = expressionArray.size();

        if (isNotCorrectSize(expressionSize)) return true;

        for (int i = 0; i < expressionSize; ++i) {
            Object element = expressionArray.get(i);

            if (isEvenIndex(i)) {
                if (isNotNumber(element)) return true;
            } else {
                if (isNotValidOperator(element)) return true;
            }
        }
        return isDivisionByZero(expressionArray);
    }

    private boolean isEvenIndex(int index) {
        return index % 2 == 0;
    }

    private boolean isDivisionByZero(ArrayList<Object> expressionArray) {
        if (((Double) expressionArray.get(2) == 0) && (expressionArray.get(1).equals("/"))) {
            System.out.println("You cannot divide by zero.");
            return true;
        }
        return false;
    }

    private boolean isNotNumber(Object element) {
        if (!(element instanceof Double)) {
            System.out.println("Invalid operand.");
            return true;
        }
        return false;
    }

    private boolean isNotValidOperator(Object element) {
        String[] operators = {"+", "-", "*", "/"};
        List<Object> operatorList = Arrays.asList(operators);
        if (!operatorList.contains(element)) {
            System.out.println("Invalid operator.");
            return true;
        }
        return false;
    }

    private boolean isNotCorrectSize(int expressionSize) {
        if (expressionSize < 3 || expressionSize % 2 == 0) {
            System.out.println("Invalid expression.");
            return true;
        }
        return false;
    }
}
