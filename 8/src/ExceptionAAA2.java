public class ExceptionAAA2 extends Exception {

    public ExceptionAAA2() {
    }

    @Override
    public String getMessage() {
        return "parameter is 0";
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
