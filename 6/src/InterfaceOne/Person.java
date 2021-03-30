package InterfaceOne;

public interface Person {
    int Limityyyy = 1900; //min year of birth
    void setSurname(String surname);
    void setName(String name);
    void setFatherName(String fatherName);
    void setBirthday(int yyy, int mm, int dd);
    String getSurname();
    String getName();
    String getFatherName();
    java.util.Date getBirthday();
}
