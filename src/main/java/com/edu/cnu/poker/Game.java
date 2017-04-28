package com.edu.cnu.poker;

import java.util.Scanner;

/**
 * Created by dingue on 2017-04-28.
 */
public class Game {

    private Deck deck;
    private Player player;
    private Player computerPlayer;
    private PokerType gameType;
    private Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
        deck = new Deck(1);
        settingGameAndPlayer();
    }

    private void settingGameAndPlayer() {
        System.out.print("포커타입을 입력하세요 : ");
        if(scanner.nextInt() == 5)
            gameType = PokerType.FIVE;
        else
            gameType = PokerType.SEVEN;

        player = new Player();
        computerPlayer = new Player();
    }

    public void playGame() {
        System.out.println("게임을 시작합니다.");

        int menu = 0;
        HandsRank playerHandsRank = null;
        HandsRank computerHandsRank = null;
        int bettingMoney = 0;

        while(menu != 1) {
            if(deck.getTotalCard() < gameType.getNumberOfCard() * 2) {
                System.out.println("카드가 떨어졌으므로 게임을 종료합니다.");
                break;
            }
            System.out.println("플레이어의 돈 상태 "+player.getMoney());
            playerHandDrawAndSettingRank(playerHandsRank, computerHandsRank);
            showHand(player);
        }

        printEndPlayerState();
    }

    public void playerHandDrawAndSettingRank(HandsRank playerHandsRank, HandsRank computerHandsRank) {
        Evaluator evaluator = new Evaluator();
        Hand playerHand = new Hand(deck, gameType);
        Hand computerHand = new Hand(deck, gameType);

        settingRank(evaluator, playerHand);
        player.setPlayerHand(playerHand);

        settingRank(evaluator, computerHand);
        computerPlayer.setPlayerHand(computerHand);
    }

    private void settingRank(Evaluator evaluator, Hand playerHand) {
        HandsRank playerHandsRank;
        playerHandsRank = evaluator.evaluate(playerHand.getCardList());
        playerHandsRank.setNumRank(playerHand.highNumCard());
        playerHand.setHandRankPoint(playerHandsRank.getHandsRank());
    }

    public void showHand(Player player) {
        int num = 1;
        System.out.println("패 보유 상황");
        for(Card card : player.getPlayerHand().getCardList()) {
            System.out.println(num+". 문양 : "+card.getSuit()+" 숫자"+card.getRank());
        }
    }

    public void printEndPlayerState() {

    }
}