package io.robusta.hand;

import java.util.TreeSet;

import io.robusta.hand.interfaces.IDeckGenerator;
import io.robusta.hand.solution.Deck;

public class PokerTest {

	IDeckGenerator abstractGenerator;
	public 	Card fourSpade;
	public Card aceClub;
	public Card queenHeart;
	
	public PokerTest() {
		abstractGenerator = new IDeckGenerator() {
			
			@Override
			public Deck generate() {
				return null;
			}
		};
		fourSpade = abstractGenerator.generateCard("4s");
		aceClub = abstractGenerator.generateCard("Ac");
		queenHeart = abstractGenerator.generateCard("Qh");
	}
	
	public Card generateCard(String card){
		return abstractGenerator.generateCard(card);
	}
	
	public TreeSet<Card> generateCards(String card){
		return abstractGenerator.generateCards(card);
	}
	
	
}
