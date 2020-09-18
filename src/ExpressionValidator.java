import java.util.*;

class ExpressionValidator {

    protected static boolean isValid(String expression) {
        ArrayList<String> elementArray = new ArrayList<>(Arrays.asList(expression.split(Constants.empty)));

        return containsNumbers(elementArray) && isValidCharacters(elementArray) && isValidParentheses(elementArray)
                && isValidDecimalPoint(elementArray) && isValidOperators(expression) && isValidBeginning(expression)
                && isValidEnding(expression);
    }

    private static boolean containsNumbers(ArrayList<String> elementArray) {
        ListIterator<String> elements = elementArray.listIterator();
        boolean hasNumbers = false;

        while (elements.hasNext()) {
            if (Constants.numbers.contains(elements.next())) {
                hasNumbers = true;
            }
        }

        return hasNumbers;
    }

    private static boolean isValidCharacters(ArrayList<String> elementArray) {
        ListIterator<String> elements = elementArray.listIterator();
        final List<String> validElements = Arrays.asList(Constants.validElements.split(Constants.empty));

        while (elements.hasNext()) {
            if (validElements.contains(elements.next())) {
                continue;
            }
            return false;
        }

        return true;
    }

    private static boolean isValidParentheses(ArrayList<String> elementArray) {
        return isValidNumberOfParentheses(elementArray) && isValidParenthesisPlacement(elementArray);
    }

    private static boolean isValidNumberOfParentheses(ArrayList<String> elementArray) {
        return Collections.frequency(elementArray, Constants.open)
                == Collections.frequency(elementArray, Constants.close);
    }

    private static boolean isValidParenthesisPlacement(ArrayList<String> elementArray) {
        int parenthesesCount = 0;
        String previousElement = "";
        ListIterator<String> elements = elementArray.listIterator();

        while (elements.hasNext()) {
            int index = elements.nextIndex();
            String element = String.valueOf(elements.next());

            if (element.equals(Constants.open)) {
                if (index > 0 && !isAnOperator(previousElement)) return false;
                parenthesesCount++;
            }
            else if (element.equals(Constants.close)){
                if (index > 0 && (isAnOperator(previousElement)
                        || previousElement.equals(Constants.open))) return false;
                parenthesesCount--;
            }

            if (parenthesesCount < 0) return false;

            previousElement = element;
        }
        return true;
    }

    private static boolean isAnOperator(String previousElement) {
        return Constants.operators.contains(previousElement);
    }

    private static boolean isValidDecimalPoint(ArrayList<String> elementArray) {
        int arraySize = elementArray.size();
        boolean validDecimal = true;
        int lastElement = elementArray.size() - 1;
        int nextToLastElement = lastElement - 1;

        if (isADecimalPoint(elementArray, lastElement) && !isANumber(elementArray, nextToLastElement)) {
            return false;
        }

        for (int element = 0; element < arraySize; element++) {
            if (isADecimalPoint(elementArray, element)) {
                int nextNonNumber = element + 1;

                for (int n = element + 1; (n < arraySize) && isANumber(elementArray, n); n++) {
                    nextNonNumber = n + 1;
                }

                if (nextNonNumber < arraySize && nextNonNumber > element && validDecimal) {
                    int nextElement = element + 1;
                    if (decimalPointIsNotFirstElement(element)) {
                        int previousElement = element - 1;
                        if (isOneMoreElement(arraySize, element)) {
                            if (areTwoMoreElements(arraySize, element)) {
                                validDecimal = (isANumber(elementArray, previousElement)
                                        || isANumber(elementArray, nextElement))
                                        && !(isADecimalPoint(elementArray, previousElement)
                                        || isADecimalPoint(elementArray, nextElement))
                                        && !isADecimalPoint(elementArray, nextNonNumber);
                            } else {
                                validDecimal = (isANumber(elementArray, previousElement)
                                        || isANumber(elementArray, nextElement))
                                        && !(isADecimalPoint(elementArray, previousElement)
                                        || isADecimalPoint(elementArray, nextElement));
                            }
                        } else {
                            validDecimal = isANumber(elementArray, previousElement);
                        }
                    } else {
                        if (areTwoMoreElements(arraySize, element)) {
                            validDecimal = isANumber(elementArray, nextElement)
                                    && !isADecimalPoint(elementArray, nextNonNumber);
                        } else {
                            validDecimal = isANumber(elementArray, nextElement);
                        }
                    }
                }
            }
        }
        return validDecimal;
    }

    private static boolean isANumber(ArrayList<String> elementArray, int n) {
        return Constants.numbers.contains(elementArray.get(n));
    }

    private static boolean isADecimalPoint(ArrayList<String> elementArray, int i) {
        return elementArray.get(i).equals(Constants.decimal);
    }

    private static boolean decimalPointIsNotFirstElement(int i) {
        return i - 1 >= 0;
    }

    private static boolean isOneMoreElement(int arraySize, int i) {
        return i + 1 < arraySize;
    }

    private static boolean areTwoMoreElements(int arraySize, int i) {
        return i + 2 < arraySize;
    }

    private static boolean isValidOperators(String expression) {

        for (String invalidOperatorCombination : Constants.invalidOperatorCombinations) {
            if (expression.contains(invalidOperatorCombination)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidEnding(String expression) {
        return !isAnOperator(Character.toString(expression.charAt(expression.length() - 1)));
    }

    private static boolean isValidBeginning(String expression) {
        return !(expression.startsWith(Constants.multiplication) || expression.startsWith(Constants.division));
    }
}
