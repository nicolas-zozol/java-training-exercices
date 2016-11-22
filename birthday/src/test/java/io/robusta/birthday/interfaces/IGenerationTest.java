package io.robusta.birthday.interfaces;

import io.robusta.birthday.implementations.Generation;
import io.robusta.birthday.implementations.PeopleCollection;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Nicolas Zozol on 05/10/2016.
 */
public class IGenerationTest {

    IGeneration generation;

    @Before
    public void setUp() throws Exception {
        generation = new Generation();

    }

    @Test
    public void createRandom() throws Exception {

        IPeopleCollection collection = generation.createRandom(10);
        assertTrue(collection.size() == 10);

    }

    @Test
    public void createAllRandom() throws Exception {
        List<IPeopleCollection> collections = generation.createAllRandom(10, 40);
        assertTrue(collections.size() == 10);
        assertTrue(collections.get(3).size() == 40);
    }

    @Test
    public void getPeopleCollection() throws Exception {
        IGeneration generation = new Generation(5, 100);
        assertTrue(generation.getPeopleCollection().size() == 5);
        assertTrue(generation.getPeopleCollection().get(3).size() == 100);
    }

    @Test
    public void getNumberOfCollectionsThatHasTwoPeopleWithSameBirthday() throws Exception {

        // one people : none should have same
        IGeneration generation = new Generation(100, 1);
        assertTrue(generation.getNumberOfCollectionsThatHasTwoPeopleWithSameBirthday() == 0);

        // 366 people : all should have same
        generation = new Generation(100, 366);
        assertTrue(generation.getNumberOfCollectionsThatHasTwoPeopleWithSameBirthday() == 100);

        // 30 people : some should have same
        generation = new Generation(100, 30);
        assertTrue(generation.getNumberOfCollectionsThatHasTwoPeopleWithSameBirthday() > 1);

        assertTrue(generation.getNumberOfCollectionsThatHasTwoPeopleWithSameBirthday() < 100);
    }

    @Test
    public void isLessThan50() throws Exception {
        generation = new Generation(100, 3);
        assertTrue(generation.isLessThan50());

        generation = new Generation(100, 220);
        assertFalse(generation.isLessThan50());
    }



}