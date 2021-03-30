package InterfaceOne.InterfaceTwo.Class;

import InterfaceOne.InterfaceTwo.Student;

import java.util.Date;

public class AAA implements Student {
    private String Name;
    private String Surname;
    private String FatherName;
    private Date Birthday;
    private Date FirstDate;
    private String University;

    public AAA() {
    }

    @Override
    public String getSurname() {
        return Surname;
    }

    @Override
    public Date getBirthday() {
        return Birthday;
    }

    @Override
    public Date getFirstDate() {
        return FirstDate;
    }

    @Override
    public String getFatherName() {
        return FatherName;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public String getUniversity() {
        return University;
    }

    public void setBirthday(int yyyy, int mm, int dd) {
        this.Birthday = (yyyy>Limityyyy?new Date(yyyy-1900,mm,dd):null);
    }

    @Override
    public void setSurname(String surname) {
        this.Surname = surname;
    }

    @Override
    public void setName(String name) {
        this.Name = name;
    }

    @Override
    public void setUniversity(String university) {
        this.University = university;
    }

    @Override
    public void setFirstDate(Date firstDate) {
        firstDate.setYear(firstDate.getYear()-1900);
        this.FirstDate = firstDate;
    }

    @Override
    public void setFatherName(String fatherName) {
        this.FatherName = fatherName;
    }

}
