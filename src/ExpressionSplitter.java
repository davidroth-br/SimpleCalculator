import java.util.ArrayList;

class ExpressionSplitter {

    protected static ArrayList<String> split(String expression, String operator) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder currentChunk = new StringBuilder();

        expression = removeSurroundingParentheses(expression);

        for (int i = 0; i < expression.length(); ++i) {

            if (expression.startsWith(operator, i)) {
                if (isNegativeNumber(expression, operator, i)) {
                    currentChunk.append(expression.charAt(i));
                } else {
                    result.add(currentChunk.toString());
                    currentChunk = new StringBuilder();
                }
            } else currentChunk.append(expression.charAt(i));
        }

        result.add(currentChunk.toString());
        return result;
    }

    private static boolean isNegativeNumber(String expression, String operator, int i) {
        return operator.equals(Constants.subtraction) &&
                i != 0 && (expression.startsWith(Constants.subtraction, (i - 1)) ||
                expression.startsWith(Constants.multiplication, (i - 1)) ||
                expression.startsWith(Constants.division, (i - 1)));
    }

    private static String removeSurroundingParentheses(String expression) {
        if (expression.startsWith(Constants.open) && expression.endsWith(Constants.close)) {
            expression = expression.substring(1, expression.length() -1);
        }
        return expression;
    }
}
