public class Main {

    public static void main(String[] args) {
        CCC ccc = new CCC();
        System.out.println("Пустой конструктор: "+ ccc.x + " " + ccc.getY());
        ccc.x = 123;
        ccc.setY(23);
        System.out.println("Присвоение значений: "+ ccc.x + " " + ccc.getY());
        System.out.println("Сумма: " + ccc.sum(ccc.x, ccc.getY()));
        System.out.println("Разность: " + CCC.ssub(ccc.x, ccc.getY()));

        CCC ccc2 = new CCC(1213, 321);
        System.out.println("Заполненный конструктор: "+ ccc2.x + " " + ccc2.getY());

        System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
        System.out.println();

        DDD ddd = new DDD();
        System.out.println("Пустой конструктор: " + ddd.x + " " + ddd.getY());
        ddd.x = 543;
        ddd.setY(213);
        System.out.println("Присвоение значений: "+ ddd.x + " " + ddd.getY());
        System.out.println("Сумма: " + ddd.sum(ddd.x, ddd.getY()));
        System.out.println("Calc: " + ddd.calc(ddd.x, ddd.getY()));

        DDD ddd2 = new DDD(3, 5);
        System.out.println("Заполненный конструктор: "+ ddd2.x + " " + ddd2.getY());
        System.out.println("Calc: " + ddd2.calc(ddd2.x, ddd2.getY()));
    }
}

class CCC{
    public int x;
    private int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CCC() {
        this.x = 0;
        this.y = 0;
    }

    public CCC(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int sum(int x, int y){
        return x+y;
    }

    public static int ssub(int x, int y){
        return x-y;
    }
}

class DDD extends CCC{
    public int x;
    private int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public DDD() {
        super();
        this.x = 1;
        this.setY(1);
    }

    public DDD(int x, int y) {
        super(x,y);
        this.x = x;
        this.y = y;

    }

    public int sum(int x, int y){
        return super.sum(super.x, super.getY()) + x + y;
    }

    public int calc(int x, int y){
        return x*y + super.x*super.getY();
    }
}