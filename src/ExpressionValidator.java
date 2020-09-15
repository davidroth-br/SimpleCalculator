import java.util.*;

public class ExpressionValidator {
    final static String eachCharacter = "";

    protected static boolean isNotValid(String expression) {
        ArrayList<String> elementArray = new ArrayList<>(Arrays.asList(expression.split(eachCharacter)));

        return !(isValidCharacters(elementArray) && isValidParentheses(elementArray));
    }

    private static boolean isValidCharacters(ArrayList<String> elementArray) {
        ListIterator<String> elements = elementArray.listIterator();
        final List<String> validElements = Arrays.asList("0123456789.+-*/()".split(eachCharacter));

        while (elements.hasNext()) {
            if (!validElements.contains(elements.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidParentheses(ArrayList<String> elementArray) {
        ListIterator<String> elements = elementArray.listIterator();
        final String open = "(";
        final String close = ")";
        int parenthesesCount = 0;
        String previousElement = "";
        final ArrayList<String> operators = new ArrayList<>(Arrays.asList("+-*/".split(eachCharacter)));

        if (!(Collections.frequency(elementArray, open) == Collections.frequency(elementArray, close))) {
            return false;
        }

        while (elements.hasNext()) {
            int index = elements.nextIndex();
            String element = String.valueOf(elements.next());

            if (element.equals(open)) {
                if (index > 0 && !operators.contains(previousElement)) return false;
                parenthesesCount++;
            }
            else if (element.equals(close)){
                if (index > 0 && (operators.contains(previousElement) || previousElement.equals(open))) return false;
                parenthesesCount--;
            }

            if (parenthesesCount < 0) return false;

            previousElement = element;
        }

        return true;
    }
}
