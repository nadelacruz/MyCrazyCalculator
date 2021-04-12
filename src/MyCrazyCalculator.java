/** <h1>Machine Problem I (MyCrazyCalculator)</h1>
 * <p>Objectives: To write a calculator application that is designed around previously discussed data structures (arrays, stacks, and queues).</p>
 * @author Nico Angelo L. Dela Cruz
 * @version 1.0
 * @since 10-22-2020 */
public class MyCrazyCalculator {
    /** Length of the stack. */
    private final int length;

    /** Initializes the stack with size length.
     * @param length size of the stack. */
    public MyCrazyCalculator(int length) {
        this.length = length;
    }

    /** Evaluates the string expression and outputs the numeric value of string expression.
     * @param expression expression that will undergo evaluation.
     * @return the numeric result after evaluating expression.*/
    public double evaluate(String expression) {
        double finalOperand = -1;
        if (InfixChecker.checkInfix(expression)) {
            finalOperand = Double.parseDouble(PostfixEvaluator.evaluatePostfix(InfixToPostfixConverter.ConvertInfixToPostfix(expression, this.length), this.length));
        } else {
            System.out.println("Error. Invalid infix expression detected. See MyCrazyCalculatorTester for the list of valid and invalid infix expressions.");
            System.exit(0);
        }
        return finalOperand;
    }
}
