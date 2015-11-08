package io.robusta.hand.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import io.robusta.hand.Card;
import io.robusta.hand.CardColor;
import io.robusta.hand.HandClassifier;
import io.robusta.hand.interfaces.IDeck;
import io.robusta.hand.interfaces.IHand;

public class Hand extends TreeSet<Card> implements IHand{

	
	private static final long serialVersionUID = 7824823998655881611L;

	@Override
	public Set<Card> changeCards(IDeck deck, Set<Card> cards) {
		for (Card card : cards){
			if (!this.contains(card)){
				throw new IllegalArgumentException("the hand doesn't have "+card);
			}
		}
		this.removeAll(cards);
		Set<Card> newCards = deck.pick(cards.size());
		this.addAll(newCards);
		return newCards;
	}


	@Override
	public boolean beats(IHand villain) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IHand getHand() {
		return this;
	}

	@Override
	public HandClassifier getClassifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isStraight() {
		Iterator<Card> it = this.iterator();
		Card previous = it.next();
		while (it.hasNext()){
			Card next =it.next(); 
			if (next.getValue() !=previous.getValue() +1 ){
				return false;
			}
			previous = next;
		}
		return true;
	}

	@Override
	public boolean isFlush() {
		Iterator<Card> it = this.iterator();
		CardColor first = it.next().getColor();
		
		while (it.hasNext()){
			if (it.next().getColor() != first){
				return false;
			}
		}
		return true;
	}

	

	@Override
	public int number(int cardValue) {
		int result = 0;
		for (Card current : this){
			if (current.getValue() == cardValue){
				result++;
			}
		}
		return result;
	}


	@Override
	public HashMap<Integer, List<Card>> group() {
		HashMap<Integer, List<Card> > map = new HashMap<>();
		for (Card c : this){
			int value = c.getValue();
			List <Card> cards = map.get(value);
			if (cards == null){
				cards = new ArrayList<>();
				map.put(value, cards);
			}
			cards.add(c);
		}
		return map;
	}

	
}
