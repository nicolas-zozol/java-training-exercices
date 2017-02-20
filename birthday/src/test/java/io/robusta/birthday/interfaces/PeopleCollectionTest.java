package io.robusta.birthday.interfaces;

import io.robusta.birthday.implementations.People;
import io.robusta.birthday.implementations.PeopleCollection;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nicolas Zozol on 05/10/2016.
 */
public class PeopleCollectionTest {
    @Test
    public void hasSame() throws Exception {


        People jo = new People();
        jo.setBirthday(200);

        People jane = new People();
        jane.setBirthday(200);

        People jack = new People();
        jack.setBirthday(300);
        assertFalse(jo.equals(jack));

        PeopleCollection collection = new PeopleCollection();
        collection.add(jo);
        collection.add(jane);
        collection.add(jack);
        assertTrue(collection.hasSame());


        collection = new PeopleCollection();
        collection.add(jo);
        collection.add(jack);
        assertFalse(collection.hasSame());

    }

    @Test
    public void createRandomCollection(){
        // empty collection, should not have same
        PeopleCollection collection = new PeopleCollection(0);
        assertFalse(collection.hasSame());

        // only one collection, should not have same
        collection = new PeopleCollection(1);
        assertFalse(collection.hasSame());


        // Should have same !
        collection = new PeopleCollection(366);
        assertTrue(collection.hasSame());
    }



}