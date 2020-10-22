/** Tester class for the MyCrazyCalculator class, contains the main method. */
public class MyCrazyCalculatorTester {
    /** This is the main method which makes use of MyCrazyCalculator class operations.
     * @param args Unused. */
    public static void main(String[] args) {
        MyCrazyCalculator crazyCalc = new MyCrazyCalculator(9);
        System.out.println(crazyCalc.InfixToPostfix("( ( A + B ) * C - D ) * E ^ 2 + ( A + B )"));
    }
}