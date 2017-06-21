package io.robusta.hand.solution;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

import io.robusta.hand.Card;
import io.robusta.hand.interfaces.IDeck;

public class Deck extends LinkedList<Card> implements IDeck{

	
	private static final long serialVersionUID = -4686285366508321800L;
	
	
	public Deck() {

	}
	
	@Override
	public Card pick() {
		Collections.shuffle(this);
		Random random = new Random();
		int index = random.nextInt(this.size());
		Card result = this.get(index);
		this.remove(index);
		return result;
	}


	

	@Override
	public TreeSet<Card> pick(int number) {
		TreeSet<Card> result = new TreeSet<>();
		for(int i=0;i<number;i++){
			result.add(this.pick());
		}
		return result;
	}

	@Override
	public Hand giveHand() {
		TreeSet<Card> cards = this.pick(Hand.nbCardsInHand);
		return new Hand(cards);
	}
//	
//	public void shuffle(){
//		Deck shuffledDeck = new Deck();
//		while (this.size()>0){
//			shuffledDeck.add(this.pick());
//		}
//		for(int i =0;i<shuffledDeck.size();i++){
//			this.add(shuffledDeck.get(i));
//		}
//		
//	}
	
}
