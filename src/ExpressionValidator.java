public class ExpressionValidator {

    protected static boolean isNotValid(String expression) {
        final String validElements = "0123456789.+-*/()";
        boolean valid = false;

        for (int element = 0; element < expression.length(); element++) {
            valid = false;
            for (int i = 0; i < validElements.length(); i++) {
                if (expression.charAt(element) == validElements.charAt(i)) {
                    valid = true;
                    break;
                }
            }

            if (!valid) {
                break;
            }
        }

        return !valid;
    }
}
