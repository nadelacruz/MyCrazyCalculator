public abstract class ExpressionEvaluator {
    /** Evaluates a prefix or a postfix expression.
     * @param exp the expression to be evaluated.
     * @param length the size of the stack.
     * @return the string equivalent of the evaluated expression. */
    public abstract String evaluate(String exp, int length);
}
