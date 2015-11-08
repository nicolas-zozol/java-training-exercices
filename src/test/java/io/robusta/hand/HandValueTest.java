package io.robusta.hand;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HandValueTest extends PokerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCompareTo() {
		
	}

	@Test
	public void testCompareSets() {
		TreeSet<Card> remainings1 = new TreeSet<>();
		remainings1.addAll( generateCards("As 8c Qh") );
		
		TreeSet<Card> remainings2 = new TreeSet<>();
		remainings2.addAll( generateCards("Ts 8c Kh") );
		
		HandValue hv1 = new HandValue(HandClassifier.PAIR, 7, remainings1);
		HandValue hv2 = new HandValue(HandClassifier.PAIR, 7, remainings2);
		
		assertTrue(hv1.compareTo(hv2) >0);
		
		remainings1 = new TreeSet<>();
		remainings1.addAll( generateCards("Ts 2c Qh") );
		remainings2 = new TreeSet<>();
		remainings2.addAll( generateCards("Ks 8c Kh") );
		hv1 = new HandValue(HandClassifier.PAIR, 7, remainings1);
		hv2 = new HandValue(HandClassifier.PAIR, 7, remainings2);
		
		assertTrue(hv1.compareTo(hv2) < 0);
		
		remainings1 = new TreeSet<>();
		remainings1.addAll( generateCards("Ts 2c Qh") );
		remainings2 = new TreeSet<>();
		remainings2.addAll( generateCards("Th 2s Qc") );
		hv1 = new HandValue(HandClassifier.PAIR, 7, remainings1);
		hv2 = new HandValue(HandClassifier.PAIR, 7, remainings2);
		
		assertTrue(hv1.compareTo(hv2) == 0);
	}

}
