/** Tester class for the MyCrazyCalculator class, contains the main method. */
public class MyCrazyCalculatorTester {
    /** This is the main method which makes use of MyCrazyCalculator class operations.
     * @param args Unused. */
    public static void main(String[] args) {
//        MyCrazyCalculator crazyCalc = new MyCrazyCalculator(10);

//        VALID INFIX EXPRESSIONS
//        System.out.println(crazyCalc.infixChecker("( ( 1 + 2 ) * 3 - 4 ) * 5 ^ 2 + ( 6 + 7 )"));
//        System.out.println(crazyCalc.infixChecker("( 4 + 5 ) * 6"));
//        System.out.println(crazyCalc.infixChecker("3 + ( 4 * 5 )"));
//        System.out.println(crazyCalc.infixChecker("3 ^ 2"));

//        INVALID INFIX EXPRESSIONS
//        System.out.println(crazyCalc.infixChecker("( ( A + B ) * C - D ) * E ^ F + ( G + H )"));
//        System.out.println(crazyCalc.infixChecker("( + )"));
//        System.out.println(crazyCalc.infixChecker("5 +"));
//        System.out.println(crazyCalc.infixChecker("5 ( + 7 )"));
//        System.out.println(crazyCalc.infixChecker("( 5 + 6 ) )"));
//        System.out.println(crazyCalc.infixChecker("50 ( 1 )"));
//        System.out.println(crazyCalc.infixChecker("( 5 + ) 7"));
//        System.out.println(crazyCalc.infixChecker("5 + +"));
//        System.out.println(crazyCalc.infixChecker("5+6"));
//        System.out.println(crazyCalc.infixChecker("( 1+ 7 )"));

//        System.out.println(crazyCalc.evaluate("5 + 5"));
//        System.out.println(crazyCalc.evaluate("( 3 + 5 ) ^ 2"));
//        System.out.println(crazyCalc.evaluate("( ( 1 + 2 ) * 3 - 4 ) * 5 ^ 2 + ( 6 + 7 )"));
//        System.out.println(crazyCalc.evaluate("( 5 + 5 ) * 5"));
//
//        System.out.println(crazyCalc.evaluate("(5+5)*5")); // Error because the expression has no spaces in between every operand, operator, and parentheses.

        Menu menu = new Menu();
        menu.acceptInput(menu.askInput());

    }
}