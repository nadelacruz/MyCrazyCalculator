public class ExpressionIdentifier {
    /** Identifies whether an expression is in prefix notation or postfix notation.
     * @param exp the expression to be identified.
     * @return "prefix" if the expression is in prefix notation, "postfix" if the expression is in postfix notation. */
    public static String identify(String exp) {
        String returnString = null;

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

            if (i == 0 && HelperMethods.isOperator(tempExp)) {
                returnString = "prefix";
            } else if (i == 0 && HelperMethods.isOperand(tempExp)) {
                returnString = "postfix";
            }
        }

        return returnString;
    }
}
