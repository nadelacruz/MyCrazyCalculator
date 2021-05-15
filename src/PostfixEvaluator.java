public class PostfixEvaluator implements ExpressionEvaluator {

    /** Evaluates a postfix expression.
     * @param exp the expression to be evaluated.
     * @param length the size of the stack.
     * @return the string equivalent of the evaluated expression. */
    @Override
    public String evaluate(String exp, int length) {
        CalcStack stack = new CalcStack(length);

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
                    stack.push(tempExp);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (HelperMethods.isOperator(tempExp)) {
                String op2;
                String op1;
                try {
                    op2 = stack.pop();
                    op1 = stack.pop();
                    result = HelperMethods.perform(tempExp, op1, op2);
                    stack.push(result);
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
            toReturn = stack.peek();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return toReturn;
    }
}
