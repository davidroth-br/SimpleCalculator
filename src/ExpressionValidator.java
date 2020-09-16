import java.util.*;

class ExpressionValidator {

    protected static boolean isValid(String expression) {
        ArrayList<String> elementArray = new ArrayList<>(Arrays.asList(expression.split(Constants.empty)));

        return containsNumbers(elementArray) && isValidCharacters(elementArray) && isValidParentheses(elementArray) &&
                isValidDecimalPoint(elementArray) && isValidOperators(expression);
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
        return Collections.frequency(elementArray, Constants.open) == Collections.frequency(elementArray, Constants.close);
    }

    private static boolean isValidParenthesisPlacement(ArrayList<String> elementArray) {
        int parenthesesCount = 0;
        String previousElement = "";
        ListIterator<String> elements = elementArray.listIterator();

        while (elements.hasNext()) {
            int index = elements.nextIndex();
            String element = String.valueOf(elements.next());

            if (element.equals(Constants.open)) {
                if (index > 0 && !Constants.operators.contains(previousElement)) return false;
                parenthesesCount++;
            }
            else if (element.equals(Constants.close)){
                if (index > 0 && (Constants.operators.contains(previousElement) || previousElement.equals(Constants.open))) return false;
                parenthesesCount--;
            }

            if (parenthesesCount < 0) return false;

            previousElement = element;
        }
        return true;
    }

    private static boolean isValidDecimalPoint(ArrayList<String> elementArray) {
        int arraySize = elementArray.size();

        for (int i = 0; i < arraySize; i++) {
            if (elementArray.get(i).equals(Constants.decimal)) {
                if (i - 1 >= 0) {
                    if (i + 1 < arraySize) {
                        return Constants.numbers.contains(elementArray.get(i - 1)) || Constants.numbers.contains(elementArray.get(i + 1));
                    } else {
                        return Constants.numbers.contains(elementArray.get(i - 1));
                    }
                } else if (i + 1 < arraySize) {
                    return Constants.numbers.contains(elementArray.get(i + 1));
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidOperators(String expression) {

        for (String invalidOperatorCombination : Constants.invalidOperatorCombinations) {
            if (expression.contains(invalidOperatorCombination)) {
                return false;
            }
        }
        return true;
    }
}
