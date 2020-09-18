import java.util.ArrayList;

class Calculator {

    protected static String add(String expression) {
        double result = 0;

        expression = Formatter.reformatOperators(expression);

        ArrayList<String> splitExpression = ExpressionSplitter.split(expression, Constants.addition);
        for (String subExpression : splitExpression) {
            String resultSubtraction = subtract(subExpression);
            result += (Double.parseDouble(resultSubtraction));
        }

        return Double.toString(result);
    }

    private static String subtract(String expression) {
        ArrayList<String> splitExpression = ExpressionSplitter.split(expression, Constants.subtraction);

        if (splitExpression.get(0).equals(Constants.empty)) {
            splitExpression.remove(0);
            splitExpression.set(0, Constants.subtraction + splitExpression.get(0));
        }

        String initialValue = splitExpression.get(0);
        double result = 0;

        for (int i = 0; i < splitExpression.size(); ++i) {
            String resultMultiplication = multiply(splitExpression.get(i));

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

    private static String multiply(String expression) {
        ArrayList<String> splitExpression = ExpressionSplitter.split(expression, Constants.multiplication);
        double result = 1;

        for (String number : splitExpression) {
            String resultDivision = divide(number);
            result *= (Double.parseDouble(resultDivision));
        }

        return Double.toString(result);
    }

    private static String divide(String expression) {

        if (expression.contains(Constants.subtraction + Constants.subtraction)) {
            expression = expression.replace("--", "+");
        }

        ArrayList<String> splitExpression = ExpressionSplitter.split(expression, Constants.division);
        String firstElement = splitExpression.get(0);

        double result = Math.pow(getInitialValue(firstElement), 2);

        if (result != 0) {
            for (String number : splitExpression) {
                result /= (Double.parseDouble(number));
            }
            return Double.toString(result);
        } else return "0";
    }

    private static double getInitialValue(String firstElement) {
        StringBuilder firstNumber = new StringBuilder();
        int index = 0;

        do {
            firstNumber.append(firstElement.charAt(index));
            index++;
        } while (index < firstElement.length() && (Character.isDigit(firstElement.charAt(index)) ||
                firstElement.startsWith(Constants.decimal, index)));


        if (firstNumber.toString().equals("N")) {
            return Double.NaN;
        }
        return Double.parseDouble(firstNumber.toString());
    }
}
