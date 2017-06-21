package io.robusta.hand.interfaces;

import java.util.Set;
import java.util.SortedSet;

import io.robusta.hand.Card;

public interface IHand extends SortedSet<Card>, IHandResolver{
	
	/**
	 * Remove some cards, and add some new ones.
	 * The new ones are also returned  
	 * @param number
	 * @return the new cards
	 */
	Set<Card> changeCards(IDeck deck, Set<Card> cards);
	
	/**
	 * @return true if it beats Villain's hand
	 */
	boolean beats(IHand villain);
	
	
	/**
	 * hasCard(1) returns true if the hand has an ace
	 * hasCard(5) returns true if the hand has a five
	 * Useful to test if straight starts with Ace or not
	 */
	boolean hasCardValue(int level);
	
	/**
	 * Shortcut for hasCardLevel(1)
	 * @return true if the hand has at least one ace
	 */
	boolean hasAce();
	
	/**
	 * Returns 14 if it has an ace.
	 * If not, the value of its highest card
	 * @return
	 */
	int highestValue();
	int getSecondHighestValue();


	
	
	
	
}
