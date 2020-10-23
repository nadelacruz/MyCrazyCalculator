/** A stack built on top of a queue.
 * @author Nico Angelo L. Dela Cruz
 * @version 1.0
 * @since 10-23-2020 */
public class CalcStack {
    /** Holds the data of the class. */
    private MyModifiedQueue queue1;

    /** Holds the data of the class. */
    private MyModifiedQueue queue2;

    /** Holds the number of elements of the class*/
    private int currentSize;

    /** Holds the maximum value of the stack. */
    private int max;

    /** Initializes CalcStack with two initialized queues with size size.
     * @param size the size for the stack.*/
    public CalcStack(int size) {
        this.max = size;
        this.queue1 = new MyModifiedQueue(this.max);
        this.queue2 = new MyModifiedQueue(this.max);
    }

    /**@return the value at the top of the stack.
     * @throws StackEmptyException when called on an empty stack. */
    public String peek() throws StackEmptyException{
        String temp = "";
        if (this.queue1.isEmpty()) {
            throw new StackEmptyException();
        } else {
            try {
                temp = queue1.peek();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return temp;
    }

    /** Removes the value at the top of the stack.
     * @return the value at the top of the stack.
     * @throws StackEmptyException when called on an empty stack. */
    public String pop() throws StackEmptyException{
        String temp = "";
        if (this.queue1.isEmpty()) {
            throw new StackEmptyException();
        } else {
            try {
                temp = queue1.dequeue();
                this.currentSize--;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return temp;
    }

    /** Inserts the value n at the top of the stack.
     * @param n the value you want to put at the top of the stack.
     * @throws StackFullException when called on a "full" stack. */
    public void push(String n) throws StackFullException {
        if (this.currentSize == this.max) {
            throw new StackFullException();
        } else {
            try {
                this.currentSize++;

                this.queue2.enqueue(n);

                while(!(this.queue1.isEmpty())) {
                    this.queue2.enqueue(this.queue1.dequeue());
                }

                MyModifiedQueue tempQueue;
                tempQueue = this.queue1;
                this.queue1 = this.queue2;
                this.queue2 = tempQueue;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**@return true if stack is full, false if not.*/
    public boolean isFull() {
        return this.currentSize == this.max;
    }

    /**@return true if stack is empty, false if not.*/
    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    /** Converts the stack into a string.*/
    @Override
    public String toString() {
        StringBuilder stack = new StringBuilder("***********" + "\n");
        for (int i = this.max; i > 0; i--) {
            if (i > this.currentSize) {
                stack.append("Empty " + "\n");
            } else {
                try {
                    stack.append(this.queue1.dequeue()).append(" \n");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        stack.append("***********");
        return stack.toString();
    }
}
