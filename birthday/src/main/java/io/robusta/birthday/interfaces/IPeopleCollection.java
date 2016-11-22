package io.robusta.birthday.interfaces;



import java.util.List;

/**
 * Created by Nicolas Zozol on 04/10/2016.
 */
public interface IPeopleCollection<T extends IPeople> extends List<T> {

    public boolean hasSame();


}
