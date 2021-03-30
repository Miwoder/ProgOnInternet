public class Main {

    public static void main(String[] args) {
        int a1 = 8;
        int b1 = 5;
        float a2 = 43.123F;
        float b2 = 13.336F;
        double a3;
        double b3;
        a3 = 543.233334;
        b3 = 362.874;
        int result1 = (int) Math.pow(a1, 2) - (int) Math.pow(b1, 2);
        float result2 = (float) Math.pow(a2, 3) - (float) Math.pow(b2, 3);
        double result3 = (double) Math.pow(a3, 4) - (double) Math.pow(b3, 4);

        System.out.printf("Result1: %d, Result2: %f, Result3: %f ", result1, result2, result3);
        //cd....  javac Main.java      java Main

        System.out.println();

        char a = 'g';
        char b = 'e';
        char c = (char) (a + b);
        char d = (char) (a - b);
        System.out.println(c + " " + d);

        int[] xx = new int[10];
        for (int i = 0; i < xx.length; i++) {
            xx[i] = i;
        }
        for (int i = 0; i < xx.length; i++) {
            System.out.println(xx[i]);
        }

        int[][] xx2 = new int[5][5];
        for (int i = 0; i < xx2.length; i++) {
            for (int j = 0; j < xx2[i].length; j++) {
                xx2[i][j] = i + j;
            }
        }
        for (int i = 0; i < xx2.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < xx2[i].length; j++) {
                System.out.println(xx2[i][j]);
            }
        }


        System.out.println();
        byte aa1 = 12;
        System.out.println(~aa1);
        System.out.println(aa1 >>> 1);

        int ba1 = 2;
        ba1 <<= 2;
        System.out.println("<<= " + ba1);

        ba1 ^= 2;
        System.out.println("^= " + ba1); // или

        int ccc = 0;
        ccc = ba1 & aa1;
        System.out.println("& " + ccc); // и

        int perv = 1;
        int vtor = 2;
        int tret = 3;
        boolean result = false;
        if (perv == 1 || vtor == 4) {
            result = true;
            System.out.println(result);
        }

        if (perv == 1 && vtor == 2) {
            result = true;
            System.out.println(result);
        }

        result = (perv == 1) ? true : false;
        System.out.println(result);


        System.out.println("");
        for (int i = 0; i < 4; i++) {
            System.out.print("Hello for ");
        }
        int i = 1;
        if (i == 1)
            System.out.println("Hello if");

        while (i < 3) {
            System.out.println("Hello while");
            i++;
        }

        do {
            System.out.println("Hello do");
            i++;
        } while (i < 5);


        switch (i) {
            case 1:
                System.out.println("Hello switch 1");
                break;
            case 2:
                System.out.println("Hello switch 2");
            case 3:
            case 4:
            case 5:
                System.out.println("Hello switch 3,4, 5");
            default:
                System.out.println("default");
        }


        Human human = new Human();
        System.out.println(human.weight);

        Human human2 = new Human();
        human2.weight = 5;
        System.out.println(human2.weight);


        Human.count=1;
        Human.сounter();

    }

}
class Human{
    static int weight = 2;

    static int count;

    public static void сounter() {
        count++;
        System.out.println("Значение - " + count);
    }
}