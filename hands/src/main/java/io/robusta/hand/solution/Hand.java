package io.robusta.hand.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import io.robusta.hand.Card;
import io.robusta.hand.CardColor;
import io.robusta.hand.HandClassifier;
import io.robusta.hand.HandValue;
import io.robusta.hand.interfaces.IDeck;
import io.robusta.hand.interfaces.IHand;
import io.robusta.hand.interfaces.IHandResolver;

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
		return this.compareTo(villain) >0;
	}

	@Override
	public IHand getHand() {
		return this;
	}

	@Override
	public HandClassifier getClassifier() {
		
		return this.getValue().getClassifier();
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

	int mainValue;
	int tripsValue;
	int pairValue;
	int secondValue;
	TreeSet<Card> remainings;

	@Override
	public boolean isPair() {
		boolean foundOnce =false;
		HashMap<Integer, List<Card>> map =this.group();
		for (List<Card> group :map.values()){
			if (group.size() == 2){
				if (foundOnce){
					return false;
				}else{
					mainValue = group.get(0).getValue();
					foundOnce = true;
				}
			}				
		}
		if (foundOnce){
			map.remove(mainValue);
			this.remainings = getGroupRemainingsCard(map);
			return true;
		}else{
			return false;	
		}
		
	}


	@Override
	public boolean isDoublePair() {
		boolean foundOnce =false;
		boolean isDouble = false;
		HashMap<Integer, List<Card>> map =this.group();
		for (List<Card> group :map.values()){
			if (group.size() == 2){
				if (foundOnce){
					mainValue = group.get(0).getValue(); 
					isDouble = true;
				}else{
					secondValue = group.get(0).getValue();
					foundOnce = true;
				}
			}				
		}
		
		if (isDouble){
			map.remove(mainValue);
			map.remove(secondValue);
			this.remainings=getGroupRemainingsCard(map);
			return true;
		}
		return false;
	}


	@Override
	public boolean isHighCard() {
		if (this.isStraight() || this.isFlush()){
			return false;
		}
		for (List<Card> group :this.group().values()){
			if (group.size() > 1){
				return false;
			}				
		}
		return true;
	}


	@Override
	public boolean isTrips() {
		if (this.isFull() ){
			return false;
		}
		boolean found = false;
		HashMap<Integer, List<Card>> map =this.group(); 
		for (List<Card> group :map.values()){
			if (group.size() == 3){
				this.mainValue = group.get(0).getValue(); 
				found = true;
			}				
		}
		
		if (found){
			map.remove(this.mainValue);
			remainings = getGroupRemainingsCard(map);
			assert remainings.size() == 2;
		}
		return false;
	}

	TreeSet<Card>getGroupRemainingsCard(Map<Integer, List<Card>> map){
		TreeSet<Card> groupRemaining = new TreeSet<>();
		for (List<Card> group :map.values()){
			for (Card c : group){
				groupRemaining.add(c);
			}
		}
		return groupRemaining;
	}

	@Override
	public boolean isFourOfAKind() {
		boolean found = false;
		HashMap<Integer, List<Card>> map = this.group();
		for (List<Card> group :map.values()){
			if (group.size() == 4){
				this.mainValue = group.get(0).getValue();
				return true;
			}				
		}
		//setting remainings
		if (found){
			map.remove(mainValue);
			assert map.values().size() == 1 : "only one card remaining";
			for (List<Card> cards : map.values()){
				assert cards.size() ==1;
				remainings = new TreeSet<>();
				remainings.add(cards.get(0));
			}
			return true;
		}else{
			return false;	
		}
		
		
	}


	
	@Override
	public boolean isFull() {
		boolean foundTwo = false;
		boolean foundThree = false;
		for (List<Card> group :this.group().values()){
			if (group.size() == 2){
				foundTwo = true;
				pairValue = group.get(0).getValue();
			}				
			if (group.size() == 3){
				foundThree = true;
				tripsValue = group.get(0).getValue();
			}
		}
		return foundThree && foundTwo;
	}


	@Override
	public boolean isStraightFlush() {
		return this.isStraight() && this.isFlush();
	}


	@Override
	public HandValue getValue() {
		HandValue handValue = new HandValue();
		if (this.isStraightFlush()){
			handValue.setClassifier(HandClassifier.STRAIGHT_FLUSH);
			handValue.setLevelValue(this.highestValue());
			return handValue;
		}
		
		if(this.isFourOfAKind()){
			handValue.setClassifier(HandClassifier.FOUR_OF_A_KIND);
			handValue.setLevelValue(this.mainValue);
			handValue.setOtherCards(this.remainings);
			return handValue;
		}
		if(this.isFull()){
			handValue.setClassifier(HandClassifier.FULL);
			handValue.setLevelValue(this.tripsValue);
			handValue.setSecondLevel(this.pairValue);
			return handValue;
		}
		if (this.isFlush()){
			handValue.setClassifier(HandClassifier.FLUSH);
			handValue.setLevelValue(this.highestValue());
			return handValue;
		}
		if (this.isStraight()){
			handValue.setClassifier(HandClassifier.STRAIGHT);
			handValue.setLevelValue(this.highestValue());
			return handValue;
		}
		if (this.isTrips()){
			handValue.setClassifier(HandClassifier.TRIPS);
			handValue.setLevelValue(this.highestValue());
			handValue.setOtherCards(this.remainings);
			return handValue;
		}
		if (this.isDoublePair()){
			handValue.setClassifier(HandClassifier.TWO_PAIR);
			handValue.setLevelValue(this.mainValue);
			handValue.setSecondLevel(this.mainValue);
			handValue.setOtherCards(this.remainings);
			return handValue;
		}
		
		if (this.isPair()){
			handValue.setClassifier(HandClassifier.PAIR);
			handValue.setLevelValue(this.mainValue);
			handValue.setOtherCards(this.remainings);
			return handValue;
		}
		handValue.setClassifier(HandClassifier.HIGH_CARD);
		handValue.setLevelValue(this.highestValue());
		handValue.setOtherCards(this);
		return handValue;
	}


	@Override
	public boolean hasCardValue(int level) {
		for (Card c : this){
			if (c.getValue() == level){
				return true;
			}
		}
		return false;
	}


	@Override
	public boolean hasAce() {
		return this.last().isAce();
	}


	@Override
	public int highestValue() {
		if (this.hasAce()){
			return 14;
		}
		return this.last().getValue();
	}


	@Override
	public int compareTo(IHandResolver o) {
		HandValue hv1 = this.getValue();
		HandValue hv2 = o.getValue();
		return hv1.compareTo(hv2);
	}

	
}
