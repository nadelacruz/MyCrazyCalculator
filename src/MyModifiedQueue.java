/** <h1>Activity 5.2 (Queues over Stacks)</h1>
 * <p>Objectives: To implement a Queue using a stack as home data structure.</p>*
 * @author Nico Angelo L. Dela Cruz
 * @version 1.0
 * @since 10-22-2020 */
public class MyModifiedQueue {
    private final MyModifiedStack stack1; // Contains the data of the queue.
    private final MyModifiedStack stack2; // Contains the data of the queue.

    /** Initializes the MyQueue to support up to size data items..
     * @param size size of the queue. */
    public MyModifiedQueue(int size) {
        this.stack1 = new MyModifiedStack(size);
        this.stack2 = new MyModifiedStack(size);
    }

    /** Inserts value n at the front of the queue.
     * @param n value to insert to the front of the queue.
     * @throws QueueFullException when called on a full queue. */
    public void enqueue(String n) throws QueueFullException{
        try {
            while (!(this.stack2.isEmpty())) {
                this.stack1.push(this.stack2.pop());
            }
            this.stack1.push(n);
        } catch (Exception ex) {
            throw new QueueFullException();
        }
    }

    /** Removes the item at the front of the queue and returns it.
     * @return the item at the front of the queue.
     * @throws QueueEmptyException when called on an empty queue. */
    public String dequeue() throws QueueEmptyException {
        String toReturn;
        try {
            while (!(this.stack1.isEmpty())) {
                this.stack2.push(this.stack1.pop());
            }
            toReturn = this.stack2.pop();
        } catch (Exception ex) {
            throw new QueueEmptyException();
        }
        return toReturn;
    }

    /** @return the item in front of the queue.
     * @throws QueueEmptyException when called on an empty queue. */
    public String peek() throws QueueEmptyException{
        String toReturn;
        try {
            while (!(this.stack1.isEmpty())) {
                this.stack2.push(this.stack1.pop());
            }
            toReturn = this.stack2.peek();
        } catch (Exception ex) {
            throw new QueueEmptyException();
        }
        return toReturn;
    }

    /** Converts the queue into a string.*/
    @Override
    public String toString() {
        try {
            while (!(this.stack1.isEmpty())) {
                this.stack2.push(this.stack1.pop());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return this.stack2.toString();
    }
}
