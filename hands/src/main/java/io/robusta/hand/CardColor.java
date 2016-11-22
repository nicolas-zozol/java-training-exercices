package io.robusta.hand;

public enum CardColor {

	SPADE('s', 1), HEART('h', 2), DIAMOND('d', 3), CLUB('c', 4);
	
	char abbr;
	int value;
	
	private CardColor(char abbr, int value){
		this.abbr = abbr;
		this.value = value;
	}
	
	@Override
	public String toString() {
		
		return String.valueOf(this.abbr);
	}
	
	public char getAbbr() {
		return abbr;
	}
	
	public int getValue() {
		return value;
	}
	
	public static CardColor getByValue(int value){
		for (CardColor color : values()){
			if (color.getValue() == value){
				return color;
			}
		}
		throw new IllegalArgumentException("Can't find color for :"+value);
	}
	
	public static CardColor getByChar(char abbr){
		for (CardColor color : values()){
			if (color.getAbbr() == abbr){
				return color;
			}
		}
		throw new IllegalArgumentException("Can't find color for :"+abbr);
	}
}
