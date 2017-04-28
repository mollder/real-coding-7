package com.edu.cnu.poker;

import lombok.Data;

/**
 * Created by dingue on 2017-04-28.
 */
@Data
public class Player {
    private Hand playerHand;
    private int money;

    public Player() {
        money = 10000;
    }
}
