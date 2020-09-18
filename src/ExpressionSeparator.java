class ExpressionSeparator {

    protected static String separate(String expression) {
        String result;

        int openParenthesesIndex = findLastOpenParentheses(expression);

        if (openParenthesesIndex == -1) {
            result = Calculator.add(expression);
        } else {
            String expressionFragment = getExpressionFragment(expression, openParenthesesIndex);
            result = separate(expressionFragment);
        }

        return result;
    }

    private static int findLastOpenParentheses(String expression) {
        if (expression.contains(Constants.open)) {
            return expression.lastIndexOf(Constants.open);
        } else {
            return -1;
        }
    }

    private static String getExpressionFragment(String expression, int openParenthesesIndex) {
        String newExpression = expression.substring(0, openParenthesesIndex);
        int closeParenthesesIndex = 0;

        for (int i = openParenthesesIndex + 1; i < expression.length(); i++) {
            if (expression.startsWith(Constants.close, i)) {
                closeParenthesesIndex = i;
                break;
            }
        }
        String subExpression = expression.substring(openParenthesesIndex + 1, closeParenthesesIndex);
        String subExpressionResult = Calculator.add(subExpression);
        newExpression += (subExpressionResult + expression.substring(closeParenthesesIndex + 1));
        return newExpression;
    }
}
