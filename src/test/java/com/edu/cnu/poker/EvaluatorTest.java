package com.edu.cnu.poker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by dingue on 2017-04-17.
 */
public class EvaluatorTest {
    @Test
    public void SUIT가_5개가동일하면_플러쉬다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(4, Suit.CLUBS),
                new Card(8, Suit.CLUBS),
                new Card(13, Suit.CLUBS),
                new Card(2, Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("FLUSH"));
    }

    @Test
    public void 랭크가_2개가동일한_1개있으면_원페어다() {
        {
            Evaluator evaluator = new Evaluator();
            List<Card> cardList = Arrays.asList(
                    new Card(1, Suit.CLUBS),
                    new Card(1, Suit.SPADES)
            );
            String result = evaluator.evaluate(cardList);
            assertThat(result, is("ONEPAIR"));
        }
    }
}
