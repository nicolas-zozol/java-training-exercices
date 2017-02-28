package io.robusta.hand;

import java.util.TreeSet;

import io.robusta.hand.interfaces.IDeckGenerator;
import io.robusta.hand.solution.DeckGenerator;

public class PokerTest {

	public IDeckGenerator generator;
	public 	Card fourSpade;
	public Card aceClub;
	public Card queenHeart;
	
	public PokerTest() {
		generator = new DeckGenerator();
		fourSpade = generator.generateCard("4s");
		aceClub = generator.generateCard("Ac");
		queenHeart = generator.generateCard("Qh");
	}
	
	public Card generateCard(String card){
		return generator.generateCard(card);
	}
	
	public TreeSet<Card> generateCards(String card){
		return generator.generateCards(card);
	}
	
	
}
