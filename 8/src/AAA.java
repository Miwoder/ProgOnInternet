public class AAA {

    public AAA(Integer i) throws ExceptionAAA1 {
        if(i==null)
            throw new ExceptionAAA1();
    }

    public void methode(int i) throws ExceptionAAA2, ExceptionAAA3{
        if(i==0)
            throw new ExceptionAAA2();
        else if(i<0)
            throw new ExceptionAAA3();
    }
}
