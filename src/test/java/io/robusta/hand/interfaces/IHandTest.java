package io.robusta.hand.interfaces;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import io.robusta.hand.HandClassifier;
import io.robusta.hand.PokerTest;
import io.robusta.hand.solution.Deck;
import io.robusta.hand.solution.Hand;

public class IHandTest extends PokerTest {

	
	IDeck deck;

	@Before
	public void setUp() throws Exception {
	
		this.deck = new Deck();
	}

	@After
	public void tearDown() throws Exception {
	}

	public IHand newHand(String cards) {
		Hand h = new Hand();
		h.addAll(generateCards(cards));
		return h;
	}

	public IHand randomHand(String cards) {
		return deck.giveHand();
	}

	@Test
	public void testChangeCards() {

	}

	


	@Test
	public void testNumber() {
		IHand hand = newHand("4c 4s 2s 3s 6h");
		assertTrue(hand.number(4) ==2);
		
		hand = newHand("4c 3s 3h 3c 6h");
		assertTrue(hand.number(3) ==3);
		
		hand = newHand("4c 4s 2s 3s 6h");
		assertTrue(hand.number(1) ==0);
		
		hand = newHand("4c 4s 2s As Ah");
		assertTrue(hand.number(1) ==2);
	}

	@Test
	public void testGroup() {
		IHand hand = newHand("4c 4s 2s As Ah");
		assertTrue(hand.group().get(4).size()==2);
		assertTrue(hand.group().get(1).size()==2);
		assertTrue(hand.group().get(12)==null);
		assertTrue(hand.group().get(2).size()==1);
	}

	@Test
	public void testIsStraight() {
		IHand hand = newHand("4c 5c 2s 3s 6h");
		assertTrue(hand.toString(), hand.isStraight());

		hand = newHand("Tc Jc As Qs Kh");
		assertTrue(hand.toString(), hand.isStraight());
	}
	
	@Test
	@Ignore
	public void testIsStraightWithAce() {
		
		IHand hand = newHand("4c 5c 2s 3s Ah");
		assertTrue(hand.toString(), hand.isStraight());
	}

	@Test
	public void testIsFlush() {
		IHand hand = newHand("4c 5c 2c 3c Qc");
		assertTrue(hand.toString(), hand.isFlush());
	}
	
	

	@Test
	public void testTwoPair() {
		IHand hand = newHand("4c 4h 2c 2s Qc");
		assertTrue(hand.getClassifier() == HandClassifier.TWO_PAIR);
		
		hand = newHand("4c 5c 2c 3c Qc");
		assertTrue(hand.toString(), hand.isFlush());
	}
	
	@Test
	public void testPair() {
		IHand hand = newHand("4c Kh 2c 2s Qc");
		assertTrue(hand.getClassifier() == HandClassifier.PAIR);
	}
	
	@Test
	public void testStraightFlush() {
		IHand hand = newHand("2c 3c 4c 5s 6c");
		assertTrue(hand.getClassifier() == HandClassifier.STRAIGHT_FLUSH);
	}
	
	@Test
	public void testBeats() {
		IHand hand1 = newHand("4c Kh 2c 2s Qc");
		IHand hand2 = newHand("2c 3c 4c 5s 6c");
		assertTrue(hand2.beats(hand1));
	}

}
