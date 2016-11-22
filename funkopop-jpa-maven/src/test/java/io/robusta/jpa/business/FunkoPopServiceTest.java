package io.robusta.jpa.business;



import io.robusta.jpa.entities.FunkoPop;
import io.robusta.jpa.entities.Universe;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Nicolas Zozol on 16/11/2016.
 */

public class FunkoPopServiceTest  {


    Universe lotr;
    Universe starWars;
    Universe starTrek;
    FunkoPop gandalf;
    FunkoPop aragorn;
    FunkoPop yoda;
    FunkoPop spock;
    boolean goodWeather = true;
    boolean badWeather = false;

    @Before
    public void start() {
        lotr = new Universe("LOTR");
        starWars = new Universe("Star Wars");
        starTrek = new Universe("Star Trek");
        gandalf = new FunkoPop("Gandalf", lotr);
        aragorn = new FunkoPop("Aragorn", lotr);
        yoda = new FunkoPop("Yoda", starWars);
        spock = new FunkoPop("Spock", starTrek);

    }

    @Test
    public void testGetFunkoPopsToShelter() {
        yoda.setWaterproof(true);
        spock.setWaterproof(false);
        aragorn.setWaterproof(false);
        gandalf.setWaterproof(true);


        List<FunkoPop> expectedShelteredPops = new ArrayList<>();
        expectedShelteredPops.add(spock);
        expectedShelteredPops.add(aragorn);

        List<FunkoPop> popMockFindAll = new ArrayList<>();
        popMockFindAll.add(spock);
        popMockFindAll.add(aragorn);
        popMockFindAll.add(gandalf);
        popMockFindAll.add(yoda);

        // create mock
        ExternalService externalMock = mock(ExternalService.class);
        FunkoPopService myService = mock(FunkoPopService.class);

        // define return value for method getUniqueId()
        when(externalMock.isWeatherGood()).thenReturn(Optional.of(badWeather));
        when(myService.findAll()).thenReturn(popMockFindAll);
        when(myService.getFunkoPopsToShelter()).thenCallRealMethod();
        // use mock in test....

        myService.externalService = externalMock;
        List<FunkoPop> actual = myService.getFunkoPopsToShelter();

        assertEquals("testing sheltered FunkoPop", expectedShelteredPops, actual);

    }
}
