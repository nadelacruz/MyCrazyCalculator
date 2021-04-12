public class HelperMethods {
    /** Checks whether the string is an operator.
     * @param exp the expression to be checked.
     * @return true if operator, false if not. */
    public static boolean isOperator(String exp) {
        return exp.equals("+") || exp.equals("-") || exp.equals("*") || exp.equals("/") || exp.equals("^") || exp.equals("%");
    }

    /** Checks whether the string is an operand.
     * @param exp the expression to be checked.
     * @return true if operand, false if not. */
    public static boolean isOperand(String exp) {
        return !isOperator(exp) && !(exp.equals("(")) && !(exp.equals(")"));
    }

    /** Checks if exp1 has higher operator precedence than exp2.
     * @param exp1 first operator.
     * @param exp2 second operator.
     * @return true if exp1 has higher precedence than exp 2, false if not. */
    public static boolean HasHigherPrecedence(String exp1, String exp2) {
        int x = 0;
        int y = 0;
        switch (exp1) {
            case "^":
                x = 3;
                break;
            case "*":
            case "/":
                x = 2;
                break;
            case "+":
            case "-":
                x = 1;
                break;
        }

        switch (exp2) {
            case "^":
                y = 3;
                break;
            case "*":
            case "/":
                y = 2;
                break;
            case "+":
            case "-":
                y = 1;
                break;
        }
        return x >= y;
    }
}
