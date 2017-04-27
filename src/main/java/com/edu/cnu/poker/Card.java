package com.edu.cnu.poker;

import lombok.Data;

/**
 * Created by dingue on 2017-04-17.
 */

@Data
public class Card implements Comparable<Card>{

    private int rank;
    private Suit suit;

    public Card(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;

        if(rank > 13) {
        throw new NoSuchRankException();
    }
}

    public int compareTo(Card o) {
        return this.getRank() - o.getRank();
    }
}
