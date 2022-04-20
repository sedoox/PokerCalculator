package logic;

import cards.Card;

import java.util.ArrayList;

public class Hands {

    private ArrayList<ArrayList<Card>> winningBoards;
    private ArrayList<Card> hand;
    private double equity;

    public Hands(ArrayList<Card> hand) {
        this.hand = hand;
        winningBoards = new ArrayList<>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void add(ArrayList<Card> board) {
        winningBoards.add(board);
    }

    public double getEquity() {
        return equity;
    }

    public void setEquity(double equity) {
        this.equity = equity;
    }

    public String winningBoardsToString() {
        String str = "";
        for (ArrayList<Card> board : winningBoards) {
            for (Card card : board) {
                str += card.getValue().toString() + " " + card.getSuit().toString() + ", ";
            }
            str += "\n";
        }
        return str;
    }

    public ArrayList<ArrayList<Card>> getWinningBoards() {
        return winningBoards;
    }
}
