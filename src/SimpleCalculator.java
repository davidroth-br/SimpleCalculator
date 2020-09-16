import java.math.BigDecimal;

public class SimpleCalculator {

	public static void main(String[] args) {
		String expression;

		System.out.println("SIMPLE CALCULATOR\n");

		do {
			expression = InputRetriever.getExpression();

			if (isNotEnd(expression)) {

				String total = Calculator.calculate(expression);

				if (Double.isNaN(Double.parseDouble(total))) {
					total = "Invalid expression";
				} else {
					BigDecimal tempBig = new BigDecimal(total);
					tempBig = tempBig.setScale(8, BigDecimal.ROUND_HALF_EVEN);
					total = tempBig.stripTrailingZeros().toPlainString();
				}

				System.out.println(expression + " = " + total + "\n");
			}
		} while (isNotEnd(expression));

		System.out.println("\nThanks for using Simple Calculator!");
	}

	private static boolean isNotEnd(String expression) {
		return !expression.equals(Constants.end);
	}
}
/*
TEST EXPRESSIONS

-325*(76+(542-32/(98+15)-65)*7)-58 = -1109288.75221239
-325.26*(76.12+(542.54-32.6/(98.2+15.6)-65.4)*7.4)-58.8 = -1172567.80309076
76+(542-32/(98+15)-65) = 552.71681416
2+2 = 4
(2+2) = 4
(32/(98/15)) = 4.89795918
(2*5)+2 = 12
(-2*5)+2 = -8
(2+2)*(4-1)/(1.5*2) = 4
(2+2)*(-4--1)/(-1.5*-2) = -4
(10/3)/(2/5) = 8.33333333
10/(-2) = -5
10*-2 = -20
10--2 = 12
10/(3-3) = INVALID
.2*-.3 = -0.06
5-x = INVALID
2    +  2    = 4
-7-(9.2/0) = INVALID

 */