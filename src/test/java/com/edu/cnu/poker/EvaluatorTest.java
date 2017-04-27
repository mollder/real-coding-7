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
    public void PAIR_가두개면_투페어다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(1, Suit.CLUBS),
                new Card(4, Suit.HEARTS),
                new Card(4, Suit.CLUBS),
                new Card(2, Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("TWOPAIR"));
    }
    @Test
    public void 원페어와_트리플이_동시에있으면_풀하우스다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(1, Suit.DIAMONDS),
                new Card(3, Suit.CLUBS),
                new Card(3, Suit.HEARTS),
                new Card(3, Suit.SPADES)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("FULLHOUSE"));
    }

    @Test
    public void 값이_3개가동일하면_트리플이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(7,Suit.CLUBS),
                new Card(7,Suit.DIAMONDS),
                new Card(7,Suit.HEARTS),
                new Card(8,Suit.HEARTS),
		        new Card(3,Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("TRIPLE"));
    }

    @Test
    public void 같은카드가_4개면_포카드다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(1, Suit.DIAMONDS),
                new Card(1, Suit.SPADES),
                new Card(1, Suit.HEARTS),
                new Card(3, Suit.SPADES)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("FOURCARD"));
    }

    @Test
    public void 같은_짝패의_카드5장이_연속되면_스트레이트플러시다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3, Suit.HEARTS),
                new Card(4, Suit.HEARTS),
                new Card(5, Suit.HEARTS),
                new Card(6, Suit.HEARTS),
                new Card(7, Suit.HEARTS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("STRAIGHTFLUSH"));
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
    @Test
    public void 어떤_조합도_가능하지_않으면_하이카드다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(5, Suit.CLUBS),
                new Card(13, Suit.DIAMONDS),
                new Card(1, Suit.SPADES),
                new Card(12, Suit.HEARTS),
                new Card(7, Suit.SPADES),
                new Card(6, Suit.HEARTS),
                new Card(2, Suit.SPADES)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("HIGHCARD"));
    }
}
