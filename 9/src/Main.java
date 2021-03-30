public class Main {

    public static void main(String[] args) {
	    String s01 = new String();
        System.out.println("s01.length = " + s01.length());

        char[] cs = { '0', '1', '2', '3', '4', '5', '6', '7'};
        String s02 = new String(cs);
        System.out.println("s02.length = " + s02.length() + "\t s02 = " + s02);

        String s03 = new String(cs, 3, 5);
        System.out.println("s03.length = " + s03.length() + "\t s03 = " + s03);

        String s04 = "01234567";
        System.out.println("s04.length = " + s04.length() + "\t s04 = " + s04);

        String s05 =new String("01234567");
        System.out.println("s05.length = " + s05.length() + "\t s05 = " + s05);
        System.out.println();

        ////////////////////////////////////
        System.out.println("\"01234567\".length = " + "01234567".length());

        String s06 = new String("01234567");
        for (int i = 0; i<s06.length(); i++){
            System.out.print(s06.charAt(i) + ((i<s06.length()-1) ? "-" : ""));
        }
        System.out.println("");
        char[] cs1 = new char[4];
        s06.getChars(2, 6, cs1, 0);
        for(int i = 0; i<cs1.length; i++){
            System.out.print(cs1[i] + ((i < cs1.length - 1) ? "-" : ""));
        }
        System.out.println("\n");
        ////////////////////////
        String s07 = new String("01234567");
        String s08 = new String("01234567");
        System.out.println("(s07==s08) = " + (s07==s08));
        System.out.println("(s07==\"01234567\") = " + (s07=="01234567"));
        System.out.println("s07.equals(s08) = " + s07.equals(s08));
        String s09 = s08;
        System.out.println("(s08==s09) = " + (s08==s09));

        System.out.println();
        ////////////////////////////////////////
        String s10 = new String("Человека невозможно чему-нибудь научить, его можно убедить");
        System.out.println(s10.indexOf('j'));
        System.out.println(s10.indexOf('о'));
        System.out.println(s10.lastIndexOf('о'));
        System.out.println(s10.indexOf('о', 5));
        System.out.println(s10.lastIndexOf('о', 5));
        System.out.println(s10.lastIndexOf('о', 14));

        System.out.println();
        //////////////////////////////////////////////////

        String s11 = new String("Лучший вид на этот город, если сесть в бомбардировщик");
        System.out.println(s11.substring(26));
        System.out.println(s11.substring(26,30));

        System.out.println();
        /////////////////////////////////

        String s12 = new String("Оффтопик - любое сетевое сообщение " +
                "выходящее за рамки ранеее установленной темы");
        System.out.println(s12.replace('ф', 'f'));
        System.out.println(s12.toUpperCase());
        System.out.println(s12.toLowerCase());

        System.out.println();
        /////////////////////////////////////

        StringBuffer s15 = new StringBuffer(100);
        s15.append("В городе Сочи темные ночи");
        System.out.println("s15.length() = " + s15.length());
        System.out.println("s15.capacity() = " + s15.capacity());
        s15.insert(21, "и теплые ");
        System.out.println(s15);
        System.out.println("s15.length() = " + s15.length());
        System.out.println("s15.capacity() = " + s15.capacity());
        s15.delete(21,30);
        System.out.println(s15);
        s15.ensureCapacity(200);
        System.out.println("s15.capacity() = " + s15.capacity());
        String s16 = s15.toString();

        System.out.println();
        //////////////////////////////////////////

        Byte x1 = 3;
        Short x2 = 256;
        Integer x3 = 1000;
        Float x4 = 3.14f;
        Double x5 = 2.9e10;
        Long x6 = 200000000L;
        Character x7 = 'f';
        Boolean x8 = true;
        System.out.println(x1+"\t "+ x1.getClass()
                +"\n "+x2 +"\t "+ x2.getClass()
                +"\n "+x3+"\t "+ x3.getClass()
                +"\n "+x4+"\t "+ x4.getClass()
                +"\n "+x5+"\t "+ x5.getClass()
                +"\n "+x6 +"\t "+ x6.getClass()
                +"\n "+x7+"\t "+ x7.getClass()
                +"\n "+x8+"\t "+ x8.getClass());
        System.out.println();

        Planet planet = Planet.EARTH;

        switch (planet){
            case MARS:
                System.out.println("MARS");
                break;
            case JUPITER:
                System.out.println("JUPITER");
                break;
            default:
                System.out.println("default");
        }
        System.out.println();

        Planet1 planet1 = Planet1.NEPTUNE;
        System.out.println(planet1.gravity);
        System.out.println(planet1.mass);
        System.out.println(planet1.radius);
        
        Car car = Car.AUDI;
        System.out.println(car.amount+" "+car.seats+" "+ car.maxSpeed);
        Car car1 = Car.OPEL;
        System.out.println(car1.amount+" "+car1.seats+" "+ car1.maxSpeed);
    }
    public enum Planet{
        MERCURY,
        VENUS,
        EARTH,
        MARS,
        JUPITER,
        SATURN,
        URANUS,
        NEPTUNE;
    }

    public enum Car{
        OPEL(4000, 220),
        AUDI(5000, 280);
        private final double maxSpeed;
        private final double amount;
        private final double seats;
        Car(double amount, double maxSpeed){
            this.maxSpeed = maxSpeed;
            this.amount = amount;
            this.seats = 4*amount;
        }
    }

    public enum Planet1{
        MERCURY(3.302e+23, 2.439e+06),
        NEPTUNE(1.024e+26, 2.477e+07);
        private final double mass;
        private final double radius;
        private final double gravity;
        private static final double G = 6.673000e-11;
        Planet1(double mass, double radius){
            this.mass = mass;
            this.radius = radius;
            this.gravity = G*mass/(radius*radius);
        }
    }
}
