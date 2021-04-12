public class InfixToPostfixConverter {
    /** Converts a infix equation to a postfix equation.
     * @param exp the expression to convert.
     * @return the converted equation. */
    public static String ConvertInfixToPostfix(String exp, int length) {
        CalcStack stack = new CalcStack(length);

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
                    if (!(stack.isEmpty())) {
                        tempStr = stack.peek();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                while(!(stack.isEmpty()) && !(tempStr.equals("(")) && HelperMethods.HasHigherPrecedence(tempStr, tempExp)) {
                    try {
                        result.append(stack.pop()).append(" ");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    try {
                        if (!(stack.isEmpty())) {
                            tempStr = stack.peek();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                try {
                    stack.push(tempExp);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (tempExp.equals("(")) {
                try {
                    stack.push(tempExp);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (tempExp.equals(")")) {
                String tempStr = "";
                try {
                    if (!(stack.isEmpty())) {
                        tempStr = stack.peek();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                while(!(stack.isEmpty()) && !(tempStr.equals("("))) {
                    try {
                        result.append(stack.pop()).append(" ");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    try {
                        if (!(stack.isEmpty())) {
                            tempStr = stack.peek();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                try {
                    stack.pop();
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
        while (!(stack.isEmpty())) {
            String tempStr = "";
            try {
                tempStr = stack.peek();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            result.append(tempStr).append(" ");
            try {
                stack.pop();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }
}
