/** StackEmptyException class. Threw when user is trying to operate on an empty stack.*/
public class StackEmptyException extends Exception{
    public StackEmptyException() {
        super("Error, stack is empty.");
    }
}
