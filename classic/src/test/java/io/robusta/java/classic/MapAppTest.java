package io.robusta.java.classic;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by nicorama on 21/06/2017.
 */
public class MapAppTest {

    MapApp app = new MapApp();

    @Test
    public void buildMap() throws Exception {

        Map<Integer, String> map= app.buildMap(1,"Jo", 18, "Jack");
        assertEquals(map.get(1), "Jo");
        assertEquals(map.get(18), "Jack");
        assertNull(map.get(2));

    }

    @Test
    public void buildMapArrays() throws Exception {
        int[] keys={1,18, 5};
        String[] values = {"John", "Jim", "Jane"};

        Map<Integer, String> map= app.buildMap(keys, values);

        assertEquals(map.get(1), "John");
        assertEquals(map.get(18), "Jim");
        assertEquals(map.get(5), "Jane");
        assertNull(map.get(2));

    }

    @Test
    public void getKeys() throws Exception {
        int[] keys={1,18, 5};
        String[] values = {"John", "Jim", "Jane"};

        Map<Integer, String> map= app.buildMap(keys, values);

        Set<Integer> keySet = app.getKeys(map);
        assertTrue(keySet.contains(1));
        assertTrue(keySet.contains(18));
        assertTrue(keySet.contains(5));
        assertFalse(keySet.contains(2));


    }

    @Test
    public void getKeysAsList() throws Exception {
        int[] keys={1,18, 5};
        String[] values = {"John", "Jim", "Jane"};

        Map<Integer, String> map= app.buildMap(keys, values);

        List<Integer> keySet = app.getKeysAsList(map);
        assertTrue(keySet.contains(1));
        assertTrue(keySet.contains(18));
        assertTrue(keySet.contains(5));
        assertFalse(keySet.contains(2));


    }

    @Test
    public void getEntries() throws Exception {
        int[] keys={1,18, 5};
        String[] values = {"John", "Jim", "Jane"};

        Map<Integer, String> map= app.buildMap(keys, values);

        Set<Entry<Integer, String>> entrySet = app.getEntries(map);
        assertTrue(entrySet.size() == 3);

    }

    @Test
    public void getValues() throws Exception {
        int[] keys={1,18, 5};
        String[] values = {"John", "Jim", "Jane"};

        Map<Integer, String> map= app.buildMap(keys, values);
        List<String> allValues = app.getValues(map);

        assertTrue(allValues.contains("Jim"));
        assertTrue(allValues.contains("Jane"));
        assertFalse(allValues.contains("JFK"));

    }

    @Test
    public void getValuesFromMap() throws Exception {

        int[] keys={1,18, 5};
        String[] values = {"Jim","John","Jane"};

        Map<Integer, String> map= app.buildMap(keys, values);

        String[] selectedValues= app.getValuesFromMap(map,1,5);

        assertEquals(2,selectedValues.length);
        assertEquals("Jim",selectedValues[0]);
        assertEquals("Jane",selectedValues[1]);


        // switching keys
        selectedValues= app.getValuesFromMap(map,5,1);

        assertEquals(2,selectedValues.length);
        assertEquals("Jane",selectedValues[0]);
        assertEquals("Jim",selectedValues[1]);

        // unknown key
        selectedValues= app.getValuesFromMap(map,0,1);

        assertEquals(2,selectedValues.length);
        assertEquals(null,selectedValues[0]);
        assertEquals("Jim",selectedValues[1]);

    }


    @Test
    public void displayMap() throws Exception{

        //use map.entrySet() to display the map
        int[] keys={1,18, 5};
        String[] values = {"John", "Jim", "Jane"};
        Map<Integer, String> map= app.buildMap(keys, values);

        String expectedDisplay = "John->1:Jim->18:Jane->5:";
        assertEquals(expectedDisplay, app.displayMap(map));


    }

    @Test
    public void getKeysHavingValue() throws Exception {


        int[] keys={1,18, 5};
        String[] values = {"John", "Jim", "Jane"};

        Map<Integer, String> map= app.buildMap(keys, values);


        // little help for using entries
        for (Map.Entry<Integer, String> entry: map.entrySet()){
            System.out.println( entry.getKey() + ">>>>"+ entry.getValue());
        }

        List<Integer> keysFromValue= app.getKeysHavingValue(map, "John");

        assertEquals(keysFromValue.size(),1);
        assertTrue(keysFromValue.get(0) == 1);


        // Adding doublon for "John"
        map.put(24,"John");
        keysFromValue= app.getKeysHavingValue(map, "John");

        assertEquals(keysFromValue.size(),2);
        assertTrue(keysFromValue.contains(1));
        assertTrue(keysFromValue.contains(24));



    }

    @Test
    public void getKeysHavingValueAnyValue() throws Exception {

        int[] keys={1,18, 5};
        String[] values = {"John", "Jim", "Jane"};

        Map<Integer, String> map= app.buildMap(keys, values);

        List<Integer> keysFromValue= app.getKeysHavingValueAnyValue(map, "John", "Jim");



        assertEquals(keysFromValue.size(),2);
        assertTrue(keysFromValue.contains(1)); // key for John
        assertTrue(keysFromValue.contains(18)); // key for Jim


        // Adding doublon for "John"
        map.put(24,"John");
        keysFromValue= app.getKeysHavingValueAnyValue(map, "John", "Jim");

        assertEquals(keysFromValue.size(),3);
        assertTrue(keysFromValue.contains(1)); // key for John
        assertTrue(keysFromValue.contains(24)); // again a key for John
        assertTrue(keysFromValue.contains(18)); // key for Jim

    }

    @Test
    public void getCards() throws Exception {

        Map<Integer, Character> virtualCards = new HashMap<>();
        virtualCards.put(2, 'h');
        virtualCards.put(4, 'c');
        virtualCards.put(6, 'd');

        List<Card> cards = app.getCards(virtualCards);

        Card sixOfDiamond = new Card(6,'d');
        Card sixOfHeart = new Card(6,'h');

        assertTrue(cards.contains(sixOfDiamond));
        assertFalse(cards.contains(sixOfHeart));

    }

}
