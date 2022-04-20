package logic;

import cards.Card;
import cards.Suit;
import cards.Value;

import java.util.*;
import java.util.stream.Collectors;

public class Poker {

    private ArrayList<ArrayList<Integer>> straights;
    private ArrayList<ArrayList<Card>> royalFlushes;

    // size = 7 | board = 5, hand = 2
    private ArrayList<Card> cards;

    public Poker(ArrayList<Card> cards) {
        setUp();
        Collections.sort(cards);
        this.cards = cards;
    }

    private void setUp() {
        straights = new ArrayList<>();
        straights.add(new ArrayList<>(Arrays.asList(14, 13, 12, 11, 10)));
        straights.add(new ArrayList<>(Arrays.asList(13, 12, 11, 10, 9)));
        straights.add(new ArrayList<>(Arrays.asList(12, 11, 10, 9, 8)));
        straights.add(new ArrayList<>(Arrays.asList(11, 10, 9, 8, 7)));
        straights.add(new ArrayList<>(Arrays.asList(10, 9, 8, 7, 6)));
        straights.add(new ArrayList<>(Arrays.asList(9, 8, 7, 6, 5)));
        straights.add(new ArrayList<>(Arrays.asList(8, 7, 6, 5, 4)));
        straights.add(new ArrayList<>(Arrays.asList(7, 6, 5, 4, 3)));
        straights.add(new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2)));
        straights.add(new ArrayList<>(Arrays.asList(5, 4, 3, 2, 14)));

        royalFlushes = new ArrayList<>();
        royalFlushes.add(new ArrayList<Card>(Arrays.asList(new Card(Value.ACE, Suit.CLUBS), new Card(Value.KING, Suit.CLUBS), new Card(Value.QUEEN, Suit.CLUBS), new Card(Value.JACK, Suit.CLUBS), new Card(Value.TEN, Suit.CLUBS))));
        royalFlushes.add(new ArrayList<Card>(Arrays.asList(new Card(Value.ACE, Suit.DIAMONDS), new Card(Value.KING, Suit.DIAMONDS), new Card(Value.QUEEN, Suit.DIAMONDS), new Card(Value.JACK, Suit.DIAMONDS), new Card(Value.TEN, Suit.DIAMONDS))));
        royalFlushes.add(new ArrayList<Card>(Arrays.asList(new Card(Value.ACE, Suit.HEARTS), new Card(Value.KING, Suit.HEARTS), new Card(Value.QUEEN, Suit.HEARTS), new Card(Value.JACK, Suit.CLUBS), new Card(Value.TEN, Suit.HEARTS))));
        royalFlushes.add(new ArrayList<Card>(Arrays.asList(new Card(Value.ACE, Suit.SPADES), new Card(Value.KING, Suit.SPADES), new Card(Value.QUEEN, Suit.SPADES), new Card(Value.JACK, Suit.SPADES), new Card(Value.TEN, Suit.SPADES))));
    }


    public ArrayList<Integer> checkForHigh() {
        ArrayList<Integer> localCards = new ArrayList<>(cards.stream().map(Card::getNumber).collect(Collectors.toList()));
        localCards.remove(localCards.size() - 1);
        localCards.remove(localCards.size() - 1);
        return localCards;
    }

    public ArrayList<Integer> checkForPair() {
        List<Integer> localCards = cards.stream().map(Card::getNumber).collect(Collectors.toList());
        Set<Integer> distinct = new HashSet<>(localCards);
        ArrayList<Integer> result = new ArrayList<>();

        for (Integer i : distinct) {
            if (Collections.frequency(localCards, i) > 1) {
                result.add(i);
                break;
            }
        }

        if (result.size() == 0)
            return null;

        localCards.removeAll(result);
        result.add(localCards.get(0));
        result.add(localCards.get(1));
        result.add(localCards.get(2));
        return result;
    }

    public ArrayList<Integer> checkForTwoPair() {
        List<Integer> localCards = cards.stream().map(Card::getNumber).collect(Collectors.toList());
        Set<Integer> distinct = new HashSet<>(localCards);
        ArrayList<Integer> result = new ArrayList<>();

        for (Integer i : distinct) {
            if (Collections.frequency(localCards, i) > 1) {
                result.add(i);
            }
        }

        if (result.size() != 2)
            return null;

        Collections.sort(result, Collections.reverseOrder());
        localCards.removeAll(result);
        result.add(localCards.get(0));
        return result;
    }

    public ArrayList<Integer> checkForSet() {
        List<Integer> localCards = cards.stream().map(Card::getNumber).collect(Collectors.toList());
        Set<Integer> distinct = new HashSet<>(localCards);
        ArrayList<Integer> result = new ArrayList<>();

        for (Integer i : distinct.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())) {
            if (Collections.frequency(localCards, i) > 2) {
                result.add(i);
                break;
            }
        }

        if (result.size() != 0) {
            if (localCards.get(0) == result.get(0)) {
                result.add(localCards.get(3));
                result.add(localCards.get(4));
            } else {
                result.add(localCards.get(0));
                if (localCards.get(1) == result.get(0))
                    result.add(localCards.get(4));
                else
                    result.add(localCards.get(1));
            }
            return result;
        }
        return null;
    }

    public Integer checkForStraight() {
        List<Integer> localCards = new ArrayList<>(cards).stream().map(Card::getNumber).collect(Collectors.toList());

        for (ArrayList<Integer> straight : straights) {
            if (straight.stream().allMatch(card -> localCards.contains(card)))
                return straight.get(0);
        }
        return null;
    }

    public Integer checkForStraight(ArrayList<Card> cardRange) {
        for (ArrayList<Integer> straight : straights) {
            List<Integer> localCards = new ArrayList<>(cardRange).stream().map(Card::getNumber).collect(Collectors.toList());
            if (straight.stream().allMatch(card -> localCards.contains(card)))
                return straight.get(0);
        }
        return null;
    }

    public ArrayList<Integer> checkForFlush() {
        ArrayList<Integer> result = new ArrayList<>();
        int totalCount = 0;
        for (Suit suit : Suit.values()) {
            result.clear();
            for (Card card : cards) {
                if (card.getSuit() == suit) {
                    result.add(card.getNumber());
                }
            }
            totalCount += result.size();
            if (result.size() >= 5) {
                Collections.sort(result, Collections.reverseOrder());
                return result;
            } else if (totalCount > 2)
                return null;
        }
        return null;
    }

    private ArrayList<Card> checkForFlush2() {
        ArrayList<Card> result = new ArrayList<>();
        int totalCount = 0;
        for (Suit suit : Suit.values()) {
            result.clear();
            for (Card card : cards) {
                if (card.getSuit() == suit) {
                    result.add(card);
                }
            }
            totalCount += result.size();
            if (result.size() >= 5) {
                Collections.sort(result, Collections.reverseOrder());
                return result;
            } else if (totalCount > 2)
                return null;
        }
        return null;
    }

    public ArrayList<Integer> checkForFullHouse() {
        ArrayList<Integer> set = checkForSet();

        if (set == null)
            return null;

        ArrayList<Integer> localCards = new ArrayList<>(cards.stream().map(Card::getNumber).collect(Collectors.toList()));
        localCards = new ArrayList<>(localCards.stream().filter(card -> card != set.get(0)).collect(Collectors.toList()));

        Set<Integer> distinct = new HashSet<>(localCards);
        ArrayList<Integer> pairs = new ArrayList<>();

        for (Integer i : distinct) {
            if (Collections.frequency(localCards, i) > 2) {
                pairs.add(i);
            }
        }
        Collections.sort(pairs, Collections.reverseOrder());

        if (pairs.size() == 0)
            return null;

        return new ArrayList<>(Arrays.asList(set.get(0), pairs.get(0)));
    }

    public ArrayList<Integer> checkForQuads() {
        List<Integer> localCards = cards.stream().map(Card::getNumber).collect(Collectors.toList());
        Set<Integer> distinct = new HashSet<>(localCards);
        ArrayList<Integer> result = new ArrayList<>();

        for (Integer i : distinct) {
            if (Collections.frequency(localCards, i) > 3) {
                result.add(i);
                break;
            }
        }

        if (result.size() != 0) {
            if (localCards.get(0) == result.get(0))
                result.add(localCards.get(4));
            else
                result.add(localCards.get(0));
            return result;
        }
        return null;
    }

    public Integer checkForStraightFlush() {
        ArrayList<Card> flush = checkForFlush2();
        if (flush != null) {
            ArrayList<Card> sameSuitCards = new ArrayList<>(cards.stream().filter(card -> card.getSuit() == flush.get(0).getSuit()).collect(Collectors.toList()));
            Integer straight = checkForStraight(sameSuitCards);
            return straight != null ? straight : null;
        }
        return null;
    }

    public Boolean checkForRoyalFlush() {
        ArrayList<Card> localCards = new ArrayList<>(cards);
        for (ArrayList<Card> royalFlush : royalFlushes) {
            if (royalFlush.stream().allMatch(card -> localCards.contains(card))) {
                return true;
            }
        }
        return null;
    }
}