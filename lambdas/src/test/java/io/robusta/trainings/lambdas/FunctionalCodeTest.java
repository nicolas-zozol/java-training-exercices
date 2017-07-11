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

}