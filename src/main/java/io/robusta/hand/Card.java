package io.robusta.hand;

public class Card implements Comparable<Card> {

	public static int AS_VALUE = 1;
	int value;
	CardColor color;
	int deckValue;
	
	public Card(int value, CardColor color) {
		this.value = value;
		this.color = color;
		this.deckValue= (this.value -1)*4+color.value;
	}
	
	
	@Override
	public String toString() {
		return this.getCharValue() + color.toString();
	}
	
	
	public int getValue() {
		return value;
	}
	
	public CardColor getColor() {
		return color;
	}
	
	public char getCharValue(){
		switch (this.value){
			case 1 : return 'A';
			case 10 : return 'T';
			case 11 : return 'J';
			case 12 : return 'Q';
			case 13 : return 'K';
			default : return String.valueOf(this.value).charAt(0);
		}
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + value;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Card))
			return false;
		Card other = (Card) obj;
		if (color != other.color)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	public boolean isAce(){
		return this.getValue() == AS_VALUE;
	}

	@Override
	public int compareTo(Card o) {
		//Aces
		
		if (this.isAce() && !o.isAce()){
			return 1;
		}
		if (!this.isAce() && o.isAce()){
			return -1;
		}
		return Integer.valueOf(this.deckValue).compareTo(o.deckValue);
	}
	
	
	public int compareValue(Card o) {
		//Aces
		
		if (this.isAce() && !o.isAce()){
			return 1;
		}
		if (!this.isAce() && o.isAce()){
			return -1;
		}
		return Integer.valueOf(this.value).compareTo(o.value);
	}
	
	
}
