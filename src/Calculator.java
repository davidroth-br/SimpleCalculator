import java.util.ArrayList;

public class Calculator {

    protected static String calculate(String expression) {
        String result;
        int openParenthesesIndex = findOpenParentheses(expression);

        if (openParenthesesIndex == 0 && !isOpenParenthesis(expression.charAt(0))) {
            result = parseAddition(expression);
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
        StringBuilder subExpression = new StringBuilder();
        int closeParenthesesIndex = 0;
        String newExpression = expression.substring(0, openParenthesesIndex);

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

        String subExpressionResult = parseAddition(subExpression.toString());
        newExpression += (subExpressionResult + expression.substring(closeParenthesesIndex + 1));
        return newExpression;
    }

    private static ArrayList<String> split(String expression, char operator) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder currentChunk = new StringBuilder();

        expression = removeSurroundingParentheses(expression);

        for (int i = 0; i < expression.length(); ++i) {

            if (operator == expression.charAt(i)) {
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

    private static boolean isNegativeNumber(String expression, char operator, int i) {
        return operator == '-' && i != 0 && (expression.charAt(i - 1) == '-' ||
                expression.charAt(i - 1) == '*' || expression.charAt(i - 1) == '/');
    }

    private static String removeSurroundingParentheses(String expression) {
        if (expression.startsWith("(") && expression.endsWith(")")) {
            expression = expression.substring(1, expression.length() -1);
        }
        return expression;
    }

    private static boolean isOpenParenthesis(char character) {
        return character == '(';
    }

    private static boolean isCloseParenthesis(char character) {
        return character == ')';
    }

    private static String parseAddition(String expression) {
        double result = 0;
        ArrayList<String> splitExpression = split(expression, '+');

        for (String number : splitExpression) {
            String resultSubtraction = parseSubtraction(number);
            result += (Double.parseDouble(resultSubtraction));
        }

        return Double.toString(result);
    }

    private static String parseSubtraction(String expression) {
        ArrayList<String> splitExpression = split(expression, '-');

        if (splitExpression.get(0).equals("")) {
            splitExpression.remove(0);
            splitExpression.set(0, "-" + splitExpression.get(0));
        }

        String initialValue = splitExpression.get(0);
        double result = 0;

        for (int i = 0; i < splitExpression.size(); ++i) {
            String resultMultiplication = parseMultiplication(splitExpression.get(i));

            if (i == 0) {
                if (resultMultiplication.equals(initialValue)) {
                    result = Double.parseDouble(initialValue) * 2;
                } else {
                    result = Double.parseDouble(resultMultiplication) * 2;
                }
            }

            result -= (Double.parseDouble(resultMultiplication));
        }

        return Double.toString(result);
    }

    private static String parseMultiplication(String expression) {
        ArrayList<String> splitExpression = split(expression, '*');
        double result = 1;

        for (String number : splitExpression) {
            String resultDivision = parseDivision(number);
            result *= (Double.parseDouble(resultDivision));
        }

        return Double.toString(result);
    }

    private static String parseDivision(String expression) {
        ArrayList<String> splitExpression = split(expression, '/');
        String firstElement = splitExpression.get(0);
        double result = Math.pow(getInitialValue(firstElement), 2);

        for (String number : splitExpression) {
            result /= (Double.parseDouble(number));
        }

        return Double.toString(result);
    }

    private static double getInitialValue(String firstElement) {
        double initialValue;
        StringBuilder firstNumber = new StringBuilder();
        int index = 0;
        do {
            firstNumber.append(firstElement.charAt(index));
            index++;
        } while (index < firstElement.length() && (Character.isDigit(firstElement.charAt(index)) || firstElement.charAt(index) == '.'));
        initialValue = Double.parseDouble(firstNumber.toString());
        return initialValue;
    }
}
