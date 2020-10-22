/** <h1>Machine Problem I (MyCrazyCalculator)</h1>
 * <p>Objectives: To write a calculator application that is designed around previously discussed data structures (arrays, stacks, and queues).</p>
 * @author Nico Angelo L. Dela Cruz
 * @version 1.0
 * @since 10-22-2020 */
public class MyCrazyCalculator {
    private final MyStack stack; // Holds the data of the class.

    /** Initializes the stack with size length.
     * @param length size of the stack. */
    public MyCrazyCalculator(int length) {
        this.stack = new MyStack(length);
    }

    /** Evaluates postfix expressions.
     * @param exp expression to be evaluated. */
    public String evaluatePostfix(String exp) {
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

            if (this.isOperand(tempExp)) {
                try {
                    this.stack.push(tempExp);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (this.isOperator(tempExp)) {
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

    public String InfixToPostfix(String exp) {
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

            if (this.isOperand(tempExp)) {
                result.append(tempExp).append(" ");
            } else if (this.isOperator(tempExp)) {
                String tempStr = "";
                try {
                    if (!(this.stack.isEmpty())) {
                        tempStr = this.stack.peek();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                while(!(this.stack.isEmpty()) && this.HasHigherPrecedence(tempStr, tempExp)) {
                    try {
                        result.append(this.stack.pop()).append(" ");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                try {
                    this.stack.push(tempExp);
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

        return result.toString();
    }

    /** Checks whether the string is an operator.
     * @return true if operator, false if not. */
    public boolean isOperator(String exp) {
        return exp.equals("+") || exp.equals("-") || exp.equals("*") || exp.equals("/") || exp.equals("^") || exp.equals("%");
    }

    /** Checks whether the string is an operand.
     * @return true if operand, false if not. */
    public boolean isOperand(String exp) {
        return !this.isOperator(exp);
    }

    /** Performs the calculation of the string operator and the operands.
     * @param operator the operator.
     * @param operand1 the first operand.
     * @param operand2 the second operand. */
    public String perform(String operator, String operand1, String operand2) {
        MyInteger x = new MyInteger(Integer.parseInt(operand1));
        MyInteger y = new MyInteger(Integer.parseInt(operand2));

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

    /** Checks if expression is an open parenthesis.
     * @param exp expression to be checked.
     * @return true if exp is an open parenthesis, false if not.*/
    public boolean IsOpeningParenthesis(String exp) {
        return exp.equals("(");
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