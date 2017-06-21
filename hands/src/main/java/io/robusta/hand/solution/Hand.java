<<<<<<< HEAD
package io.robusta.hand.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import io.robusta.hand.Card;
import io.robusta.hand.HandClassifier;
import io.robusta.hand.HandValue;
import io.robusta.hand.interfaces.IDeck;
import io.robusta.hand.interfaces.IHand;
import io.robusta.hand.interfaces.IHandResolver;

public class Hand extends TreeSet<Card> implements IHand {

	private static final long serialVersionUID = 7824823998655881611L;

	final static int nbCardsInHand = 5;

	public Hand() {
	};

	public Hand(TreeSet<Card> cards) {
		this.addAll(cards);
	}

	@Override
	public Set<Card> changeCards(IDeck deck, Set<Card> cards) {
		// For exemple remove three cards from this hand
		// , and get 3 new ones from the Deck
		// returns the new given cards
		return null;
	}

	/**
	 * beats is the same than compareTo, but with a nicer name. The problem is
	 * that it does not handle equality :(
	 * 
	 * @param villain
	 * @return
	 */
	@Override
	public boolean beats(IHand villain) {
		HandValue me = this.getValue();
		HandValue him = villain.getValue();
		
		if (me.getClassifier().getValue()>him.getClassifier().getValue())
			return true;
		else if (me.getClassifier().getValue()<him.getClassifier().getValue())
			return false;
		else {
			if (me.getLevelValue()>him.getLevelValue())
				return true;
			else if (me.getLevelValue()<him.getLevelValue())
				return false;
			else {
				if (me.getSecondLevel()>him.getSecondLevel())
					return true;
				else if (me.getSecondLevel()<him.getSecondLevel())
					return false;
				else{
					return false;
				}
			}
		}
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
		Set<Integer> keys = this.group().keySet();
		if (keys.size() != Hand.nbCardsInHand) {
			return false;
		}

		Iterator<Integer> iterator = keys.iterator();
		Integer firstValue = iterator.next();
		Integer wValue = firstValue;
		int i = 0;
		while ((keys.contains(wValue + 1) || keys.contains(wValue - 1)) && i < keys.size()) {
			i++;
			if (i < keys.size()) {
				wValue = iterator.next();
			}
		}

		if (i == Hand.nbCardsInHand) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isFlush() {
		Iterator<Card> iterator = this.iterator();
		Card firstCard = iterator.next();
		Card wCard = firstCard;
		int i = 0;

		while (wCard.getColor().equals(firstCard.getColor()) && i < Hand.nbCardsInHand) {

			i++;
			if (i < this.size()) {
				wCard = iterator.next();
			}
		}
		if (i == Hand.nbCardsInHand) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns number of identical cards 5s5cAd2s3s has two cardValue of 5
	 */
	@Override
	public int number(int cardValue) {
		int result = 0;
		for (Card current : this) {
			if (current.getValue() == cardValue) {
				result++;
			}
		}
		return result;
	}

	/**
	 * The fundamental map Check the tests and README to understand
	 */
	@Override
	public Map<Integer, List<Card>> group() {
		HashMap<Integer, List<Card>> map = new HashMap<>();

		Iterator<Card> iterator = this.iterator();
		for (int i = 0; i < Hand.nbCardsInHand; i++) {
			Card wCard = iterator.next();
			List<Card> wCards = new ArrayList<>();
			int value = wCard.getValue();
			if (map.containsKey(value)) {
				wCards = map.get(value);
				wCards.add(wCard);
				map.replace(value, wCards);
			} else {
				wCards.add(wCard);
				map.put(value, wCards);
			}
		}
		return map;
	}

	// different states of the hand
	// Using stateful variables. We need to fill this, then use it before.
	int levelValue = 0;
	// Needed with two pairs or full
	int secondValue = 0;
	// Put all cards for flush or highCard ;
	TreeSet<Card> singleCards = new TreeSet<>();

	/**
	 * return all single cards not used to build the classifier
	 *
	 * @param map
	 * @return
	 */
	TreeSet<Card> getSingleCards(Map<Integer, List<Card>> map) {
		// method is done, DO NOT TOUCH !
		TreeSet<Card> singleCards = new TreeSet<>();
		// May be adapted at the end of project:
		// if straight or flush : return empty
		// If High card, return 4 cards
		for (List<Card> group : map.values()) {
			if (group.size() == 1) {
				singleCards.add(group.get(0));
			}
		}
		return singleCards;
	}

	@Override
	public boolean isPair() {
		return (this.group().size() == 4);
	}

	@Override
	public boolean isDoublePair() {
		return (this.group().size() == 3 && !this.isTrips());
	}

	@Override
	public boolean isHighCard() {
		return (this.group().size()==5 && !this.isFlush() && !this.isStraight());
	}

	@Override
	public boolean isTrips() {
		if (this.group().size() != 3) {
			return false;
		} else {
			Map<Integer, List<Card>> map = this.group();
			Set<Integer> keys = map.keySet();
			Iterator<Integer> iterator = keys.iterator();
			Integer wKey = iterator.next();

			boolean result = false;
			int i = 0;
			while (i < keys.size() && !result) {
				result = map.get(wKey).size() == 3;
				i++;
				if(i<keys.size()){
					keys.size();
				}
			}
			return result;
		}
	}
// TODO Lien de facilite
	@Override
	public boolean isFourOfAKind() {
		if (this.group().size() != 2) {
			return false;
		} else {
			Map<Integer, List<Card>> map = this.group();
			Set<Integer> keys = map.keySet();
			Iterator<Integer> iterator = keys.iterator();
			Integer wKey = iterator.next();

			boolean result = false;
			int i = 0;
			while (i < keys.size() && !result) {
				result = map.get(wKey).size() == 4;
				wKey = iterator.next();
				i++;
			}
			return result;
		}
	}

	@Override
	public boolean isFull() {
		return (this.group().size() == 2 && !this.isFourOfAKind());
	}

	@Override
	public boolean isStraightFlush() {
		return (this.isFlush() && this.isStraight()) ;
	}

	@Override
	public HandValue getValue() {
		HandValue handValue = new HandValue();

		Map<Integer, List<Card>> map = this.group();
		Set<Integer> keys = map.keySet();
		Iterator<Integer> iterator = keys.iterator();
		Integer wKey = iterator.next();

		if (this.isStraightFlush()) {
			handValue.setClassifier(HandClassifier.STRAIGHT_FLUSH);
			this.levelValue = this.highestValue();
			this.secondValue = this.getSecondHighestValue();
		}

		else if (this.isFourOfAKind()) {
			handValue.setClassifier(HandClassifier.FOUR_OF_A_KIND);

			int i = 0;
			while (i < keys.size() && map.get(wKey).size() != 4) {
				if (iterator.hasNext()){
					wKey = iterator.next();
				}
				i++;
			}
			this.levelValue = wKey;
			if (this.levelValue == this.highestValue()){
				this.secondValue= this.highestValue();
			}else{
				this.secondValue = this.getSecondHighestValue();
			}
		}

		else if (this.isFull()) {
			handValue.setClassifier(HandClassifier.FULL);

			for (int i = 0; i < keys.size(); i++) {
				if (map.get(wKey).size() == 3) {
					this.levelValue = wKey;
				} else if (map.get(wKey).size() == 2) {
					this.secondValue = wKey;
				}
				if (iterator.hasNext()){
					wKey = iterator.next();
				}
			}
		}

		else if (this.isFlush()) {
			handValue.setClassifier(HandClassifier.FLUSH);
			this.levelValue = this.highestValue();
			this.secondValue = this.getSecondHighestValue();
		}

		else if (this.isStraight()) {
			handValue.setClassifier(HandClassifier.STRAIGHT);
			this.levelValue = this.highestValue();
			this.secondValue = this.getSecondHighestValue();
		}

		else if (this.isTrips()) {
			handValue.setClassifier(HandClassifier.TRIPS);

			int i = 0;
			while (i < keys.size() && map.get(wKey).size() != 3) {
				if (iterator.hasNext()){
					wKey = iterator.next();
				}
				i++;
			}
			this.levelValue = wKey;
			
			if (this.levelValue == this.highestValue()){
				this.secondValue= this.highestValue();
			}else{
				this.secondValue = this.getSecondHighestValue();
			}
		}

		else if (this.isDoublePair()) {
			handValue.setClassifier(HandClassifier.TWO_PAIR);

			for (int i = 0; i < keys.size(); i++) {
				if (map.get(wKey).size() == 2) {
					if (wKey > this.levelValue) {
						this.secondValue = this.levelValue;
						this.levelValue = wKey;
					} else {
						this.secondValue = wKey;
					}
				}
				if (iterator.hasNext()){
					wKey = iterator.next();
				}
			}
		}

		else if (this.isPair()) {
			handValue.setClassifier(HandClassifier.PAIR);

			int i = 0;
			while (i < keys.size() && map.get(wKey).size() != 2) {
				if (iterator.hasNext()){
					wKey = iterator.next();
				}
				i++;
			}
			this.levelValue = wKey;
			if (this.levelValue == this.highestValue()){
				this.secondValue= this.highestValue();
			}else{
				this.secondValue = this.getSecondHighestValue();
			}		
		}

		else if (this.isHighCard()) {
			handValue.setClassifier(HandClassifier.HIGH_CARD);
			this.levelValue = this.highestValue();
			this.levelValue = this.getSecondHighestValue();	
		}
		
		handValue.setLevelValue(this.levelValue);
		handValue.setSecondLevel(this.secondValue);
		this.singleCards = this.getSingleCards(map);
		handValue.setSingleCards(this.singleCards); // this.getsingleCards()
		return handValue;
	}
	

	@Override
	public boolean hasCardValue(int level) {

		return false;
	}

	@Override
	public boolean hasAce() {
		return false;
	}

	@Override
	public int highestValue() {
		Set<Integer> keys = this.group().keySet();
		return Collections.max(keys);
	}
	
	@Override
	public int getSecondHighestValue() {
		Set<Integer> keys = this.group().keySet();
		keys.remove(Collections.max(keys));
		return Collections.max(keys);
	}

	@Override
	public int compareTo(IHandResolver o) {
		// You should reuse HandValue.compareTo()
		return 0;
	}

}
=======
package io.robusta.hand.solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import io.robusta.hand.Card;
import io.robusta.hand.HandClassifier;
import io.robusta.hand.HandValue;
import io.robusta.hand.interfaces.IDeck;
import io.robusta.hand.interfaces.IHand;
import io.robusta.hand.interfaces.IHandResolver;

public class Hand extends TreeSet<Card> implements IHand {


    private static final long serialVersionUID = 7824823998655881611L;

  


    /**
     * beats is the same than compareTo, but with a nicer name.
     * The problem is that it does not handle equality :(
     * @param villain
     * @return
     */
    @Override
    public boolean beats(IHand villain) {
        return false;
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

        return false;
    }

    @Override
    public boolean isFlush() {

        return true;
    }


    /**
     * Returns number of identical cards
     * 5s5cAd2s3s  has two cardValue of 5
     */
    @Override
    public int number(int cardValue) {
        int result = 0;
        for (Card current : this) {
            if (current.getValue() == cardValue) {
                result++;
            }
        }
        return result;
    }


    /**
     * The fundamental map
     * Check the tests and README to understand
     */
    @Override
    public Map<Integer, List<Card>> group() {
        HashMap<Integer, List<Card>> map = new HashMap<>();

        // fill the map

        return map;
    }


    // different states of the hand
    // Using stateful variables. We need to fill this, then use it before.
    int levelValue = 0;
    // Needed with two pairs or full
    int secondValue = 0;
    // Put all cards for flush or highCard ;
    TreeSet<Card> singleCards = new TreeSet<>();


    /**
     * return all single cards not used to build the classifier
     *
     * @param map
     * @return
     */
    TreeSet<Card> getSingleCards(Map<Integer, List<Card>> map) {
        // method is done, DO NOT TOUCH !
        TreeSet<Card> singleCards = new TreeSet<>();
        // May be adapted at the end of project:
        // if straight or flush : return empty
        // If High card, return 4 cards
        for (List<Card> group : map.values()) {
            if (group.size() == 1) {
                singleCards.add(group.get(0));
            }
        }
        return singleCards;
    }


    @Override
    public boolean isPair() {
        return false;
    }


    @Override
    public boolean isDoublePair() {
        return false;
    }


    @Override
    public boolean isHighCard() {
        return true;
    }


    @Override
    public boolean isTrips() {

        return false;
    }


    @Override
    public boolean isFourOfAKind() {

        return false;


    }


    @Override
    public boolean isFull() {
        return false;
    }


    @Override
    public boolean isStraightFlush() {
        return false;
    }


    @Override
    public HandValue getValue() {
        HandValue handValue = new HandValue();

        // Exemple for FourOfAKind ; // do for all classifiers
        if (this.isFourOfAKind()) {
            handValue.setClassifier(HandClassifier.FOUR_OF_A_KIND);
            handValue.setLevelValue(this.levelValue);
            handValue.setSingleCards(this.singleCards); // or this.getsingleCards()
            return handValue;
        }

        // For the flush, all singleCards are needed

        return handValue;
    }


    @Override
    public boolean hasCardValue(int level) {

        return false;
    }


    @Override
    public boolean hasAce() {
        return false;
    }


    @Override
    public int highestValue() {
        // ace might be the highest value
        return 0;
    }



    @Override
    public int compareTo(IHandResolver o) {
        // You should reuse HandValue.compareTo()
        return 0;
    }


}
>>>>>>> 03c2b86f976adbb08f826b64e2c33c73d19e8773
