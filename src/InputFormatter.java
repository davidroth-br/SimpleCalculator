class InputFormatter {

    protected static String formatInput(String fullExpression) {
        return removeSpaces(fullExpression);
    }

    private static String removeSpaces(String fullExpression) {
        String space = " ";
        String empty = "";
        return fullExpression.replace(space, empty);
    }
}
