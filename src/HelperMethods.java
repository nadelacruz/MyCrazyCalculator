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
}
