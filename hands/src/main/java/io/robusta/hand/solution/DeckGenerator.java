package io.robusta.hand.solution;

import io.robusta.hand.Card;
import io.robusta.hand.CardColor;
import io.robusta.hand.interfaces.IDeck;
import io.robusta.hand.interfaces.IDeckGenerator;

public class DeckGenerator implements IDeckGenerator {

	@Override
	public Deck generate() {
		Deck deck = new Deck();

		// fill the deck with cards
        // Probably use the good modulo
		for (int i = 0; i < IDeck.INITIAL_SIZE; i++) {
			
			Card c = new Card((i%13)+1, CardColor.getByValue(1+(i/13)));
			deck.add(c);
		}
		return deck;
	}

}
