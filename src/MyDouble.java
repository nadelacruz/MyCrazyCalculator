/** MyDouble implementation.
 * @author Nico Angelo L. Dela Cruz
 * @version 1.0 */
public class MyDouble {
    private double val; //Value of MyDouble.

    /** Sets the value of MyDouble to 0. */
    public MyDouble() {
        this.setValue(0);
    }

    /** Sets the value of MyDouble to val.
     * @param val the value to be represented by the MyDouble object. */
    public MyDouble(double val) {
        this.setValue(val);
    }

    /** @return the int value of the MyDouble object. */
    public double getValue() {
        return this.val;
    }

    /** Resets the value of this MyDouble to val.
     * @param val the value to be represented by the MyDouble object. */
    public void setValue(double val) {
        this.val = val;
    }

    /** Resets the value of this MyDouble to the value of val.
     * @param val a MyDouble object to perform the method's operation on. */
    public void setValue(MyDouble val) {
        this.val = val.getValue();
    }

    /** Adds the value of val to the value of this MyDouble.
     * @param val a MyDouble object to perform the method's operation on. */
    public void add(MyDouble val) {
        this.setValue(this.getValue() + val.getValue());
    }

    /** Subtracts the value of val to the value of this MyDouble.
     * @param val a MyDouble object to perform the method's operation on. */
    public void subtract(MyDouble val) {
        this.setValue(this.getValue() - val.getValue());
    }

    /** Divides the value of this MyDouble by the value of val.
     * @param val a MyDouble object to perform the method's operation on. */
    public void divide(MyDouble val) {
        this.setValue(this.getValue() / val.getValue());
    }

    /** Multiples the value of this MyDouble by the value of val.
     * @param val a MyDouble object to perform the method's operation on. */
    public void multiply(MyDouble val) {
        this.setValue(this.getValue() * val.getValue());
    }

    /** Raises the value of this MyDouble to the power of the value of val.
     * @param val a MyDouble object to perform the method's operation on. */
    public void raise(MyDouble val) {
        double x = this.getValue();
        for (int i = 1; i < val.getValue(); i++) {
            x *= this.getValue();
        }
        this.setValue(x);
    }

    /** Gets the Modulo of the value of this MyDouble and the value of val.
     * @param val a MyDouble object to perform the method's operation on. */
    public void modulo(MyDouble val) {
        this.setValue(this.getValue() % val.getValue());
    }

    /** @return a string object with the value of this MyDouble. */
    @Override
    public String toString() {
        return String.valueOf(this.getValue());
    }
}
