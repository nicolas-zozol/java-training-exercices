package io.robusta.java.classic;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nicorama on 21/06/2017.
 */
public class ListAppTest {

    ListApp app = new ListApp();

    @Test
    public void buildList() throws Exception {
        List<Integer> result = app.buildList(2,4,6);
        assertTrue(2 == result.get(0));
        assertTrue(4 == result.get(1));

        result = app.buildList(0,-1,6);
        assertTrue(0 == result.get(0));
        assertTrue(-1 == result.get(1));
    }


    @Test
    public void buildArrayList() throws Exception {
        List<Integer> result = app.buildList(2,4,6, 7,9);
        assertTrue(2 == result.get(0));
        assertTrue(4 == result.get(1));
        assertTrue(9 == result.get(4));

    }

    @Test
    public void equality() throws Exception {

        List<Integer> list1 = app.buildList(2,4,6);
        List<Integer> list2 = app.buildList(2,4,6);
        List<Integer> list3 = app.buildList(0,-1,6);

        assertTrue(app.equality(list1, list2));
        assertFalse(app.equality(list1, list3));



    }

    @Test
    public void first() throws Exception {
        List<Integer> list1 = app.buildList(2,4,6);
        assertTrue(2==app.first(list1));
    }

    @Test
    public void last() throws Exception {
        List<Integer> list1 = app.buildList(2,4,6, 10);
        assertTrue(10==app.last(list1));
    }

    @Test
    public void medium() throws Exception {
        List<Integer> list1 = app.buildList(2,4,6);
        List<Integer> list2 = app.buildList(2,4,6, 10);

        assertTrue(4==app.medium(list1));
        assertTrue(4==app.medium(list2));
    }





}