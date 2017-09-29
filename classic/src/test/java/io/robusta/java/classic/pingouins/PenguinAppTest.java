package io.robusta.java.classic.pingouins;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nicorama on 28/09/2017.
 */
public class PenguinAppTest {

    Penguin kowalsky = new Penguin("Kowalsky");
    Penguin ricoh = new Penguin("Ricoh");
    Penguin soldat = new Penguin("Soldat");
    Penguin commandant = new Penguin("Commandant");
    Penguin tux = new Penguin("Tux");

    Penguin[] smallArray = {kowalsky, commandant};
    Penguin[] bigArray = {kowalsky, ricoh, soldat, commandant, tux};
    List<Penguin> smallList = Arrays.asList(ricoh, soldat);
    List<Penguin> bigList = Arrays.asList(kowalsky, ricoh, soldat, commandant, tux);

    PenguinApp app = new PenguinApp();

    @Before
    public void setUp(){
        kowalsky.setFriend(ricoh);
        soldat.setFriend(ricoh);
        ricoh.setFriend(tux);

        tux.setSpeed(50);
        kowalsky.setSpeed(88);
        commandant.setSpeed(5);
    }


    @Test
    public void createSimplePingouin(){
        Penguin penguin = app.createSimplePenguin();
        assertNotNull(penguin);
        assertNotNull(penguin.getName());
    }

    @Test
    public void getPingouins(){
        List<Penguin> penguins = app.getPenguins(ricoh, kowalsky, commandant, tux, soldat);
        assertEquals(5, penguins.size());
        assertSame(kowalsky, penguins.get(1));

        penguins = app.getPenguins(ricoh, kowalsky, null, null, null);
        assertEquals(2, penguins.size());
        assertSame(kowalsky, penguins.get(1));


    }

    @Test
    public void getPenguinByName(){
        Penguin p = app.getPenguinByName(bigArray, "Ricoh");
        assertEquals("Ricoh", p.getName());

        p = app.getPenguinByName(bigArray, "No Way");
        assertNull(p);
    }

    @Test
    public void getFastest(){
        Penguin fastest = app.getFastest(bigList);
        assertSame(fastest, kowalsky);
    }

    @Test
    public void getFriend(Penguin penguin){
        Penguin friend = app.getFriend(ricoh);
        assertSame(tux, friend);

        friend = app.getFriend(tux);
        assertNull(friend);
    }

    @Test
    public void getPenguinsWithLetterArray(){
        List<Penguin> penguins = app.getPenguinsWithLetter(bigArray, "o");
        assertEquals(penguins.size(), 4);
        assertTrue(penguins.contains(ricoh));
        assertFalse(penguins.contains(tux));

        penguins = app.getPenguinsWithLetter(bigArray, "Ko");
        assertTrue(penguins.contains(kowalsky));
        assertEquals(penguins.size(), 1);


    }

    @Test
    public void getPenguinsWithLetterList(){
        Penguin[] penguins = app.getPenguinsWithLetter(bigList, "o");
        assertEquals(penguins.length, 4);
        assertTrue( Arrays.asList(penguins).contains(ricoh));
        assertFalse(Arrays.asList(penguins).contains(tux));

        penguins = app.getPenguinsWithLetter(bigList, "Ko");
        assertTrue(Arrays.asList(penguins).contains(kowalsky));
        assertEquals(penguins.length, 1);


    }


    @Test
    public void getSmallestSize(){
        Object smallest = app.getSmallestSize(smallArray, bigList);
        assertSame(smallest, smallArray);

        smallest = app.getSmallestSize(bigArray, smallList);
        assertSame(smallest, smallList);

        smallest = app.getSmallestSize(bigArray, bigList);
        assertNull(smallest);

    }




    @Test
    public void  getFriends(){
        List<Penguin> friends = app.getFriends(bigArray);
        assertEquals(3, friends.size());
        assertTrue(friends.contains(tux));
        assertFalse(friends.contains(ricoh));

        friends = app.getFriends(smallArray);
        assertEquals(1, friends.size());

        friends = app.getFriends(new Penguin[]{});
        assertEquals(0, friends.size());
    }


}