package equity;

import cards.Card;
import cards.Suit;
import cards.Value;
import logic.Hands;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void calculateEquity() {
    }

    @Test
    void preFlop() {
    }

    @Test
    void findWinnerOfTwoTwoPairSplit() {
        ArrayList<Card> board = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.DIAMONDS),
                new Card(Value.JACK, Suit.CLUBS),
                new Card(Value.ACE, Suit.CLUBS),
                new Card(Value.JACK, Suit.SPADES),
                new Card(Value.KING, Suit.HEARTS)
        ));
        ArrayList<Card> cards1 = new ArrayList<>(Arrays.asList(
                new Card(Value.EIGHT, Suit.CLUBS),
                new Card(Value.FIVE, Suit.HEARTS)
        ));
        ArrayList<Card> cards2 = new ArrayList<>(Arrays.asList(
                new Card(Value.EIGHT, Suit.CLUBS),
                new Card(Value.FIVE, Suit.SPADES)
        ));
        int result = calculator.findWinnerOfTwo(board, cards1, cards2);
        assertEquals(0, result);
    }

    @Test
    void findWinnerOfTwoFullHouseVsTwoPair() {
        ArrayList<Card> board = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.DIAMONDS),
                new Card(Value.JACK, Suit.CLUBS),
                new Card(Value.ACE, Suit.CLUBS),
                new Card(Value.JACK, Suit.SPADES),
                new Card(Value.KING, Suit.HEARTS)
        ));
        ArrayList<Card> cards1 = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.HEARTS),
                new Card(Value.FIVE, Suit.HEARTS)
        ));
        ArrayList<Card> cards2 = new ArrayList<>(Arrays.asList(
                new Card(Value.KING, Suit.CLUBS),
                new Card(Value.FIVE, Suit.SPADES)
        ));
        int result = calculator.findWinnerOfTwo(board, cards1, cards2);
        assertEquals(1, result);
    }

    @Test
    void findWinnerOfTwoFullHouseVsFullHouse() {
        ArrayList<Card> board = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.DIAMONDS),
                new Card(Value.JACK, Suit.CLUBS),
                new Card(Value.ACE, Suit.CLUBS),
                new Card(Value.JACK, Suit.SPADES),
                new Card(Value.KING, Suit.HEARTS)
        ));
        ArrayList<Card> cards1 = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.HEARTS),
                new Card(Value.FIVE, Suit.HEARTS)
        ));
        ArrayList<Card> cards2 = new ArrayList<>(Arrays.asList(
                new Card(Value.EIGHT, Suit.CLUBS),
                new Card(Value.JACK, Suit.DIAMONDS)
        ));
        int result = calculator.findWinnerOfTwo(board, cards1, cards2);
        assertEquals(1, result);
    }

    @Test
    void findWinnerOfTwoFlushVsTwoPair() {
        ArrayList<Card> board = new ArrayList<>(Arrays.asList(
                new Card(Value.SIX, Suit.CLUBS),
                new Card(Value.JACK, Suit.CLUBS),
                new Card(Value.ACE, Suit.CLUBS),
                new Card(Value.FIVE, Suit.CLUBS),
                new Card(Value.KING, Suit.HEARTS)
        ));
        ArrayList<Card> cards1 = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.HEARTS),
                new Card(Value.FIVE, Suit.HEARTS)
        ));
        ArrayList<Card> cards2 = new ArrayList<>(Arrays.asList(
                new Card(Value.EIGHT, Suit.CLUBS),
                new Card(Value.JACK, Suit.DIAMONDS)
        ));
        int result = calculator.findWinnerOfTwo(board, cards1, cards2);
        assertEquals(2, result);
    }

    @Test
    void findWinnerOfTwoFlushVsFlush() {
        ArrayList<Card> board = new ArrayList<>(Arrays.asList(
                new Card(Value.SIX, Suit.CLUBS),
                new Card(Value.JACK, Suit.CLUBS),
                new Card(Value.ACE, Suit.CLUBS),
                new Card(Value.FIVE, Suit.CLUBS),
                new Card(Value.KING, Suit.HEARTS)
        ));
        ArrayList<Card> cards1 = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.HEARTS),
                new Card(Value.SEVEN, Suit.CLUBS)
        ));
        ArrayList<Card> cards2 = new ArrayList<>(Arrays.asList(
                new Card(Value.EIGHT, Suit.CLUBS),
                new Card(Value.JACK, Suit.DIAMONDS)
        ));
        int result = calculator.findWinnerOfTwo(board, cards1, cards2);
        assertEquals(2, result);
    }

    @Test
    void findWinnerOfTwoFlushVsFlush2() {
        ArrayList<Card> board = new ArrayList<>(Arrays.asList(
                new Card(Value.SIX, Suit.CLUBS),
                new Card(Value.JACK, Suit.CLUBS),
                new Card(Value.ACE, Suit.CLUBS),
                new Card(Value.FIVE, Suit.CLUBS),
                new Card(Value.KING, Suit.CLUBS)
        ));
        ArrayList<Card> cards1 = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.HEARTS),
                new Card(Value.SEVEN, Suit.CLUBS)
        ));
        ArrayList<Card> cards2 = new ArrayList<>(Arrays.asList(
                new Card(Value.EIGHT, Suit.CLUBS),
                new Card(Value.JACK, Suit.DIAMONDS)
        ));
        int result = calculator.findWinnerOfTwo(board, cards1, cards2);
        assertEquals(2, result);
    }

    @Test
    void findWinnerOfTwoFlushVsFlushSplit() {
        ArrayList<Card> board = new ArrayList<>(Arrays.asList(
                new Card(Value.SIX, Suit.CLUBS),
                new Card(Value.JACK, Suit.CLUBS),
                new Card(Value.ACE, Suit.CLUBS),
                new Card(Value.FIVE, Suit.CLUBS),
                new Card(Value.KING, Suit.CLUBS)
        ));
        ArrayList<Card> cards1 = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.HEARTS),
                new Card(Value.TWO, Suit.CLUBS)
        ));
        ArrayList<Card> cards2 = new ArrayList<>(Arrays.asList(
                new Card(Value.THREE, Suit.CLUBS),
                new Card(Value.JACK, Suit.DIAMONDS)
        ));
        int result = calculator.findWinnerOfTwo(board, cards1, cards2);
        assertEquals(0, result);
    }

    @Test
    void findWinnerOfTwoStraightVsStraight() {
        ArrayList<Card> board = new ArrayList<>(Arrays.asList(
                new Card(Value.SIX, Suit.SPADES),
                new Card(Value.JACK, Suit.DIAMONDS),
                new Card(Value.FOUR, Suit.DIAMONDS),
                new Card(Value.FIVE, Suit.CLUBS),
                new Card(Value.THREE, Suit.HEARTS)
        ));
        ArrayList<Card> cards1 = new ArrayList<>(Arrays.asList(
                new Card(Value.SEVEN, Suit.HEARTS),
                new Card(Value.EIGHT, Suit.CLUBS)
        ));
        ArrayList<Card> cards2 = new ArrayList<>(Arrays.asList(
                new Card(Value.SEVEN, Suit.CLUBS),
                new Card(Value.JACK, Suit.SPADES)
        ));
        int result = calculator.findWinnerOfTwo(board, cards1, cards2);
        assertEquals(1, result);
    }

    @Test
    void findWinnerOfTwoStraightVsStraightSplit() {
        ArrayList<Card> board = new ArrayList<>(Arrays.asList(
                new Card(Value.SIX, Suit.SPADES),
                new Card(Value.JACK, Suit.DIAMONDS),
                new Card(Value.FOUR, Suit.DIAMONDS),
                new Card(Value.FIVE, Suit.CLUBS),
                new Card(Value.THREE, Suit.HEARTS)
        ));
        ArrayList<Card> cards1 = new ArrayList<>(Arrays.asList(
                new Card(Value.SEVEN, Suit.HEARTS),
                new Card(Value.EIGHT, Suit.CLUBS)
        ));
        ArrayList<Card> cards2 = new ArrayList<>(Arrays.asList(
                new Card(Value.SEVEN, Suit.CLUBS),
                new Card(Value.EIGHT, Suit.SPADES)
        ));
        int result = calculator.findWinnerOfTwo(board, cards1, cards2);
        assertEquals(0, result);
    }

    @Test
    void findWinnerOfTwoStraightVsFlush() {
        ArrayList<Card> board = new ArrayList<>(Arrays.asList(
                new Card(Value.SIX, Suit.SPADES),
                new Card(Value.JACK, Suit.DIAMONDS),
                new Card(Value.FOUR, Suit.DIAMONDS),
                new Card(Value.FIVE, Suit.DIAMONDS),
                new Card(Value.THREE, Suit.HEARTS)
        ));
        ArrayList<Card> cards1 = new ArrayList<>(Arrays.asList(
                new Card(Value.SEVEN, Suit.HEARTS),
                new Card(Value.EIGHT, Suit.CLUBS)
        ));
        ArrayList<Card> cards2 = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.DIAMONDS),
                new Card(Value.KING, Suit.DIAMONDS)
        ));
        int result = calculator.findWinnerOfTwo(board, cards1, cards2);
        assertEquals(2, result);
    }

    @Test
    void findWinnerOfTwoTwoPairVsTwoPair1() {
        ArrayList<Card> board = new ArrayList<>(Arrays.asList(
                new Card(Value.SIX, Suit.SPADES),
                new Card(Value.JACK, Suit.SPADES),
                new Card(Value.FOUR, Suit.CLUBS),
                new Card(Value.FIVE, Suit.DIAMONDS),
                new Card(Value.THREE, Suit.HEARTS)
        ));
        ArrayList<Card> cards1 = new ArrayList<>(Arrays.asList(
                new Card(Value.FOUR, Suit.HEARTS),
                new Card(Value.FIVE, Suit.CLUBS)
        ));
        ArrayList<Card> cards2 = new ArrayList<>(Arrays.asList(
                new Card(Value.THREE, Suit.DIAMONDS),
                new Card(Value.JACK, Suit.DIAMONDS)
        ));
        int result = calculator.findWinnerOfTwo(board, cards1, cards2);
        assertEquals(2, result);
    }

    @Test
    void findWinnerOfTwoTwoPairVsTwoPairSplit2() {
        ArrayList<Card> board = new ArrayList<>(Arrays.asList(
                new Card(Value.SIX, Suit.SPADES),
                new Card(Value.JACK, Suit.SPADES),
                new Card(Value.FOUR, Suit.CLUBS),
                new Card(Value.FIVE, Suit.DIAMONDS),
                new Card(Value.THREE, Suit.HEARTS)
        ));
        ArrayList<Card> cards1 = new ArrayList<>(Arrays.asList(
                new Card(Value.FOUR, Suit.HEARTS),
                new Card(Value.FIVE, Suit.CLUBS)
        ));
        ArrayList<Card> cards2 = new ArrayList<>(Arrays.asList(
                new Card(Value.FOUR, Suit.DIAMONDS),
                new Card(Value.FIVE, Suit.HEARTS)
        ));
        int result = calculator.findWinnerOfTwo(board, cards1, cards2);
        assertEquals(0, result);
    }

    @Test
    void findWinnerOfTwoTwoPairVsTwoPairSplit() {
        ArrayList<Card> board = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.SPADES),
                new Card(Value.FIVE, Suit.SPADES),
                new Card(Value.FOUR, Suit.CLUBS),
                new Card(Value.FIVE, Suit.DIAMONDS),
                new Card(Value.FOUR, Suit.HEARTS)
        ));
        ArrayList<Card> cards1 = new ArrayList<>(Arrays.asList(
                new Card(Value.TWO, Suit.HEARTS),
                new Card(Value.TEN, Suit.CLUBS)
        ));
        ArrayList<Card> cards2 = new ArrayList<>(Arrays.asList(
                new Card(Value.EIGHT, Suit.DIAMONDS),
                new Card(Value.TEN, Suit.DIAMONDS)
        ));
        int result = calculator.findWinnerOfTwo(board, cards1, cards2);
        assertEquals(0, result);
    }

    @Test
    void findWinnerOfTwoPairVsStraight() {
        ArrayList<Card> board = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.SPADES),
                new Card(Value.EIGHT, Suit.SPADES),
                new Card(Value.FOUR, Suit.CLUBS),
                new Card(Value.THREE, Suit.DIAMONDS),
                new Card(Value.FIVE, Suit.CLUBS)
        ));
        ArrayList<Card> cards1 = new ArrayList<>(Arrays.asList(
                new Card(Value.FIVE, Suit.HEARTS),
                new Card(Value.EIGHT, Suit.CLUBS)
        ));
        ArrayList<Card> cards2 = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.DIAMONDS),
                new Card(Value.TEN, Suit.DIAMONDS)
        ));
        int result = calculator.findWinnerOfTwo(board, cards1, cards2);
        assertEquals(1, result);
    }

    @Test
    void findWinnerOfTwoPairVsPair() {
        ArrayList<Card> board = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.SPADES),
                new Card(Value.EIGHT, Suit.SPADES),
                new Card(Value.FOUR, Suit.CLUBS),
                new Card(Value.THREE, Suit.DIAMONDS),
                new Card(Value.SEVEN, Suit.HEARTS)
        ));
        ArrayList<Card> cards1 = new ArrayList<>(Arrays.asList(
                new Card(Value.FIVE, Suit.HEARTS),
                new Card(Value.EIGHT, Suit.CLUBS)
        ));
        ArrayList<Card> cards2 = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.DIAMONDS),
                new Card(Value.TEN, Suit.DIAMONDS)
        ));
        int result = calculator.findWinnerOfTwo(board, cards1, cards2);
        assertEquals(2, result);
    }

    @Test
    void calculateEquityRiver1() {
        ArrayList<Card> board = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.SPADES),
                new Card(Value.EIGHT, Suit.SPADES),
                new Card(Value.FOUR, Suit.CLUBS),
                new Card(Value.THREE, Suit.DIAMONDS)
        ));
        ArrayList<Card> cards1 = new ArrayList<>(Arrays.asList(
                new Card(Value.FIVE, Suit.HEARTS),
                new Card(Value.EIGHT, Suit.CLUBS)
        ));
        ArrayList<Card> cards2 = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.DIAMONDS),
                new Card(Value.TEN, Suit.DIAMONDS)
        ));
        ArrayList<Double> result = calculator.calculateEquityRiver(board, cards1, cards2);
        assertEquals(20.45, result.get(0));
        assertEquals(79.55, result.get(1));
    }

    @Test
    void calculateEquityRiver2() {
        ArrayList<Card> board = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.SPADES),
                new Card(Value.ACE, Suit.CLUBS),
                new Card(Value.SIX, Suit.CLUBS),
                new Card(Value.FIVE, Suit.SPADES)
        ));
        ArrayList<Card> cards1 = new ArrayList<>(Arrays.asList(
                new Card(Value.JACK, Suit.CLUBS),
                new Card(Value.FIVE, Suit.CLUBS)
        ));
        ArrayList<Card> cards2 = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.DIAMONDS),
                new Card(Value.TEN, Suit.DIAMONDS)
        ));
        ArrayList<Double> result = calculator.calculateEquityRiver(board, cards1, cards2);
        assertEquals(18.18, result.get(0));
        assertEquals(81.82, result.get(1));
    }

    @Test
    void calculateEquityTurn1() {
        ArrayList<Card> board = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.SPADES),
                new Card(Value.ACE, Suit.CLUBS),
                new Card(Value.SIX, Suit.CLUBS)
        ));
        ArrayList<Card> cards1 = new ArrayList<>(Arrays.asList(
                new Card(Value.JACK, Suit.CLUBS),
                new Card(Value.FIVE, Suit.CLUBS)
        ));
        ArrayList<Card> cards2 = new ArrayList<>(Arrays.asList(
                new Card(Value.ACE, Suit.DIAMONDS),
                new Card(Value.TEN, Suit.DIAMONDS)
        ));
        ArrayList<Hands> result = calculator.calculateEquityTurn(board, cards1, cards2);
        System.out.println(result.get(0).winningBoardsToString());
        System.out.println(result.get(0).getWinningBoards().size());
    }
}