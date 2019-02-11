package io.robusta.java.classic;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathApplicationTest {

    MathApplication app = new MathApplication();

    @Test
    public void addition() {
        assertEquals(2, app.addition(1, 1));
        assertEquals(-2, app.addition(2, -4));
        assertEquals(100, app.addition(25, 75));
    }

    @Test
    public void multiplication() {
        assertEquals(0, app.multiplication(0, 10));
        assertEquals(25, app.multiplication(5, 5));
        assertEquals(-9, app.multiplication(3, -3));
    }

    @Test
    public void addition1() {
        assertArrayEquals(
                new int[]{3, 3},
                app.addition1(1, 1, 2, 2)
        );
        assertArrayEquals(
                new int[]{1, 1},
                app.addition1(1, 1, 0, 0)
        );
        assertArrayEquals(
                new int[]{1, -4},
                app.addition1(0, 1, 1, -5)
        );


    }

    @Test
    public void addition2() {

        int[] vector;
        int[] vector2;

        vector = new int[]{3, 3};
        vector2 = new int[]{3, 3};
        assertArrayEquals(
                new int[]{6, 6},
                app.addition2(vector, vector2)
        );


        vector = new int[]{0, 1};
        vector2 = new int[]{-2, -6};
        assertArrayEquals(
                new int[]{-2, -5},
                app.addition2(vector, vector2)
        );

        vector = new int[]{5, 5};
        vector2 = new int[]{5, 5};
        assertArrayEquals(
                new int[]{10, 10},
                app.addition2(vector, vector2)
        );

    }

    @Test
    public void addition3() {
        Vector vector, vector2;

        vector = new Vector(5, 10);
        vector2 = new Vector(5, 10);
        assertEquals(
                new Vector(10, 20),
                app.addition3(vector, vector2)
        );

        vector = new Vector(0, 0);
        vector2 = new Vector(5, 10);
        assertEquals(
                new Vector(5, 10),
                app.addition3(vector, vector2)
        );


    }



    @Test
    public void factorial() {
        assertEquals(1, app.factorial(0));
        assertEquals(1, app.factorial(1));
        assertEquals(24, app.factorial(4));
        assertEquals(120, app.factorial(5));
    }

    @Test
    public void sumAll() {
        assertEquals(0, app.sumAll(0));
        assertEquals(1, app.sumAll(1));
        assertEquals(10, app.sumAll(4));
        assertEquals(15, app.sumAll(5));
        assertEquals(125250, app.sumAll(500));
    }


}
