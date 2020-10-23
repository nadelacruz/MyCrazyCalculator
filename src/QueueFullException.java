/** QueueFullException class. Threw when user is trying to operate on a full queue.*/
public class QueueFullException extends Exception {
    public QueueFullException() {
        super("Error, queue is full.");
    }
}
