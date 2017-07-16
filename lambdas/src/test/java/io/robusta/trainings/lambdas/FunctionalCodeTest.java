package io.robusta.trainings.lambdas;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Nicolas Zozol on 11/07/2017.
 */
public class FunctionalCodeTest {
    FunctionalCode code;
    @Before
    public void setUp() throws Exception {
        code = new FunctionalCodeSolution();
    }


    @Test
    public void testDoubling(){
        List<Integer> inputs = Arrays.asList(1,2,3);
        List<Integer> expected = Arrays.asList(2,4,6);
        List<Integer> actual= code.doubling(inputs);

        // Use replace All
        assertEquals(expected, actual);

    }

    @Test
    public void sort(){
        List<Integer> inputs = Arrays.asList(1,5,3);
        List<Integer> expected = Arrays.asList(1,3,5);
        List<Integer> actual= code.sort(inputs);

        // Use Collections.sort()
        assertEquals(expected, actual);

        // But without changing original
        assertEquals("original should not change",5, inputs.get(1).intValue() );

    }

    @Test
    public void reverseSort(){
        List<Integer> inputs = Arrays.asList(1,5,3);
        List<Integer> expected = Arrays.asList(5,3,1);
        List<Integer> actual= code.sort(inputs);


        assertEquals(expected, actual);

        // But without changing original
        assertEquals("original should not change",5, inputs.get(1).intValue() );

    }



}