/** <h1>Machine Problem I (MyCrazyCalculator)</h1>
 * <p>Objectives: To write a calculator application that is designed around previously discussed data structures (arrays, stacks, and queues).</p>
 * @author Nico Angelo L. Dela Cruz
 * @version 1.0
 * @since 10-22-2020 */
public class MyCrazyCalculator {
    /** Holds the data of the class. */
    private CalcStack stack;

    /** Length of the stack. */
    private final int length;

    /** Initializes the stack with size length.
     * @param length size of the stack. */
    public MyCrazyCalculator(int length) {
        this.length = length;
        this.stack = new CalcStack(this.length);
    }

    /** Evaluates the string expression and outputs the numeric value of string expression.
     * @param expression expression that will undergo evaluation.
     * @return the numeric result after evaluating expression.*/
    public double evaluate(String expression) {
        double finalOperand = -1;
        if (InfixChecker.checkInfix(expression)) {
            finalOperand = Double.parseDouble(this.evaluatePostfix(this.InfixToPostfix(expression)));
        } else {
            System.out.println("Error. Invalid infix expression detected. See MyCrazyCalculatorTester for the list of valid and invalid infix expressions.");
            System.exit(0);
        }
        return finalOperand;
    }
    
    /** Evaluates postfix expressions.
     * @param exp expression to be evaluated.
     * @return the string equivalent of the evaluated expression. */
    public String evaluatePostfix(String exp) {
        this.stack = new CalcStack(this.length);

        String result;
        String toReturn = "";
        int foundIndex = 0;
        int counter = 0;

        while (foundIndex != -1) {
            foundIndex = exp.indexOf(' ', foundIndex + 1);
            counter++;
        }

        int indexer1 = 0;
        int indexer2 = exp.indexOf(' ', indexer1);

        for (int i = 0; i < counter; i++) {
            String tempExp = exp.substring(indexer1, indexer2);

            if (HelperMethods.isOperand(tempExp)) {
                try {
                    this.stack.push(tempExp);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (HelperMethods.isOperator(tempExp)) {
                String op2;
                String op1;
                try {
                    op2 = this.stack.pop();
                    op1 = this.stack.pop();
                    result = this.perform(tempExp, op1, op2);
                    this.stack.push(result);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            indexer1 = indexer2 + 1;

            if (i != counter - 2) {
                indexer2 = exp.indexOf(' ', indexer1);
            } else {
                indexer2 = exp.length();
            }
        }

        try {
            toReturn = this.stack.peek();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return toReturn;
    }

    /** Converts a infix equation to a postfix equation.
     * @param exp the expression to convert.
     * @return the converted equation. */
    public String InfixToPostfix(String exp) {
        this.stack = new CalcStack(this.length);

        StringBuilder result = new StringBuilder();
        int foundIndex = 0;
        int counter = 0;

        while (foundIndex != -1) {
            foundIndex = exp.indexOf(' ', foundIndex + 1);
            counter++;
        }

        int indexer1 = 0;
        int indexer2 = exp.indexOf(' ', indexer1);

        for (int i = 0; i < counter; i++) {
            String tempExp = exp.substring(indexer1, indexer2);

            if (HelperMethods.isOperand(tempExp)) {
                result.append(tempExp).append(" ");
            } else if (HelperMethods.isOperator(tempExp)) {
                String tempStr = "";
                try {
                    if (!(this.stack.isEmpty())) {
                        tempStr = this.stack.peek();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                while(!(this.stack.isEmpty()) && !(tempStr.equals("(")) && this.HasHigherPrecedence(tempStr, tempExp)) {
                    try {
                        result.append(this.stack.pop()).append(" ");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    try {
                        if (!(this.stack.isEmpty())) {
                            tempStr = this.stack.peek();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                try {
                    this.stack.push(tempExp);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (tempExp.equals("(")) {
                try {
                    this.stack.push(tempExp);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (tempExp.equals(")")) {
                String tempStr = "";
                try {
                    if (!(this.stack.isEmpty())) {
                        tempStr = this.stack.peek();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                while(!(this.stack.isEmpty()) && !(tempStr.equals("("))) {
                    try {
                        result.append(this.stack.pop()).append(" ");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    try {
                        if (!(this.stack.isEmpty())) {
                            tempStr = this.stack.peek();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                try {
                    this.stack.pop();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            indexer1 = indexer2 + 1;

            if (i != counter - 2) {
                indexer2 = exp.indexOf(' ', indexer1);
            } else {
                indexer2 = exp.length();
            }
        }
        while (!(this.stack.isEmpty())) {
            String tempStr = "";
            try {
                tempStr = this.stack.peek();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            result.append(tempStr).append(" ");
            try {
                this.stack.pop();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }
    
    /** Performs the calculation of the string operator and the operands.
     * @param operator the operator.
     * @param operand1 the first operand.
     * @param operand2 the second operand.
     * @return the evaluated expression. */
    public String perform(String operator, String operand1, String operand2) {
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

    /** Checks if exp1 has higher operator precedence than exp2.
     * @param exp1 first operator.
     * @param exp2 second operator.
     * @return true if exp1 has higher precedence than exp 2, false if not. */
    public boolean HasHigherPrecedence(String exp1, String exp2) {
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
