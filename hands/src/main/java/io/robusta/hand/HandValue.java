package io.robusta.hand;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * In a HandValue, the As will often hanve a 14 value
 * @author nicorama
 */
public class HandValue implements Comparable<HandValue>{

	/**
	 * pair, straight ...
	 */
	HandClassifier classifier;
	/**
	 * The value level of the classifier
	 * the straight 4-5-6-7-8 has a 8 value
	 * T-J-Q-K-A has 14  value !!!  
	 */
	int levelValue = 0;
	
	//Needed with two pairs or full
	int secondLevel = 0;
	/**
	 * Single cards of the hand for advanced comparisons
	 */
	TreeSet<Card> singleCards = new TreeSet<>();
	
	
	public HandValue() {
		
	}
	
	public HandValue(HandClassifier classifier, int levelValue, TreeSet<Card> singleCards) {
		this.classifier = classifier;
		this.levelValue = levelValue;
		this.singleCards = singleCards;
	}


	@Override
	public int compareTo(HandValue o) {
		//First compare classifier
		if (classifier != o.classifier){
			return Integer.valueOf(classifier.getValue()).
					compareTo(o.classifier.getValue());
		}
		
		//If classifier equals then  compare levels
			//(str8 to the As vs stre8 to the Q
		if(levelValue != o.levelValue){
			return Integer.valueOf(levelValue).
					compareTo(o.levelValue);
		}
		
		if(secondLevel != o.secondLevel){
			return Integer.valueOf(secondLevel).
					compareTo(o.secondLevel);
		}
		
		
		//else compare single cards
		return compareSets(this.singleCards, o.singleCards);
		
		
	}
	
	
	int compareSets(TreeSet<Card> s1, TreeSet<Card> s2){
		
		assert s1.size() == s2.size() : s1 +" vs "+s2;
		
		//Cool !!! from As, K,Q to 2
		Iterator<Card> it1 = s1.descendingIterator();
		Iterator<Card> it2 = s2.descendingIterator();
		Card c1, c2;
		while (it1.hasNext() && it2.hasNext()){
			c1 = it1.next();
			c2 = it2.next();
			int result = c1.compareValue(c2);
			if (result !=0 ){
				return result;
			}
		}
		//not found : all are equals;
		return 0;
		
	}


	public HandClassifier getClassifier() {
		return classifier;
	}


	public void setClassifier(HandClassifier classifier) {
		this.classifier = classifier;
	}


	public int getLevelValue() {
		return levelValue;
	}


	public void setLevelValue(int levelValue) {
		this.levelValue = levelValue;
	}


	public int getSecondLevel() {
		return secondLevel;
	}


	public void setSecondLevel(int secondLevel) {
		this.secondLevel = secondLevel;
	}


	public TreeSet<Card> getSingleCards() {
		return singleCards;
	}


	public void setSingleCards(TreeSet<Card> singleCards) {
		this.singleCards = singleCards;
	}
	
	
}
