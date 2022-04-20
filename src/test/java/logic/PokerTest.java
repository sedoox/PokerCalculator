package logic;

import cards.Card;
import cards.Suit;
import cards.Value;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PokerTest {

    private Poker poker;
    ArrayList<Card> cards;

    @BeforeEach
    void setUp() {
        cards = new ArrayList<Card>();
    }

    @Test
    void checkForHigh1() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.THREE, Suit.CLUBS));
        cards.add(new Card(Value.EIGHT, Suit.CLUBS));
        cards.add(new Card(Value.SIX, Suit.CLUBS));
        cards.add(new Card(Value.THREE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForHigh();
        assertEquals(8, list.get(0));
        assertEquals(6, list.get(1));
        assertEquals(5, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(4, list.get(4));
    }

    @Test
    void checkForHigh2() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.THREE, Suit.CLUBS));
        cards.add(new Card(Value.KING, Suit.CLUBS));
        cards.add(new Card(Value.SIX, Suit.CLUBS));
        cards.add(new Card(Value.JACK, Suit.CLUBS));
        cards.add(new Card(Value.ACE, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForHigh();
        assertEquals(14, list.get(0));
        assertEquals(13, list.get(1));
        assertEquals(11, list.get(2));
        assertEquals(6, list.get(3));
        assertEquals(4, list.get(4));
    }

    @Test
    void checkForPair1() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.ACE, Suit.CLUBS));
        cards.add(new Card(Value.SEVEN, Suit.CLUBS));
        cards.add(new Card(Value.EIGHT, Suit.CLUBS));
        cards.add(new Card(Value.SIX, Suit.CLUBS));
        cards.add(new Card(Value.THREE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForPair();
        assertNull(list);
    }

    @Test
    void checkForPair2() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.SEVEN, Suit.CLUBS));
        cards.add(new Card(Value.EIGHT, Suit.CLUBS));
        cards.add(new Card(Value.SIX, Suit.CLUBS));
        cards.add(new Card(Value.THREE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForPair();
        assertEquals(4, list.get(0));
        assertEquals(8, list.get(1));
        assertEquals(7, list.get(2));
        assertEquals(6, list.get(3));
    }

    @Test
    void checkForPair3() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.SEVEN, Suit.CLUBS));
        cards.add(new Card(Value.EIGHT, Suit.CLUBS));
        cards.add(new Card(Value.SIX, Suit.CLUBS));
        cards.add(new Card(Value.ACE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForPair();
        assertEquals(5, list.get(0));
        assertEquals(14, list.get(1));
        assertEquals(8, list.get(2));
        assertEquals(7, list.get(3));
    }

    @Test
    void checkForTwoPair1() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.SEVEN, Suit.CLUBS));
        cards.add(new Card(Value.EIGHT, Suit.CLUBS));
        cards.add(new Card(Value.SIX, Suit.CLUBS));
        cards.add(new Card(Value.ACE, Suit.CLUBS));
        cards.add(new Card(Value.JACK, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForTwoPair();
        assertNull(list);
    }

    @Test
    void checkForTwoPair2() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.SEVEN, Suit.CLUBS));
        cards.add(new Card(Value.EIGHT, Suit.CLUBS));
        cards.add(new Card(Value.SIX, Suit.CLUBS));
        cards.add(new Card(Value.SIX, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForTwoPair();
        assertEquals(6, list.get(0));
        assertEquals(5, list.get(1));
        assertEquals(8, list.get(2));
    }

    @Test
    void checkForTwoPair3() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Value.SIX, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.ACE, Suit.CLUBS));
        cards.add(new Card(Value.EIGHT, Suit.CLUBS));
        cards.add(new Card(Value.NINE, Suit.CLUBS));
        cards.add(new Card(Value.SIX, Suit.CLUBS));
        cards.add(new Card(Value.ACE, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForTwoPair();
        assertEquals(14, list.get(0));
        assertEquals(6, list.get(1));
        assertEquals(9, list.get(2));
    }

    @Test
    void checkForSet1() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.SEVEN, Suit.CLUBS));
        cards.add(new Card(Value.EIGHT, Suit.CLUBS));
        cards.add(new Card(Value.SIX, Suit.CLUBS));
        cards.add(new Card(Value.THREE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForSet();
        assertNull(list);
    }

    @Test
    void checkForSet2() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.SEVEN, Suit.CLUBS));
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.ACE, Suit.CLUBS));
        cards.add(new Card(Value.THREE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForSet();
        assertEquals(4, list.get(0));
        assertEquals(14, list.get(1));
        assertEquals(7, list.get(2));
    }

    @Test
    void checkForSet3() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Value.KING, Suit.CLUBS));
        cards.add(new Card(Value.KING, Suit.CLUBS));
        cards.add(new Card(Value.SEVEN, Suit.CLUBS));
        cards.add(new Card(Value.SEVEN, Suit.CLUBS));
        cards.add(new Card(Value.ACE, Suit.CLUBS));
        cards.add(new Card(Value.SEVEN, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForSet();
        assertEquals(7, list.get(0));
        assertEquals(14, list.get(1));
        assertEquals(13, list.get(2));
    }

    @Test
    void checkForStraight1() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.SEVEN, Suit.CLUBS));
        cards.add(new Card(Value.EIGHT, Suit.CLUBS));
        cards.add(new Card(Value.SIX, Suit.CLUBS));
        cards.add(new Card(Value.THREE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));

        poker = new Poker(cards);
        Integer integer = poker.checkForStraight();
        assertEquals(8, integer);
    }

    @Test
    void checkForStraight2() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.EIGHT, Suit.CLUBS));
        cards.add(new Card(Value.EIGHT, Suit.CLUBS));
        cards.add(new Card(Value.SIX, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));

        poker = new Poker(cards);
        Integer integer = poker.checkForStraight();
        assertNull(integer);
    }

    @Test
    void checkForStraight3() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Value.QUEEN, Suit.CLUBS));
        cards.add(new Card(Value.TEN, Suit.CLUBS));
        cards.add(new Card(Value.EIGHT, Suit.CLUBS));
        cards.add(new Card(Value.JACK, Suit.HEARTS));
        cards.add(new Card(Value.KING, Suit.CLUBS));
        cards.add(new Card(Value.ACE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));

        poker = new Poker(cards);
        Integer integer = poker.checkForStraight();
        assertEquals(14, integer);
    }

    @Test
    void checkForStraight4() {
        cards.add(new Card(Value.QUEEN, Suit.CLUBS));
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.THREE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.KING, Suit.CLUBS));
        cards.add(new Card(Value.ACE, Suit.CLUBS));
        cards.add(new Card(Value.TWO, Suit.CLUBS));

        poker = new Poker(cards);
        Integer integer = poker.checkForStraight();
        assertEquals(5, integer);
    }

    @Test
    void checkForStraight5() {
        cards.add(new Card(Value.FIVE, Suit.DIAMONDS));
        cards.add(new Card(Value.FIVE, Suit.SPADES));
        cards.add(new Card(Value.FIVE, Suit.HEARTS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.KING, Suit.CLUBS));
        cards.add(new Card(Value.ACE, Suit.CLUBS));
        cards.add(new Card(Value.TWO, Suit.CLUBS));

        poker = new Poker(cards);
        Integer integer = poker.checkForStraight();
        assertNull(integer);
    }

    @Test
    void checkForStraight6() {
        cards.add(new Card(Value.FIVE, Suit.DIAMONDS));
        cards.add(new Card(Value.SIX, Suit.SPADES));
        cards.add(new Card(Value.SEVEN, Suit.HEARTS));
        cards.add(new Card(Value.ACE, Suit.CLUBS));
        cards.add(new Card(Value.EIGHT, Suit.CLUBS));
        cards.add(new Card(Value.NINE, Suit.CLUBS));
        cards.add(new Card(Value.TWO, Suit.CLUBS));

        poker = new Poker(cards);
        Integer integer = poker.checkForStraight();
        assertEquals(9, integer);
    }

    @Test
    void checkForFlush1() {
        cards.add(new Card(Value.QUEEN, Suit.CLUBS));
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.THREE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.KING, Suit.CLUBS));
        cards.add(new Card(Value.ACE, Suit.CLUBS));
        cards.add(new Card(Value.TWO, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForFlush();
        assertEquals(14, list.get(0));
        assertEquals(13, list.get(1));
        assertEquals(12, list.get(2));
        assertEquals(5, list.get(3));
        assertEquals(4, list.get(4));
    }

    @Test
    void checkForFlush2() {
        cards.add(new Card(Value.QUEEN, Suit.CLUBS));
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.THREE, Suit.HEARTS));
        cards.add(new Card(Value.FIVE, Suit.HEARTS));
        cards.add(new Card(Value.KING, Suit.DIAMONDS));
        cards.add(new Card(Value.ACE, Suit.SPADES));
        cards.add(new Card(Value.TWO, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForFlush();
        assertNull(list);
    }

    @Test
    void checkForFlush3() {
        cards.add(new Card(Value.QUEEN, Suit.CLUBS));
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.THREE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.KING, Suit.DIAMONDS));
        cards.add(new Card(Value.ACE, Suit.SPADES));
        cards.add(new Card(Value.TWO, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForFlush();
        assertEquals(12, list.get(0));
        assertEquals(5, list.get(1));
        assertEquals(4, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(2, list.get(4));
    }

    @Test
    void checkForFullHouse1() {
        cards.add(new Card(Value.QUEEN, Suit.CLUBS));
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.THREE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.KING, Suit.DIAMONDS));
        cards.add(new Card(Value.ACE, Suit.SPADES));
        cards.add(new Card(Value.TWO, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForFullHouse();
        assertNull(list);
    }

    @Test
    void checkForFullHouse2() {
        cards.add(new Card(Value.QUEEN, Suit.CLUBS));
        cards.add(new Card(Value.QUEEN, Suit.CLUBS));
        cards.add(new Card(Value.THREE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.DIAMONDS));
        cards.add(new Card(Value.ACE, Suit.SPADES));
        cards.add(new Card(Value.ACE, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForFullHouse();
        assertNull(list);
    }

    @Test
    void checkForFullHouse3() {
        cards.add(new Card(Value.QUEEN, Suit.CLUBS));
        cards.add(new Card(Value.QUEEN, Suit.CLUBS));
        cards.add(new Card(Value.THREE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.ACE, Suit.DIAMONDS));
        cards.add(new Card(Value.ACE, Suit.SPADES));
        cards.add(new Card(Value.ACE, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForFullHouse();
        assertEquals(14, list.get(0));
        assertEquals(12, list.get(1));
    }

    @Test
    void checkForFullHouse4() {
        cards.add(new Card(Value.QUEEN, Suit.CLUBS));
        cards.add(new Card(Value.QUEEN, Suit.CLUBS));
        cards.add(new Card(Value.KING, Suit.CLUBS));
        cards.add(new Card(Value.KING, Suit.CLUBS));
        cards.add(new Card(Value.ACE, Suit.DIAMONDS));
        cards.add(new Card(Value.ACE, Suit.SPADES));
        cards.add(new Card(Value.ACE, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForFullHouse();
        assertEquals(14, list.get(0));
        assertEquals(13, list.get(1));
    }

    @Test
    void checkForFullHouse5() {
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.QUEEN, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.EIGHT, Suit.DIAMONDS));
        cards.add(new Card(Value.ACE, Suit.SPADES));
        cards.add(new Card(Value.ACE, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForFullHouse();
        assertEquals(5, list.get(0));
        assertEquals(14, list.get(1));
    }

    @Test
    void checkForQuads1() {
        cards.add(new Card(Value.QUEEN, Suit.CLUBS));
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.THREE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.KING, Suit.DIAMONDS));
        cards.add(new Card(Value.ACE, Suit.SPADES));
        cards.add(new Card(Value.TWO, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForQuads();
        assertNull(list);
    }

    @Test
    void checkForQuads2() {
        cards.add(new Card(Value.QUEEN, Suit.CLUBS));
        cards.add(new Card(Value.QUEEN, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.QUEEN, Suit.DIAMONDS));
        cards.add(new Card(Value.FIVE, Suit.SPADES));
        cards.add(new Card(Value.TWO, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForQuads();
        assertNull(list);
    }

    @Test
    void checkForQuads3() {
        cards.add(new Card(Value.QUEEN, Suit.CLUBS));
        cards.add(new Card(Value.QUEEN, Suit.HEARTS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.QUEEN, Suit.DIAMONDS));
        cards.add(new Card(Value.QUEEN, Suit.SPADES));
        cards.add(new Card(Value.TWO, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForQuads();
        assertEquals(12, list.get(0));
        assertEquals(5, list.get(1));
    }

    @Test
    void checkForQuads4() {
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.QUEEN, Suit.HEARTS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.QUEEN, Suit.DIAMONDS));
        cards.add(new Card(Value.QUEEN, Suit.SPADES));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));

        poker = new Poker(cards);
        ArrayList<Integer> list = poker.checkForQuads();
        assertEquals(5, list.get(0));
        assertEquals(12, list.get(1));
    }

    @Test
    void checkForStraightFlush1() {
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.QUEEN, Suit.HEARTS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.QUEEN, Suit.DIAMONDS));
        cards.add(new Card(Value.QUEEN, Suit.SPADES));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));

        poker = new Poker(cards);
        Integer flush = poker.checkForStraightFlush();
        assertNull(flush);
    }

    @Test
    void checkForStraightFlush2() {
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.THREE, Suit.HEARTS));
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.SIX, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.DIAMONDS));
        cards.add(new Card(Value.SEVEN, Suit.SPADES));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));

        poker = new Poker(cards);
        Integer flush = poker.checkForStraightFlush();
        assertNull(flush);
    }

    @Test
    void checkForStraightFlush3() {
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.THREE, Suit.CLUBS));
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.SIX, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.DIAMONDS));
        cards.add(new Card(Value.SEVEN, Suit.CLUBS));
        cards.add(new Card(Value.EIGHT, Suit.CLUBS));

        poker = new Poker(cards);
        Integer flush = poker.checkForStraightFlush();
        assertEquals(8, flush);
    }

    @Test
    void checkForStraightFlush4() {
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.THREE, Suit.CLUBS));
        cards.add(new Card(Value.FOUR, Suit.CLUBS));
        cards.add(new Card(Value.SIX, Suit.CLUBS));
        cards.add(new Card(Value.NINE, Suit.DIAMONDS));
        cards.add(new Card(Value.SEVEN, Suit.CLUBS));
        cards.add(new Card(Value.EIGHT, Suit.CLUBS));

        poker = new Poker(cards);
        Integer flush = poker.checkForStraightFlush();
        assertEquals(8, flush);
    }

    @Test
    void checkForRoyalFlush1() {
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.QUEEN, Suit.HEARTS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));
        cards.add(new Card(Value.QUEEN, Suit.DIAMONDS));
        cards.add(new Card(Value.QUEEN, Suit.SPADES));
        cards.add(new Card(Value.FIVE, Suit.CLUBS));

        poker = new Poker(cards);
        Boolean bool = poker.checkForRoyalFlush();
        assertNull(bool);
    }

    @Test
    void checkForRoyalFlush2() {
        cards.add(new Card(Value.ACE, Suit.CLUBS));
        cards.add(new Card(Value.QUEEN, Suit.HEARTS));
        cards.add(new Card(Value.KING, Suit.CLUBS));
        cards.add(new Card(Value.JACK, Suit.CLUBS));
        cards.add(new Card(Value.QUEEN, Suit.DIAMONDS));
        cards.add(new Card(Value.QUEEN, Suit.SPADES));
        cards.add(new Card(Value.TEN, Suit.CLUBS));

        poker = new Poker(cards);
        Boolean bool = poker.checkForRoyalFlush();
        assertNull(bool);
    }

    @Test
    void checkForRoyalFlush3() {
        cards.add(new Card(Value.ACE, Suit.CLUBS));
        cards.add(new Card(Value.QUEEN, Suit.HEARTS));
        cards.add(new Card(Value.KING, Suit.CLUBS));
        cards.add(new Card(Value.JACK, Suit.CLUBS));
        cards.add(new Card(Value.QUEEN, Suit.DIAMONDS));
        cards.add(new Card(Value.QUEEN, Suit.CLUBS));
        cards.add(new Card(Value.TEN, Suit.CLUBS));

        poker = new Poker(cards);
        Boolean bool = poker.checkForRoyalFlush();
        assertTrue(bool);
    }

}