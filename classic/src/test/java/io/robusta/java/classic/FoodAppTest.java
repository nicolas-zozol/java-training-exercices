package io.robusta.java.classic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nicorama on 22/06/2017.
 */
public class FoodAppTest {

    FoodApp app;

    @Before
    public void setUp() throws Exception {
        app = new FoodApp();
    }


    @Test
    public void deliver() throws Exception {

        int initialMoney = app.money;
        int initialStock = app.foodStock;
        assertTrue(initialMoney == 0);
        int value = app.deliver(10);

        // We deliver 10 units of food, and get 20 bucks
        assertTrue(10*2 == value);

        assertTrue(app.foodStock == initialStock - 10);

        // But the cost of the travel is 2;
        assertTrue(app.money == initialMoney + value - FoodApp.TRAVEL_COST);

    }

    @Test
    public void deliverAll() throws Exception {

        int initialMoney = app.money;
        int initialStock = app.foodStock;
        assertTrue(initialMoney == 0);
        int value = app.deliverAll(5, 10);

        // We deliver 5 trips of 10 units of food, and get 20 bucks
        assertTrue(5* 10*2 == value);

        // But the cost of the travel is 2;
        assertTrue(app.money == initialMoney + value - FoodApp.TRAVEL_COST*5 );

    }

    @Test
    public void reset() throws Exception {

        int initialMoney = app.money;
        int initialStock = app.foodStock;
        app.deliverAll(5, 10);

        app.reset();

        assertTrue(app.money == initialMoney);
        assertTrue(app.foodStock == initialStock);

    }


}