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
	
	
	
	
}
