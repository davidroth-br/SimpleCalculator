class Formatter {

    protected static String reformatOperators(String expression) {
        if (expression.startsWith(Constants.addition)) {
            expression = "0" + expression;
        }

        if (expression.contains(Constants.addition + Constants.addition)) {
            expression = expression.replace((Constants.addition + Constants.addition), Constants.addition);
        }

        if (expression.contains(Constants.subtraction + Constants.addition)) {
            expression = expression.replace((Constants.subtraction + Constants.addition), Constants.subtraction);
        }

        if (expression.contains(Constants.multiplication + Constants.addition)) {
            expression = expression.replace((Constants.multiplication + Constants.addition), Constants.multiplication);
        }

        if (expression.contains(Constants.division + Constants.addition)) {
            expression = expression.replace((Constants.division + Constants.addition), Constants.division);
        }
        return expression;
    }
}
