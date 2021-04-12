public class InfixChecker {
    public static boolean checkInfix(String exp) {
        boolean isTrue = true;

        int foundIndex = 0;
        int counter = 0;

        while (foundIndex != -1) {
            foundIndex = exp.indexOf(' ', foundIndex + 1);
            counter++;
        }

        String[] element = new String[counter];
        int operatorCount = 0;
        int operandCount = 0;
        int openParenthesisCount = 0;
        int closingParenthesisCount = 0;

        int indexer1 = 0;
        int indexer2 = exp.indexOf(' ', indexer1);

        for (int i = 0; i < counter && counter > 1; i++) {
            String tempExp = exp.substring(indexer1, indexer2);

            element[i] = tempExp;

            if (HelperMethods.isOperator(element[i])) {
                operatorCount++;
            } else if (HelperMethods.isOperand(element[i])) {
                operandCount++;
            } else if (element[i].equals("(")) {
                openParenthesisCount++;
            } else if (element[i].equals(")")) {
                closingParenthesisCount++;
            }

            indexer1 = indexer2 + 1;

            if (i != counter - 2) {
                indexer2 = exp.indexOf(' ', indexer1);
            } else {
                indexer2 = exp.length();
            }
        }

        for (int i = 0; i < counter && counter > 1; i++) {
            if (HelperMethods.isOperator(element[i])) {
                if (i == counter - 1) {
                    isTrue = false;
                }
                if (i == 0) {
                    isTrue = false;
                }
                if (counter - 1 - i > 0 && i != 0) {
                    if (!(HelperMethods.isOperand(element[i - 1]) || element[i - 1].equals(")")) || !(HelperMethods.isOperand(element[i + 1]) || element[i + 1].equals("("))) {
                        isTrue = false;
                    }
                    if (element[i-1].equals("(") || element[i+1].equals(")")) {
                        isTrue = false;
                    }
                }
            }
            if (HelperMethods.isOperand(element[i])) {
                try {
                    Integer.parseInt(element[i]);
                } catch (Exception ex) {
                    isTrue = false;
                }
            }
        }

        if (operatorCount <= 0 || operandCount <= 0) {
            isTrue = false;
        } if (openParenthesisCount != closingParenthesisCount) {
            isTrue = false;
        }

        return isTrue;
    }
}
