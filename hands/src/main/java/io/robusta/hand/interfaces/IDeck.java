package io.robusta.hand.interfaces;

import java.util.Collection;
import java.util.TreeSet;

import io.robusta.hand.Card;
import io.robusta.hand.solution.Hand;

public interface IDeck extends Collection<Card>{

	int INITIAL_SIZE=52;
	/**
	 * @return pick randomCard and remove it
	 */
	public Card pick();
	
	/**
	 * Important : the deck must be shuffled before each call !
	 * @return pick randomCards and remove them
	 */
	public TreeSet<Card> pick(int number);
	
	/**
	 * pick 5 cards that create a hand
	 * @return Hand
	 */
	public Hand giveHand();
	
	/**
	 * @return current size of the deck
	 */
	public int size();
	
	public boolean contains(Card card);
}
