package cards;

import java.util.Objects;

public class Card implements Comparable {

    private Value value;
    private Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public int compareTo(Object o) {
        Card card = (Card) o;
        if (this.value.getValue() > card.value.getValue())
            return -1;
        else if (this.value.getValue() < card.value.getValue())
            return 1;
        else
            return 0;
    }

    public int getNumber() {
        return value.getValue();
    }

    public Value getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value && suit == card.suit;
    }
}
