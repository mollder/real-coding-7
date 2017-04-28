package com.edu.cnu.poker;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dingue on 2017-04-17.
 */
@Data
public class Hand {

    private Deck deck;
    private PokerType pokerType;
    private List<Card> cardList;
    private double HandRankPoint;

    public Hand(Deck deck, PokerType pokerType) {
        this.deck = deck;
        this.pokerType = pokerType;
        cardList = new ArrayList<Card>();
        for(int i = 0; i < pokerType.getNumberOfCard(); i++) {
            cardList.add(deck.drawCard());
        }
    }

    public int getTotalCard() {
        return cardList.size();
    }

    public Card highNumCard() {
        Card HighCard = null;
        for(Card card : cardList) {
            if(HighCard != null) {
                if(HighCard.getRank() < card.getRank())
                    HighCard = card;
            }else {
                HighCard = card;
            }
        }

        return HighCard;
    }
}
