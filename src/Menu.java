import java.util.Scanner;

import static java.util.Objects.isNull;

public class Menu {
    private String infixExpression;
    private String convertedExpression;
    private String prefixOrPostfix;
    public String printedInfixExpression;
    public String printedConvertedExpression;
    public String printedEvaluatedExpression;
    public String evaluatedExpression;

    public void showMenu() {
        System.out.println("Infix Expression to Other Notation Converter and Evaluator" + "\n");
        System.out.println("1. Enter Infix Expression");
        System.out.println("2. Convert Infix Expression to Prefix Expression");
        System.out.println("3. Convert Infix Expression to Postfix Expression");
        System.out.println("4. See Inputted Infix Expression");
        System.out.println("5. See Converted Expression");
        System.out.println("6. Evaluate Converted Expression");
        System.out.println("7. Exit" + "\n");
        System.out.print("Your choice: ");
    }

    public String getInfixExpression() {
        return this.infixExpression;
    }

    public String getConvertedExpression() {
        return this.convertedExpression;
    }

    private void askInfixExpression() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a valid infix expression: ");
            this.infixExpression = scanner.nextLine();
        } while (!InfixChecker.checkInfix(this.infixExpression));
    }

    public boolean validateInfixExpression() {
        if(isNull(this.infixExpression) || InfixChecker.checkInfix(this.infixExpression) == false) {
            System.out.println("Please enter a valid infix expression.");
            return false;
        }
        return true;
    }

    public boolean validateConvertedExpression() {
        if(isNull(this.convertedExpression)) {
            System.out.println("Please evaluate the infix expression.");
            return false;
        }
        return true;
    }

    public void acceptInput(int input) {
        switch(input) {
            case 1:
                askInfixExpression();
                break;
            case 2:
                this.convertedExpression = null;
                boolean isValid = validateInfixExpression();
                if (isValid) {
                    InfixToPrefixConverter prefixConverter = new InfixToPrefixConverter();
                    this.convertedExpression = prefixConverter.convert(this.infixExpression, this.infixExpression.length());
                    this.prefixOrPostfix = "prefix";
                }
                break;
            case 3:
                this.convertedExpression = null;
                isValid = validateInfixExpression();
                if (isValid) {
                    InfixToPostfixConverter postfixConverter = new InfixToPostfixConverter();
                    this.convertedExpression = postfixConverter.convert(this.infixExpression, this.infixExpression.length());
                    this.prefixOrPostfix = "postfix";
                }
                break;
            case 4:
                printedInfixExpression = null;
                isValid = validateInfixExpression();
                if (isValid) {
                    printedInfixExpression = "Infix expression: " + this.infixExpression;
                    System.out.println(printedInfixExpression);
                }
                break;
            case 5:
                printedConvertedExpression = null;
                isValid = validateConvertedExpression();
                if (isValid) {
                    printedConvertedExpression = "Converted expression: " + this.convertedExpression;
                    System.out.println(printedConvertedExpression);
                }
                break;
            case 6:
                printedEvaluatedExpression = null;
                evaluatedExpression = null;
                isValid = validateConvertedExpression();
                if (isValid) {
                    ExpressionEvaluator evaluator;
                    if (this.prefixOrPostfix.equals("prefix")) {
                        evaluator = new PrefixEvaluator();
                    } else {
                        evaluator = new PostfixEvaluator();
                    }
                    evaluatedExpression = evaluator.evaluate(this.convertedExpression,  this.infixExpression.length());
                    printedEvaluatedExpression = "Evaluated expression: " + evaluatedExpression;
                    System.out.println(printedEvaluatedExpression);
                }
                break;
            case 7:
                System.exit(0);
                break;
        }
//
//        if (input == 1) {
//            askInfixExpression();
//        } else if (input == 2) {
//            boolean isValid = validateInfixExpression();
//            if (isValid) {
//                InfixToPrefixConverter prefixConverter = new InfixToPrefixConverter();
//                this.convertedExpression = prefixConverter.convert(this.infixExpression, this.infixExpression.length());
//                this.prefixOrPostfix = "prefix";
//            }
//        } else if (input == 3) {
//            boolean isValid = validateInfixExpression();
//            if (isValid) {
//                InfixToPostfixConverter postfixConverter = new InfixToPostfixConverter();
//                this.convertedExpression = postfixConverter.convert(this.infixExpression, this.infixExpression.length());
//                this.prefixOrPostfix = "postfix";
//            }
//        } else if (input == 4) {
//            boolean isValid = validateInfixExpression();
//            if (isValid) {
//                System.out.println("Infix expression: " + this.infixExpression);
//            }
//        } else if (input == 5) {
//            boolean isValid = validateConvertedExpression();
//            if (isValid) {
//                System.out.println("Converted expression: " + this.infixExpression);
//            }
//        } else if (input == 6) {
//            boolean isValid = validateConvertedExpression();
//            if (isValid) {
//                ExpressionEvaluator evaluator;
//                if (this.prefixOrPostfix.equals("prefix")) {
//                    evaluator = new PrefixEvaluator();
//                } else {
//                    evaluator = new PostfixEvaluator();
//                }
//                System.out.println("Evaluated expression: " + evaluator.evaluate(this.convertedExpression,
//                        this.infixExpression.length()));
//            }
//        } else if (input == 7) {
//            System.exit(0);
//        }
        acceptInput(askInput());
    }
    public int askInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = " ";
        while (!validateInput(userInput)) {
            this.showMenu();
            userInput = scanner.nextLine();
        }
        return Integer.parseInt(userInput);
    }
    public boolean validateInput(String input) {
        try {
            return this.checkInputIsInRangeOfOneToSeven(Integer.parseInt(input));
        } catch (Exception ex) {
            return false;
        }
    }
    private boolean checkInputIsInRangeOfOneToSeven(int input) {
        return input >= 1 && input <= 7;
    }
}
