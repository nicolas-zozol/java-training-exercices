package io.robusta.java.classic;

/**
 * Created by nicorama on 21/06/2017.
 */
public class Card {
    int value;
    char color;

    public Card(int value, char color) {
        this.value = value;
        this.color = color;
    }

    @Override
    public int hashCode() {
        return this.value + this.color;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Card) {

            Card other = (Card) obj;
            if (this.value == other.value && this.color == other.color) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "" + this.value + this.color;
    }
}
