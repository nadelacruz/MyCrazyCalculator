/** StackFullException class. Threw when user is trying to operate on a full stack.*/
public class StackFullException extends Exception{
    public StackFullException() {
        super("Error, stack is full.");
    }
}
