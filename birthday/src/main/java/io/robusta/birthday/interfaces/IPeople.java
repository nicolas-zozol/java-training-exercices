package io.robusta.birthday.interfaces;

/**
 * Created by Nicolas Zozol on 04/10/2016.
 */
public interface IPeople {


    void setBirthday(int date);
    int getBirthday();

    boolean equals(IPeople people);

}
