package io.robusta.hand.interfaces;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.robusta.hand.Card;
import io.robusta.hand.PokerTest;
import io.robusta.hand.solution.Deck;
import io.robusta.hand.solution.DeckGenerator;
import io.robusta.hand.solution.Hand;

public class IDeckTest extends PokerTest{

	IDeck deck;
	
	
	@Before
	public void setUp() throws Exception {
	
		
		this.deck = new DeckGenerator().generate();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPick() {
		
		Card card = deck.pick();
		
		assertTrue(deck.size() == IDeck.INITIAL_SIZE - 1);
		assertFalse(deck.contains(card));
		
	}

	@Test
	public void testPickInt() {
		
		Collection<Card> cards = deck.pick(0);
		assertTrue(deck.size() == IDeck.INITIAL_SIZE);
		
		int size = 3;
		cards = deck.pick(size);
		assertTrue(deck.size() == IDeck.INITIAL_SIZE - size);
		
	}

	@Test
	public void testSize() {
		assertTrue(deck.size() == IDeck.INITIAL_SIZE);
	}

	@Test
	public void testContains() {
		assertTrue(deck.contains(fourSpade));
		assertTrue(deck.contains(queenHeart));
		
		Card c = deck.pick();
		assertFalse(deck.contains(c));
	}
	
	@Test
	public void testGiveHand(){
		Hand hand = deck.giveHand();
		assertTrue(hand.size() == 5);
		assertTrue(deck.size() == IDeck.INITIAL_SIZE - 5);
		
		for (Card c : hand){
			assertFalse(deck.contains(c));
		}
	}

}
