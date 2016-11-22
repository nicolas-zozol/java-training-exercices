package io.robusta.jpa.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import io.robusta.jpa.EmFactory;
import io.robusta.jpa.entities.HasId;
import io.robusta.jpa.IntegrationTest;
import io.robusta.jpa.entities.FunkoPop;
import io.robusta.jpa.entities.Universe;

@Category(IntegrationTest.class)
public class FunkoPopDaoTest {
	
	Universe lotr;
	Universe starWars;
	Universe starTrek;
	FunkoPop gandalf;
	FunkoPop aragorn;
	FunkoPop yoda;
	FunkoPop spock;
	
	@Before
	public void start(){
		lotr = new Universe("LOTR");
		starWars = new Universe("Star Wars");
		starTrek = new Universe("Star Trek");
		gandalf = new FunkoPop("Gandalf", lotr);
		aragorn = new FunkoPop("Aragorn", lotr);
		yoda = new FunkoPop("Yoda", starWars);
		spock = new FunkoPop("Spock", starTrek);
		
		EmFactory.voidTransaction(em->{
			em.persist(lotr);
			em.persist(starWars);
			em.persist(starTrek);
		});
	}
	

	
	void createGandalf(){
		final FunkoPop g = gandalf;
		EmFactory.voidTransaction(em->{
			new FunkoPopDao().createOrUpdate(g);
		});
	}

	
	


	@Test
	public void testFindFunkoPopByIdInt() {
		createGandalf();
		assertNotNull(new FunkoPopDao().findFunkoPopById(gandalf.getId()));
		System.out.println("found completed");
	}

}
