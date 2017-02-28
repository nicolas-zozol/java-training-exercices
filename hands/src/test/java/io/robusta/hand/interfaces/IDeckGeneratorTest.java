package io.robusta.hand.interfaces;

import static org.junit.Assert.assertTrue;

import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.robusta.hand.Card;
import io.robusta.hand.CardColor;
import io.robusta.hand.PokerTest;
import io.robusta.hand.solution.DeckGenerator;

public class IDeckGeneratorTest extends PokerTest{


	
	@Before
	public void setUp() throws Exception {
		generator = new DeckGenerator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGenerate() {
		IDeck deck = generator.generate();
		assertTrue(generator.generate().size() == IDeck.INITIAL_SIZE);
		
		Card card = generateCard("5s");
		assertTrue(deck.contains(card));
		
	}

	@Test
	public void testGenerateCard() {
		Card card = generateCard("5s");
		assertTrue(card.equals(new Card(5, CardColor.SPADE)));
	}
	
	@Test
	public void testGenerateCards() {
		Card card = generateCard("5s");
		TreeSet<Card> cards = generateCards("3d Th 5s");
		assertTrue(cards.size() == 3);
		assertTrue(cards.contains(card));
	}

}
