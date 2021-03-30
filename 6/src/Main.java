import InterfaceOne.InterfaceTwo.Class.AAA;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        AAA aaa = new AAA();
        aaa.setBirthday(2001, 02, 11);
        aaa.setFatherName("Andreevich");
        aaa.setName("Vadim");
        aaa.setSurname("Govoronok");
        aaa.setUniversity("BSTU");
        aaa.setFirstDate(new Date(2018,01,01));
        System.out.println("Birthday: " + aaa.getBirthday() + "\n" +
                "Name: "   + aaa.getName() + "\n" +
                "Surname: "  + aaa.getSurname() + "\n" +
                "Father Name: "   + aaa.getFatherName() + "\n" +
                "First date: "  + aaa.getFirstDate() + "\n" +
                "University: "  + aaa.getUniversity());
    }
}
