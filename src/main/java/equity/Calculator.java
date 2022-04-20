package equity;

import cards.Card;
import cards.Suit;
import cards.Value;
import logic.Hands;
import logic.Poker;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {

    private ArrayList<Card> allCards = new ArrayList<>(Arrays.asList(
            new Card(Value.ACE, Suit.CLUBS), new Card(Value.KING, Suit.CLUBS), new Card(Value.QUEEN, Suit.CLUBS), new Card(Value.JACK, Suit.CLUBS), new Card(Value.TEN, Suit.CLUBS), new Card(Value.NINE, Suit.CLUBS), new Card(Value.EIGHT, Suit.CLUBS), new Card(Value.SEVEN, Suit.CLUBS), new Card(Value.SIX, Suit.CLUBS), new Card(Value.FIVE, Suit.CLUBS), new Card(Value.FOUR, Suit.CLUBS), new Card(Value.THREE, Suit.CLUBS), new Card(Value.TWO, Suit.CLUBS),
            new Card(Value.ACE, Suit.SPADES), new Card(Value.KING, Suit.SPADES), new Card(Value.QUEEN, Suit.SPADES), new Card(Value.JACK, Suit.SPADES), new Card(Value.TEN, Suit.SPADES), new Card(Value.NINE, Suit.SPADES), new Card(Value.EIGHT, Suit.SPADES), new Card(Value.SEVEN, Suit.SPADES), new Card(Value.SIX, Suit.SPADES), new Card(Value.FIVE, Suit.SPADES), new Card(Value.FOUR, Suit.SPADES), new Card(Value.THREE, Suit.SPADES), new Card(Value.TWO, Suit.SPADES),
            new Card(Value.ACE, Suit.HEARTS), new Card(Value.KING, Suit.HEARTS), new Card(Value.QUEEN, Suit.HEARTS), new Card(Value.JACK, Suit.HEARTS), new Card(Value.TEN, Suit.HEARTS), new Card(Value.NINE, Suit.HEARTS), new Card(Value.EIGHT, Suit.HEARTS), new Card(Value.SEVEN, Suit.HEARTS), new Card(Value.SIX, Suit.HEARTS), new Card(Value.FIVE, Suit.HEARTS), new Card(Value.FOUR, Suit.HEARTS), new Card(Value.THREE, Suit.HEARTS), new Card(Value.TWO, Suit.HEARTS),
            new Card(Value.ACE, Suit.DIAMONDS), new Card(Value.KING, Suit.DIAMONDS), new Card(Value.QUEEN, Suit.DIAMONDS), new Card(Value.JACK, Suit.DIAMONDS), new Card(Value.TEN, Suit.DIAMONDS), new Card(Value.NINE, Suit.DIAMONDS), new Card(Value.EIGHT, Suit.DIAMONDS), new Card(Value.SEVEN, Suit.DIAMONDS), new Card(Value.SIX, Suit.DIAMONDS), new Card(Value.FIVE, Suit.DIAMONDS), new Card(Value.FOUR, Suit.DIAMONDS), new Card(Value.THREE, Suit.DIAMONDS), new Card(Value.TWO, Suit.DIAMONDS)
    ));


    public float calculateEquity() {

        return 0F;
    }

    public ArrayList<Hands> calculateEquityTurn(ArrayList<Card> board, ArrayList<Card> playerHand1, ArrayList<Card> playerHand2) {
        Hands winningHands1 = new Hands(playerHand1);
        Hands winningHands2 = new Hands(playerHand2);
        allCards.removeAll(board);
        allCards.removeAll(playerHand1);
        allCards.removeAll(playerHand2);
        ArrayList<Card> fullBoard;
        int count = 0;
        int winRate1 = 0;
        int winRate2 = 0;
        for (Card card1 : allCards) {
            for (Card card2 : allCards) {
                if (card2 == card1)
                    continue;
                fullBoard = new ArrayList<>(board);
                fullBoard.add(card1);
                fullBoard.add(card2);
                int winner = findWinnerOfTwo(fullBoard, playerHand1, playerHand2);
                if (winner == 1) {
                    winningHands1.add(fullBoard);
                    winRate1++;
                } else if (winner == 2) {
                    winningHands2.add(fullBoard);
                    winRate2++;
                }
                count++;
            }
        }
        System.out.println("Count:" + count);
        double f1 = (double) winRate1/count;
        double f2 = (double) winRate2/count;
        double r1 = Math.round(f1*10000.0)/100.0;
        double r2 = Math.round(f2*10000.0)/100.0;
        winningHands1.setEquity(r1);
        winningHands2.setEquity(r2);
        return new ArrayList<>(Arrays.asList(winningHands1, winningHands2));
    }

    public ArrayList<Double> calculateEquityRiver(ArrayList<Card> board, ArrayList<Card> playerHand1, ArrayList<Card> playerHand2) {
        allCards.removeAll(board);
        allCards.removeAll(playerHand1);
        allCards.removeAll(playerHand2);
        ArrayList<Card> fullBoard;
        int count = 0;
        int winRate1 = 0;
        int winRate2 = 0;
        for (Card card : allCards) {
            fullBoard = new ArrayList<>(board);
            fullBoard.add(card);
            int winner = findWinnerOfTwo(fullBoard, playerHand1, playerHand2);
            if (winner == 1)
                winRate1++;
            else if (winner == 2)
                winRate2++;
            count++;
        }
        double f1 = (double) winRate1/count;
        double f2 = (double) winRate2/count;
        double r1 = Math.round(f1*10000.0)/100.0;
        double r2 = Math.round(f2*10000.0)/100.0;
        return new ArrayList<>(Arrays.asList(r1, r2));
    }

    // 7 cards
    public int findWinnerOfTwo(ArrayList<Card> board, ArrayList<Card> playerHand1, ArrayList<Card> playerHand2) {


        Poker poker1 = new Poker(new ArrayList<>(Stream.of(board, playerHand1).flatMap(Collection::stream).collect(Collectors.toList())));
        Poker poker2 = new Poker(new ArrayList<>(Stream.of(board, playerHand2).flatMap(Collection::stream).collect(Collectors.toList())));
        Integer result1;
        Integer result2;
        ArrayList<Integer> list1;
        ArrayList<Integer> list2;

        if (poker1.checkForRoyalFlush() != null && poker2.checkForRoyalFlush() != null)
            return 0;
        else if (poker1.checkForRoyalFlush() != null)
            return 1;
        else if (poker2.checkForRoyalFlush() != null)
            return 2;

        result1 = poker1.checkForStraightFlush();
        result2 = poker2.checkForStraightFlush();

        if (result1 != null && result2 != null) {
            if (result1 == result2)
                return 0;
            return result1 > result2 ? 1 : 2;
        } else if (result1 != null)
            return 1;
        else if (result2 != null)
            return 2;

        list1 = poker1.checkForQuads();
        list2 = poker2.checkForQuads();

        if (list1 != null && list2 != null) {
            if (list2.containsAll(list1))
                return 0;
            if (list1.get(0) == list2.get(0))
                return list1.get(1) > list2.get(1) ? 1 : 2;
            else
                return list1.get(0) > list2.get(0) ? 1 : 2;
        } else if (list1 != null)
            return 1;
        else if (list2 != null)
            return 2;

        list1 = poker1.checkForFullHouse();
        list2 = poker2.checkForFullHouse();

        if (list1 != null && list2 != null) {
            for (int i = 0; i < 2; i++) {
                if (list1.get(i) > list2.get(i))
                    return 1;
                else if (list1.get(i) < list2.get(i))
                    return 2;
            }
            return 0;
        } else if (list1 != null)
            return 1;
        else if (list2 != null)
            return 2;

        list1 = poker1.checkForFlush();
        list2 = poker2.checkForFlush();

        if (list1 != null && list2 != null) {
            for (int i = 0; i < 5; i++) {
                if (list1.get(i) > list2.get(i))
                    return 1;
                else if (list1.get(i) < list2.get(i))
                    return 2;
            }
            return 0;
        } else if (list1 != null)
            return 1;
        else if (list2 != null)
            return 2;

        result1 = poker1.checkForStraight();
        result2 = poker2.checkForStraight();

        if (result1 != null && result2 != null) {
            if (result1 > result2)
                return 1;
            else if (result1 < result2)
                return 2;
            else
                return 0;
        } else if (result1 != null)
            return 1;
        else if (result2 != null)
            return 2;

        list1 = poker1.checkForSet();
        list2 = poker2.checkForSet();

        if (list1 != null && list2 != null) {
            for (int i = 0; i < 3; i++) {
                if (list1.get(i) > list2.get(i))
                    return 1;
                else if (list1.get(i) < list2.get(i))
                    return 2;
            }
            return 0;
        } else if (list1 != null)
            return 1;
        else if (list2 != null)
            return 2;

        list1 = poker1.checkForTwoPair();
        list2 = poker2.checkForTwoPair();

        if (list1 != null && list2 != null) {
            for (int i = 0; i < 3; i++) {
                if (list1.get(i) > list2.get(i))
                    return 1;
                else if (list1.get(i) < list2.get(i))
                    return 2;
            }
            return 0;
        } else if (list1 != null)
            return 1;
        else if (list2 != null)
            return 2;

        list1 = poker1.checkForPair();
        list2 = poker2.checkForPair();

        if (list1 != null && list2 != null) {
            for (int i = 0; i < 4; i++) {
                if (list1.get(i) > list2.get(i))
                    return 1;
                else if (list1.get(i) < list2.get(i))
                    return 2;
            }
            return 0;
        } else if (list1 != null)
            return 1;
        else if (list2 != null)
            return 2;

        list1 = poker1.checkForHigh();
        list2 = poker2.checkForHigh();

        for (int i = 0; i < 5; i++) {
            if (list1.get(i) > list2.get(i))
                return 1;
            else if (list1.get(i) < list2.get(i))
                return 2;
        }

        return 0;

    }
}
