public class ExceptionAAA1 extends Exception {

    public ExceptionAAA1() {
    }

    @Override
    public String getMessage() {
        return "parameter is NULL";
    }

    @Override
    public void printStackTrace() {
        this.printStackTrace();
    }

    @Override
    public String toString() {
        return "My string" + super.toString();
    }
}
