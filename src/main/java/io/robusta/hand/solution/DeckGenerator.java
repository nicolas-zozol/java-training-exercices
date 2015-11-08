package io.robusta.hand.solution;

import io.robusta.hand.Card;
import io.robusta.hand.CardColor;
import io.robusta.hand.interfaces.IDeckGenerator;

public class DeckGenerator implements IDeckGenerator {

	@Override
	public Deck generate() {
		Deck deck = new Deck();

		CardColor color = null;
		int value = 0;

		for (int i = 0; i < 52; i++) {
			color = CardColor.getByValue((i % 4) + 1);
			value = i % 13 + 1;

			assert value > 0 && value <= 13;
			assert color != null;

			Card card = new Card(value, color);
			deck.add(card);
		}
		return deck;
	}

}
