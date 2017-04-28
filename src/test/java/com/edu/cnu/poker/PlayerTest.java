package com.edu.cnu.poker;

/**
 * Created by dingue on 2017-04-28.
 */
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerTest {

    @Test
    public void 플레이어는_초기돈으로_만원을_가진다(){
        Player player = new Player();
        assertThat(player.getMoney(), is(10000));
    }
}