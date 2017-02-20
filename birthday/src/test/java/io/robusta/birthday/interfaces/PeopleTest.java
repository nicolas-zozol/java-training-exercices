package io.robusta.birthday.interfaces;

import io.robusta.birthday.implementations.People;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nicolas Zozol on 05/10/2016.
 */
public class PeopleTest {

    @Test
    public void getBirthday() throws Exception {
        People people = new People();
        people.setBirthday(200);
        assertTrue(people.getBirthday() == 200);
    }

    @Test
    public void equals() throws Exception {

        People jo = new People();
        jo.setBirthday(200);

        People jane = new People();
        jane.setBirthday(200);
        assertTrue(jane.equals(jo));
        
        People jack = new People();
        jack.setBirthday(300);
        assertFalse(jo.equals(jack));


    }

}