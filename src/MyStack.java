/** MyStack Implementation.
 * @author Nico Angelo L. Dela Cruz
 * @version 1.0
 * @since 10-20-2020 */
public class MyStack {
    private final String[] data; // Holds the data of the stack.
    private final int max; // Holds the maximum value of the stack.
    private int top; // Holds the top value of the stack.

    /** Initializes MyStack with an initialized array with size size. Sets the default values of variables this.max and this.top.
     * @param size the size for the stack.*/
    public MyStack(int size) {
        this.max = size;
        this.data = new String[this.max];
        this.top = -1;
    }

    /**@return the value at the top of the stack.
     * @throws StackEmptyException when called on an empty stack. */
    public String peek() throws StackEmptyException{
        if (top == -1) {
            throw new StackEmptyException();
        } else {
            return this.data[top];
        }
    }

    /** Removes the value at the top of the stack.
     * @return the value at the top of the stack.
     * @throws StackEmptyException when called on an empty stack. */
    public String pop() throws StackEmptyException{
        String temp;
        if (top == -1) {
            throw new StackEmptyException();
        } else {
            temp = this.data[top];
            this.top--;
        }
        return temp;
    }

    /** Inserts the value n at the top of the stack.
     * @param n the value you want to put at the top of the stack.
     * @throws StackFullException when called on a "full" stack. */
    public void push(String n) throws StackFullException {
        if (this.top == this.max - 1) {
            throw new StackFullException();
        } else {
            this.top++;
            this.data[top] = n;
        }
    }

    /**@return true if stack is full, false if not.*/
    public boolean isFull() {
        return this.top == this.max - 1;
    }

    /**@return true if stack is empty, false if not.*/
    public boolean isEmpty() {
        return this.top == -1;
    }

    /** Converts the stack into a string.*/
    @Override
    public String toString() {
        StringBuilder stack = new StringBuilder("***********" + "\n");
        for (int i = this.max; i > 0; i--) {
            if (i > this.top + 1) {
                stack.append("Empty " + "\n");
            } else {
                stack.append(this.data[i - 1]).append(" \n");
            }
        }
        stack.append("***********");
        return stack.toString();
    }
}
