package io.robusta.hand.interfaces;

import java.util.TreeSet;

import io.robusta.hand.Card;
import io.robusta.hand.CardColor;
import io.robusta.hand.solution.Deck;

public interface IDeckGenerator {

	Deck generate();

	default Card generateCard(String card) {
		if (card == null) {
			throw new IllegalArgumentException("sending null card");
		}

		if (card.length() != 2) {
			throw new IllegalArgumentException("Invalid card size for " + card);
		}

		char charValue = card.charAt(0);
		int intValue = Helper.getValue(charValue);
		
		char colorCharValue = card.charAt(1);
		CardColor color = CardColor.getByChar(colorCharValue);
		
		return new Card(intValue, color);

	}
	
	default TreeSet<Card> generateCards(String cards){
		TreeSet<Card> result = new TreeSet<>();
		String[] array = cards.split(" ");
		for (String str : array){
			result.add(generateCard(str));
		}
		return result;
	}
	
	default Card generateCard(int number){
		int value = number/4 +1;
		int charColor = number%4 +1;
		CardColor color = CardColor.getByValue(charColor);		
		return new Card(value, color);
	}
	
	

}

class Helper {

	public static int getValue(char c){
		int value;
		try{
			value = Integer.valueOf(""+c);
		}catch(Exception ex){
			
			switch(c){
			case 'T' : return 10;
			case 'J' : return 11;
			case 'Q' : return 12;
			case 'K' : return 13;
			case 'A' : return Card.AS_VALUE;
			default: throw new IllegalArgumentException("Can't find value for : "+c);
			}
			
			
		}
		return value;
		
		
	}
}
