/** MyInteger implementation.
 * @author Nico Angelo L. Dela Cruz
 * @version 1.0 */
public class MyInteger {
    private int val; //Value of MyInteger.

    /** Sets the value of MyInteger to 0. */
    public MyInteger() {
        this.setValue(0);
    }

    /** Sets the value of MyInteger to val.
     * @param val the value to be represented by the MyInteger object. */
    public MyInteger(int val) {
        this.setValue(val);
    }

    /** @return the int value of the MyInteger object. */
    public int getValue() {
        return this.val;
    }

    /** Resets the value of this MyInteger to val.
     * @param val the value to be represented by the MyInteger object. */
    public void setValue(int val) {
        this.val = val;
    }

    /** Resets the value of this MyInteger to the value of val.
     * @param val a MyInteger object to perform the method's operation on. */
    public void setValue(MyInteger val) {
        this.val = val.getValue();
    }

    /** Adds the value of val to the value of this MyInteger.
     * @param val a MyInteger object to perform the method's operation on. */
    public void add(MyInteger val) {
        this.setValue(this.getValue() + val.getValue());
    }

    /** Subtracts the value of val to the value of this MyInteger.
     * @param val a MyInteger object to perform the method's operation on. */
    public void subtract(MyInteger val) {
        this.setValue(this.getValue() - val.getValue());
    }

    /** Divides the value of this MyInteger by the value of val.
     * @param val a MyInteger object to perform the method's operation on. */
    public void divide(MyInteger val) {
        this.setValue(this.getValue() / val.getValue());
    }

    /** Multiples the value of this MyInteger by the value of val.
     * @param val a MyInteger object to perform the method's operation on. */
    public void multiply(MyInteger val) {
        this.setValue(this.getValue() * val.getValue());
    }

    /** Raises the value of this MyInteger to the power of the value of val.
     * @param val a MyInteger object to perform the method's operation on. */
    public void raise(MyInteger val) {
        int x = this.getValue();
        for (int i = 1; i < val.getValue(); i++) {
            x *= this.getValue();
        }
        this.setValue(x);
    }

    /** Gets the Modulo of the value of this MyInteger and the value of val.
     * @param val a MyInteger object to perform the method's operation on. */
    public void modulo(MyInteger val) {
        this.setValue(this.getValue() % val.getValue());
    }

    /** @return a string object with the value of this MyInteger. */
    @Override
    public String toString() {
        return String.valueOf(this.getValue());
    }
}
