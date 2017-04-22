package com.edu.cnu.poker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dingue on 2017-04-17.
 */
public class Evaluator {

    public String evaluate(List<Card> cardList) {
        if (isFLUSH(cardList)) return "FLUSH";

        if(isFULLHOUSE(cardList)) return "FULLHOUSE";

        return "NOTHING";
    }

    public boolean isFLUSH(List<Card> cardList) {
        Map<Suit, Integer> tempMap = new HashMap<Suit, Integer>();

        for(Card card : cardList) {
            if (tempMap.containsKey(card.getSuit())) {
                Integer count = tempMap.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getSuit(), count);
            } else {
                tempMap.put(card.getSuit(), new Integer(1));
            }
        }

        for ( Suit key : tempMap.keySet()) {
            if (tempMap.get(key) == 5) {
                return true;
            }
        }
        return false;
    }

    public boolean isFULLHOUSE(List<Card> cardList) {
        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
        boolean isFullHouse = false;

        for(Card card : cardList) {
            if (tempMap.containsKey(card.getRank())) {
                Integer count = tempMap.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getRank(), count);
            } else {
                tempMap.put(card.getRank(), new Integer(1));
            }
        }

        for ( Integer key : tempMap.keySet()) {
            if (tempMap.get(key) == 2 ) {
                isFullHouse = true;
            }else if(tempMap.get(key) == 3 ) {
                isFullHouse = true;
            }else {
                isFullHouse = false;
            }
        }
        return isFullHouse;
    }


}
