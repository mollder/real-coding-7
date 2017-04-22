package com.edu.cnu.poker;

import com.sun.deploy.nativesandbox.NativeSandboxBroker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dingue on 2017-04-17.
 */
public class Evaluator {

    public String evaluate(List<Card> cardList) {

        if (isFLUSH(cardList)) return "FLUSH";
        if (isTRIPLE(cardList)) return "TRIPLE";


        return "NOTHING";
    }

    private boolean isTRIPLE(List<Card> cardList) {
        Map<Integer,Integer> tempMap = new HashMap<Integer, Integer>();

        for(Card card : cardList) {
                if (tempMap.containsKey(card.getRank())) {
                Integer count = tempMap.get(card.getRank());
                tempMap.put(card.getRank(),count+1);
            } else {
                tempMap.put(card.getRank(), new Integer(1));
            }
        }

        for(Integer key : tempMap.keySet()){
            if(tempMap.get(key) == 3){
                return true;
            }
        }
        return false;
    }

    private boolean isFLUSH(List<Card> cardList) {
        Map<Suit, Integer> tempMap = new HashMap<Suit, Integer>();

        for(Card card : cardList) {
            if (tempMap.containsKey(card.getSuit())) {
                Integer count = tempMap.get(card.getSuit());
                tempMap.put(card.getSuit(), count+1);
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
}
