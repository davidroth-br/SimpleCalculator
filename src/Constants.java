import java.util.ArrayList;
import java.util.Arrays;

class Constants {
    static final String end = "end";
    static final String empty = "";
    static final String space = " ";
    static final String open = "(";
    static final String close = ")";
    static final String decimal = ".";
    static final String addition = "+";
    static final String subtraction = "-";
    static final String multiplication = "*";
    static final String division = "/";
    private static final String numberString = "0123456789";
    static final String validElements =
            numberString + addition + subtraction + multiplication + division + open + close + decimal;
    static final ArrayList<String> operators =
            new ArrayList<>(Arrays.asList(addition, subtraction, multiplication, division));
    static final ArrayList<String> numbers = new ArrayList<>(Arrays.asList(numberString.split(Constants.empty)));
    static final ArrayList<String> invalidOperatorCombinations =
            new ArrayList<>(Arrays.asList("+*", "+/", "-*", "-/", "**", "*/", "/*", "//", "(*", "(/", "(++", "(+-",
                    "(--", "(-+", "+++", "-++", "*++", "/++", "+--", "---", "*--", "/--"));
}
