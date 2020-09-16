import java.util.ArrayList;
import java.util.Arrays;

class Constants {
    static final String empty = "";
    static final String end = "end";
    static final String space = " ";
    static final String open = "(";
    static final String close = ")";
    static final String decimal = ".";
    private static final String operatorString = "+-*/";
    private static final String numberString = "0123456789";
    static final String validElements = numberString + operatorString + open + close + decimal;
    static final ArrayList<String> operators = new ArrayList<>(Arrays.asList(operatorString.split(empty)));
    static final ArrayList<String> numbers = new ArrayList<>(Arrays.asList(numberString.split(Constants.empty)));
    static final ArrayList<String> invalidOperatorCombinations = new ArrayList<>(Arrays.asList("++", "+*", "+/", "*+",
            "**", "*/", "/+", "/*", "//", "(*", "(/", "+-(-", "+-(+", "--(-", "--(+", "*-(-", "+-(*", "/-(-", "/-(+"));
}
