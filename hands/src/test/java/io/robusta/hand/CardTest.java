package io.robusta.hand;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.robusta.hand.interfaces.IDeckGenerator;
import io.robusta.hand.solution.Deck;

public class CardTest extends PokerTest{

	
	
	@Before
	public void setUp() throws Exception {
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeckValue(){
		//deck value = (5-1)*4 + 4 = 20
		Card c = new Card(5, CardColor.CLUB);
		assertTrue(c.deckValue == 20);

		//Aces: deck value = colorValue =  3
		Card ace = new Card(1, CardColor.DIAMOND);
		assertEquals(ace.deckValue, 3);
	}

	@Test
	public void testToString() {
		Card c = new Card(5, CardColor.CLUB);
		assertTrue(c.toString().equals("5c"));
		
		c = new Card(6, CardColor.SPADE);
		assertTrue(c.toString().equals("6s"));
		
		c = new Card(10, CardColor.HEART);
		assertTrue(c.toString().equals("Th"));
		
		c = new Card(1, CardColor.DIAMOND);
		assertTrue(c.toString().equals("Ad"));
	}

	@Test
	public void testGetCharValue() {
		Card c = new Card(5, CardColor.CLUB);
		assertTrue( c.getCharValue()=='5');
		assertTrue(c.getColor().getAbbr()=='c');
		
		c = new Card(6, CardColor.SPADE);
		assertTrue(c.getCharValue()=='6');
		assertTrue(c.getColor().getAbbr()=='s');
		
		c = new Card(10, CardColor.HEART);
		assertTrue(c.getCharValue()=='T');
		assertTrue(c.getColor().getAbbr()=='h');
		
		c = new Card(1, CardColor.DIAMOND);
		assertTrue(c.getCharValue()=='A');
		assertTrue(c.getColor().getAbbr()=='d');
	}

	@Test
	public void testEqualsObject() {
		Card c = new Card(5, CardColor.CLUB);
		Card compare = generateCard("5c");
		assertEquals(c, compare);
		
		c = new Card(6, CardColor.SPADE);
		compare = generateCard("6s");
		assertEquals(c, compare);
		
		c = new Card(11, CardColor.HEART);
		compare = generateCard("Jh");
		assertEquals(c, compare);
		
		c = new Card(1, CardColor.DIAMOND);
		compare = generateCard("Ad");
		assertEquals(c, compare);
	}

	@Test
	public void testCompare(){
		Card c = new Card(5, CardColor.CLUB);
		Card compare = generateCard("4c");
		assertTrue(c.compareTo(compare) >0);
		
		c = new Card(6, CardColor.SPADE);
		compare = generateCard("6s");
		assertTrue(c.compareTo(compare) ==0);
		
		c = new Card(11, CardColor.HEART);
		compare = generateCard("Kc");
		assertTrue(c.compareTo(compare) != 0);

		// As is more than 9
		c = new Card(1, CardColor.DIAMOND);
		compare = generateCard("9d");
		assertTrue(c.compareTo(compare) >0);
		
		c = new Card(1, CardColor.DIAMOND);
		compare = generateCard("Ac");
		assertTrue(c.compareTo(compare) !=0);
		
	}
	
	
}
