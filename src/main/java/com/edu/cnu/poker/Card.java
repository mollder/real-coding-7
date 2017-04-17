package com.edu.cnu.poker;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by dingue on 2017-04-17.
 */

@Data
public class Card {

    private int rank;
    private Suit suit;

    public Card(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;

        if(rank > 13) {
            throw new NoSuchRankException();
        }
    }

}
