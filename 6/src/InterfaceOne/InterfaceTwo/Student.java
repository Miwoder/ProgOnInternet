package InterfaceOne.InterfaceTwo;

import InterfaceOne.Person;

import java.util.Date;

public interface Student extends Person {
    void setFirstDate(Date d);  // установить дату
    // поступления в вуз
    Date getFirstDate();        //  получить дату
    // поступления в вуз
    void setUniversity(String u); // установить имя вуза
    String getUniversity();     // получить имя вуза
    int LimitUniversityLength = 10;  // максимальное количество    символов в наименовании            вуза


}
