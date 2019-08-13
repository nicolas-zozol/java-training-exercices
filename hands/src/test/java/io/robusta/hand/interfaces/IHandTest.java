package io.robusta.hand.interfaces;

import static org.junit.Assert.*;

import io.robusta.hand.Card;
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
	public void testIsFlush() {
		IHand hand = newHand("4c 5c 2c 3c Qc");
		assertTrue(hand.isFlush());

		hand = newHand("4c 5c 2c 3c Qs");
		assertTrue(hand.isFlush());
	}

	@Test
	public void testIsStraight() {
		IHand hand = newHand("4c 5c 2s 3s 6h");
		assertTrue(hand.isStraight());

		hand = newHand("4c 5c 3s 3s 6h");
		assertFalse(hand.isStraight());
	}
	
	// Straight with Aces is a bit complicated so we'll ignore it now
	@Test
	@Ignore
	public void testIsStraightWithAce() {
		
		IHand hand = newHand("4c 5c 2s 3s Ah");
		assertTrue( hand.isStraight());
		
		hand = newHand("Tc Jc As Qs Kh");
		assertTrue( hand.isStraight());

		hand = newHand("Tc Jc As Ks Kh");
		assertFalse( hand.isStraight());


	}


	@Test
	public void testStraightFlush() {
		IHand hand = newHand("2c 3c 4c 5c 6c");
		assertTrue(hand.getClassifier() == HandClassifier.STRAIGHT_FLUSH);
	}
	
	
	@Test
	// The number() function is already written. This test should pass.
	// It's here mainly for documentation
	public void testNumber() {
		IHand hand = newHand("4c 4s 2s 3s 6h");
		assertTrue(hand.number(4) ==2);
		
		hand = newHand("4c 3s 3h 3c 6h");
		assertTrue(hand.number(3) ==3);
		
		hand = newHand("4c 4s 2s 3s 6h");
		assertTrue(hand.number(Card.AS_VALUE) ==0);
		
		hand = newHand("4c 4s 2s As Ah");
		assertTrue(hand.number(Card.AS_VALUE) ==2);
	}

	@Test
	public void testGroup() {
		IHand hand = newHand("4c 4s 2s As Ah");
		assertTrue(hand.group().get(4).size()==2);
		assertTrue(hand.group().get(Card.AS_VALUE).size()==2);
		assertTrue(hand.group().get(12)==null);
		assertTrue(hand.group().get(2).size()==1);
	}

	@Test
	public void testHighCard() {
		IHand hand = newHand("3c 4h Jc 2s Qc");
		assertTrue(hand.isHighCard()); // High card means there is not even a pair

		// Once you know it's a High card, put the qualifier in attributes
		assertEquals(HandClassifier.HIGH_CARD, hand.getClassifier());

		hand = newHand("3c 4c Jc 2c Qc");
		assertFalse(hand.isHighCard()); // all 5 different, but it's a flush
	}

	@Test
	public void testHighCardClassifier() {
		IHand hand = newHand("3c 4h Jc 2s Qc");

		// Same hand that above. Once you know it's a High card, put the qualifier in attributes
		assertEquals(HandClassifier.HIGH_CARD, hand.getClassifier());
	}


	@Test
	public void testTwoPair() {
		IHand hand = newHand("4c 4h 2c 2s Qc");
		assertEquals(HandClassifier.TWO_PAIR, hand.getClassifier());

	}
	
	@Test
	public void testPair() {
		IHand hand = newHand("4c Kh 2c 2s Qc");
		assertTrue(hand.getClassifier() == HandClassifier.PAIR);
	}

	@Test
	public void testTrips() {
		IHand hand = newHand("4c 2h 2c 2s Qc");
		assertTrue(hand.getClassifier() == HandClassifier.TRIPS);

		hand = newHand("4c 2h 2c 2s 2d");
		assertFalse(hand.getClassifier() == HandClassifier.TRIPS);
	}

	@Test
	public void testQuads() {
		IHand hand = newHand("4c 2h 2c 2s Qc");
		assertFalse(hand.getClassifier() == HandClassifier.FOUR_OF_A_KIND);

		hand = newHand("4c 2h 2c 2s 2d");
		assertTrue(hand.getClassifier() == HandClassifier.FOUR_OF_A_KIND);
	}



	@Test
	public void testBeats() {
		IHand hand1 = newHand("4c Kh 2c 2s Qc");
		IHand hand2 = newHand("2c 3c 4c 5s 6c");
		assertTrue(hand2.beats(hand1));
		
		hand1 = newHand("2d 2h 2c 2s Qc");
		hand2 = newHand("2c 3c 4c 5s 6c");
		assertTrue(hand1.beats(hand2));
		
		hand1 = newHand("Td Th Kc 2s Qc");
		hand2 = newHand("Tc Ts 4c 5s 6c");
		assertTrue(hand1.beats(hand2));
	}
	
	@Test
	public void testHasCardValue(){
		IHand hand = newHand("4c Kh 2c 2s Qc");
		assertTrue(hand.hasCardValue(13)); // Because Kh has value 13
		assertTrue(hand.hasCardValue(4));
		assertFalse(hand.hasCardValue(7)); // Because there is no value
	}
	
	@Test
	public void testHasAce(){
		IHand hand = newHand("4c Kh 2c 2s Qc");
		assertFalse(hand.hasAce());
		
		hand = newHand("Ac Kh 2c 2s Qc");
		assertTrue(hand.hasAce());
	}
	
	@Test
	public void testHighestValue(){
		IHand hand = newHand("4c Kh 2c 2s Qc");
		assertEquals(13, hand.highestValue());
		
		hand = newHand("Ac Kh 2c 1s Qc");
		assertEquals(14, hand.highestValue());
	}

}
