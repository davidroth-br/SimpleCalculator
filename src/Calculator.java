public class Calculator {

    protected static String calculate(String expression) {
        String result;
        int openParenthesesIndex = findOpenParentheses(expression);

        if (openParenthesesIndex == 0 && !isOpenParenthesis(expression.charAt(0))) {
            result = Operations.parseAddition(expression);
        } else {
            String expressionFragment = getExpressionFragment(expression, openParenthesesIndex);
            result = calculate(expressionFragment);
        }

        return result;
    }

    private static int findOpenParentheses(String expression) {
        int openParenthesesIndex = 0;
        for (int i = 0; i < expression.length(); ++i) {
            char currentCharacter = expression.charAt(i);
            if (isOpenParenthesis(currentCharacter)) {
                openParenthesesIndex = i;
            }
        }
        return openParenthesesIndex;
    }

    private static String getExpressionFragment(String expression, int openParenthesesIndex) {
        String newExpression = expression.substring(0, openParenthesesIndex);
        int closeParenthesesIndex = 0;
        StringBuilder subExpression = new StringBuilder();

        for (int i = openParenthesesIndex + 1; i < expression.length(); i++) {
            if (isCloseParenthesis(expression.charAt(i))) {
                closeParenthesesIndex = i;
                break;
            } else if (i == expression.length() - 1) {
                closeParenthesesIndex = i;
                subExpression.append(expression.charAt(i));
                break;
            }
            subExpression.append(expression.charAt(i));
        }

        String subExpressionResult = Operations.parseAddition(subExpression.toString());
        newExpression += (subExpressionResult + expression.substring(closeParenthesesIndex + 1));
        return newExpression;
    }

    private static boolean isOpenParenthesis(char character) {
        return character == '(';
    }

    private static boolean isCloseParenthesis(char character) {
        return character == ')';
    }

}
