public class PrefixEvaluator extends ExpressionEvaluator {

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
        String reversed;

        reversed = HelperMethods.stringReverse(exp);

        while (foundIndex != -1) {
            foundIndex = reversed.indexOf(' ', foundIndex + 1);
            counter++;
        }

        int indexer1 = 0;
        int indexer2 = reversed.indexOf(' ', indexer1);

        for (int i = 0; i < counter; i++) {
            String tempExp = reversed.substring(indexer1, indexer2);

            if (HelperMethods.isOperand(tempExp)) {
                try{
                    stack.push(tempExp);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (HelperMethods.isOperator(tempExp)) {
                String num1;
                String num2;

                try {
                    num1 = stack.pop();
                    num2 = stack.pop();

                    result = HelperMethods.perform(tempExp, num1, num2);

                    stack.push(result);
                } catch (Exception ex){
                    ex.printStackTrace();
                }

            }

            indexer1 = indexer2 + 1;

            if (i != counter - 2) {
                indexer2 = reversed.indexOf(' ', indexer1);
            } else {
                indexer2 = reversed.length();
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