/** QueueEmptyException class. Threw when user is trying to operate on an empty queue.*/
public class QueueEmptyException extends Exception {
    public QueueEmptyException() {
        super("Error, queue is empty.");
    }
}
