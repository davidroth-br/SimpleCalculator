import java.util.ArrayList;

public class InputFormatter {

    protected ArrayList<Object> formatInput(String fullExpression) {
        String expressionNoSpaces = removeSpaces(fullExpression);
        return separateElements(expressionNoSpaces);
    }

    private String removeSpaces(String fullExpression) {
        String space = " ";
        String empty = "";
        return fullExpression.replace(space, empty);
    }

    private ArrayList<Object> separateElements(String expressionNoSpaces) {
        ArrayList<Object> expressionElements = new ArrayList<>();
        String number = "";

        for (char element : expressionNoSpaces.toCharArray()) {
            if (isPartOfNumber(element)) {
                number = addToNumber(number, element);
            } else {
                addNumberToExpression(expressionElements, number);
                number = "";
                expressionElements.add(String.valueOf(element));
            }
        }

        addNumberToExpression(expressionElements, number);

        return checkForNegativeNumbers(expressionElements);
    }

    private String addToNumber(String number, char element) {
        number += element;
        return number;
    }

    private void addNumberToExpression(ArrayList<Object> expressionElements, String completeNumber) {
        if (isValidNumber(completeNumber)) {
            expressionElements.add(Double.parseDouble(completeNumber));
        }
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
