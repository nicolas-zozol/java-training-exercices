package io.robusta.hand.interfaces;

import java.util.HashMap;
import java.util.List;

import io.robusta.hand.Card;
import io.robusta.hand.HandClassifier;

/**
 * Works on a specific Hand
 * 
 * @author nicorama
 */
public interface IHandResolver {

	public IHand getHand();

	/**
	 * Check how many times the card level is found 5s in "5s 6d 5c 5h As" is
	 * found three times
	 * 
	 * @param c
	 * @return
	 */
	public int number(int cardLevel);

	/**
	 * "5s 6d 5c 5h As" returns { 1: [As], 5:[5s,5c,5h], 6:[6d] } 
	 * 
	 * @return
	 */
	public HashMap<Integer, List<Card>> group();

	public boolean isStraight();

	public boolean isFlush();

	public HandClassifier getClassifier();

}
