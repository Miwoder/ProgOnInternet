public class ExceptionAAA3 extends Exception {

    public ExceptionAAA3() {
    }

    @Override
    public String getMessage() {
        return "parameter < 0";
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
