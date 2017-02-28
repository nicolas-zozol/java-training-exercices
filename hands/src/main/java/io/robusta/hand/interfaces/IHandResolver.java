package io.robusta.hand.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.robusta.hand.Card;
import io.robusta.hand.HandClassifier;
import io.robusta.hand.HandValue;

/**
 * Works on a specific Hand
 * 
 * @author nicorama
 */
public interface IHandResolver extends Comparable<IHandResolver>{

	public IHand getHand();

	/**
	 * Check how many times the card level is found 5s in "5s 6d 5c 5h As" is
	 * found three times
	 * 
	 * @param cardLevel
	 * @return
	 */
	public int number(int cardLevel);

	/**
	 * "5s 6d 5c 5h As" returns { 1: [As], 5:[5s,5c,5h], 6:[6d] } 
	 * 
	 * @return
	 */
	public Map<Integer, List<Card>> group();

	public boolean isStraight();

	public boolean isFlush();
	
	public boolean isStraightFlush();
	
	public boolean isPair();
	
	public boolean isDoublePair();
	
	public boolean isHighCard();
	
	public boolean isTrips();
	
	public boolean isFourOfAKind();
	
	public boolean isFull();

	public HandValue getValue();
	
	/**
	 * Shortcut from the HandValue
	 * @return the Classifier of its HandValue
	 */
	public HandClassifier getClassifier();

}
