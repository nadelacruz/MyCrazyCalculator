public abstract class NotationConverter {
    /** Converts an infix expression to a prefix or postfix expression.
     * @param exp the infix expression to be converted.
     * @param length the size of the stack.
     * @return the converted expression. */
    public abstract String convert(String exp, int length);
}
