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
