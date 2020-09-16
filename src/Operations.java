import java.util.ArrayList;

class Operations {

    protected static String parseAddition(String expression) {
        double result = 0;
        ArrayList<String> splitExpression = ExpressionSplitter.split(expression, '+');

        for (String number : splitExpression) {
            String resultSubtraction = parseSubtraction(number);
            result += (Double.parseDouble(resultSubtraction));
        }

        return Double.toString(result);
    }

    private static String parseSubtraction(String expression) {
        ArrayList<String> splitExpression = ExpressionSplitter.split(expression, '-');

        if (splitExpression.get(0).equals(Constants.empty)) {
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
        ArrayList<String> splitExpression = ExpressionSplitter.split(expression, '*');
        double result = 1;

        for (String number : splitExpression) {
            String resultDivision = parseDivision(number);
            result *= (Double.parseDouble(resultDivision));
        }

        return Double.toString(result);
    }

    private static String parseDivision(String expression) {
        ArrayList<String> splitExpression = ExpressionSplitter.split(expression, '/');
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
        } while (index < firstElement.length() && (Character.isDigit(firstElement.charAt(index)) || firstElement.charAt(index) == '.'));

        if (firstNumber.toString().equals("N")) {
        //if (Double.isNaN(Double.valueOf(firstNumber.toString()))) {
            return Double.NaN;
        }
        return Double.parseDouble(firstNumber.toString());
    }
}
