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

    /** Performs the calculation of the string operator and the operands.
     * @param operator the operator.
     * @param operand1 the first operand.
     * @param operand2 the second operand.
     * @return the evaluated expression. */
    public static String perform(String operator, String operand1, String operand2) {
        MyDouble x = new MyDouble(Double.parseDouble(operand1));
        MyDouble y = new MyDouble(Double.parseDouble(operand2));

        switch (operator) {
            case "+":
                x.add(y);
                break;
            case "-":
                x.subtract(y);
                break;
            case "*":
                x.multiply(y);
                break;
            case "/":
                x.divide(y);
                break;
            case "^":
                x.raise(y);
                break;
            case "%":
                x.modulo(y);
                break;
        }

        return x.toString();
    }

    /** Reverses a given string with inverted parentheses.
     * @param str string to be reversed.
     * @return the reversed string. */
    public static String stringReverse(String str) {
        StringBuilder toReturn = new StringBuilder();
        char[] newExp = str.toCharArray();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (newExp[i] == '(') {
                toReturn.append(")");
            } else if (newExp[i] == ')') {
                toReturn.append("(");
            } else {
                toReturn.append(newExp[i]);
            }
        }
        return toReturn.toString();
    }
}
