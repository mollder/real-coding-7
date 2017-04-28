package com.edu.cnu.poker;

/**
 * Created by dingue on 2017-04-22.
 */
public enum HandsRank {
    HIGHCARD(0),
    ONEPAIR(1),
    TWOPAIR(2),
    TRIPLE(3),
    STRAIGHT(4),
    FLUSH(5),
    FULLHOUSE(6),
    FOURCARD(7),
    STRAIGHTFLUSH(8);

    private double handsRank;

    HandsRank(double handsRank) {
        this.handsRank = handsRank;
    }

    public double getHandsRank() {
        return this.handsRank;
    }

    public void setNumRank(Card HighNumCard) {
        double temp = (double)HighNumCard.getRank() / 100;
        if(HighNumCard.getSuit().equals(Suit.CLUBS)) temp = temp + 0.0001;
        else if(HighNumCard.getSuit().equals(Suit.HEARTS)) temp = temp + 0.0002;
        else if(HighNumCard.getSuit().equals(Suit.DIAMONDS)) temp = temp + 0.0003;
        else temp = temp + 0.0004;
        handsRank += temp;
    }
}