package io.robusta.birthday.interfaces;

import io.robusta.birthday.implementations.People;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nicolas Zozol on 05/10/2016.
 */
public class IPeopleTest {

    @Test
    public void getBirthday() throws Exception {
        IPeople people = new People();
        people.setBirthday(200);
        assertTrue(people.getBirthday() == 200);
    }

    @Test
    public void equals() throws Exception {

        IPeople jo = new People();
        jo.setBirthday(200);

        IPeople jane = new People();
        jo.setBirthday(200);
        assertTrue(jane.equals(jo));
        
        IPeople jack = new People();
        jo.setBirthday(300);
        assertFalse(jo.equals(jack));


    }

}