package io.robusta.java.classic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nicorama on 21/06/2017.
 */
public class ArrayAppTest {
    ArrayApp app = new ArrayApp();

    @Test
    public void buildArray() throws Exception {
        int[] result = app.buildArray(2,4,6);
        assertEquals(2, result[0]);
        assertEquals(4, result[1]);

        result = app.buildArray(0,-1,6);
        assertEquals(0, result[0]);
        assertEquals(-1, result[1]);

    }

    @Test
    public void equality() throws Exception {
        int[] a1 = {2,4,6};
        int[] a2 = {2,4,6};
        int[] a3 = {0,0,0};
        int[] a4 = {0,0};

        assertFalse(a1 == a2);
        assertTrue(app.equality(a1,a2));
        assertFalse(app.equality(a1,a3));

        // code should not break
        assertFalse(app.equality(a1,a4));

    }

    @Test
    public void asStringNumbers() throws Exception {
        int[] a1 = {2,4,6};
        assertEquals("2:4:6:",app.asString(a1));
    }

    @Test
    public void asStringJoin() throws Exception {
        int[] a1 = {2,4,6, 8, 10};
        assertEquals("2:4:6:8:10",app.asStringJoin(a1));
    }

    @Test
    public void asStringStrings() throws Exception {
        String[] strings = {"Yo", "Are","You", "Doing"};
        assertEquals("Yo Are You Doing",app.asString(strings));
    }

    @Test
    public void asStringCards() throws Exception {
        Card c1 = new Card(9,'s');
        Card c2 = new Card(2,'d');
        Card c3 = new Card(5,'c');
        Card c4 = new Card(4,'h');
        Card[] cards = {c1,c2,c3,c4};

        assertEquals("[9s 2d 5c 4h]", app.asString(cards));

    }

}