import java.util.ArrayList;

public class InputFormatter {

    protected ArrayList<Object> formatInput(String fullExpression) {
        ArrayList<Object> expressionArray;
        String expressionNoSpaces = removeSpaces(fullExpression);
        expressionArray = separateElements(expressionNoSpaces);
        expressionArray = checkForNegativeNumbers(expressionArray);

        return expressionArray;
    }

    private String removeSpaces(String fullExpression) {
        String space = " ";
        String empty = "";
        return fullExpression.replace(space, empty);
    }

    private ArrayList<Object> separateElements(String expressionNoSpaces) {
        int fullExpressionSize = expressionNoSpaces.length();
        ArrayList<Object> expressionElements = new ArrayList<>();
        String completeNumber = "";

        for (int i = 0; i < fullExpressionSize; ++i) {
            char individualCharacter = expressionNoSpaces.charAt(i);

            if (isPartOfNumber(individualCharacter)) {
                completeNumber += individualCharacter;
            } else {
                if (isValidNumber(completeNumber)) {
                    expressionElements.add(Double.parseDouble(completeNumber));
                }
                completeNumber = "";
                expressionElements.add(String.valueOf(individualCharacter));
            }
        }
        if (isValidNumber(completeNumber)) {
            expressionElements.add(Double.parseDouble(completeNumber));
        }
        return expressionElements;
    }

    private boolean isValidNumber(String completeNumber) {
        return !completeNumber.isEmpty() && !((completeNumber.equals(".")) || completeNumber.contains(".."));
    }

    private boolean isPartOfNumber(char individualCharacter) {
        return Character.isDigit(individualCharacter) || individualCharacter == '.';
    }

    private ArrayList<Object> checkForNegativeNumbers(ArrayList<Object> expressionArray) {

        int fullExpressionSize = expressionArray.size();
        for (int i = 0; i < fullExpressionSize; ++i) {
            Object element = expressionArray.get(i);

            if (element instanceof Double && isNotFirstElement(i)) {

                int previousElementIndex = i - 1;
                Object previousElement = expressionArray.get(previousElementIndex);

                if (previousElement.equals("-")) {
                    Double negativeElement = ((Double) element) * -1;
                    if (isNotFirstElement(previousElementIndex)) {
                        if (isNotNumber(expressionArray.get(previousElementIndex - 1))) {
                            expressionArray.set(i, negativeElement);
                            expressionArray.remove(previousElementIndex);
                            fullExpressionSize -= 1;
                        }
                    } else {
                        expressionArray.set(i, negativeElement);
                        expressionArray.remove(previousElementIndex);
                        fullExpressionSize -= 1;
                    }
                }
            }
        }
        return expressionArray;
    }

    private boolean isNotFirstElement(int i) {
        return i > 0;
    }

    private boolean isNotNumber(Object expressionElement) {
        return expressionElement instanceof String;
    }
}
