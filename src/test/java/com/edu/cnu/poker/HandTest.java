package com.edu.cnu.poker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by dingue on 2017-04-17.
 */
public class HandTest {
    @Test
    public void 세븐카드_핸드_카드숫자는_7() {
        Deck deck = new Deck(1);
        Hand hand = new Hand(deck, PokerType.SEVEN);
        assertThat(hand.getTotalCard(), is(7));
    }
}
