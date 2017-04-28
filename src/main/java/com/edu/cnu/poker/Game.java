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

        int menu = 1;

        Evaluator evaluator = new Evaluator();

        while(menu == 1) {
            if(deck.getTotalCard() < gameType.getNumberOfCard() * 2) {
                System.out.println("카드가 떨어졌으므로 게임을 종료합니다.");
                break;
            }
            printPlayerState();
            playerHandDraw();

            settingRank(evaluator,player);
            settingRank(evaluator,computerPlayer);

            showHand(player);
            showHand(computerPlayer);
            System.out.println();
            gameConclusion(player.getHandsRank(), computerPlayer.getHandsRank());
            System.out.println("게임은 더하고싶으면 1을 누르시고 아니면 다른 숫자를 누르시오.");
            menu = scanner.nextInt();
        }

        printPlayerState();
    }

    private void gameConclusion(HandsRank playerHandsRank, HandsRank computerHandsRank) {
        if(playerHandsRank.getHandsRank() > computerHandsRank.getHandsRank()) {
            System.out.println("이기셨으므로 2000원을 얻으셨습니다.");
            player.setMoney(player.getMoney() + 2000);
        }else {
            System.out.println("졌으므로 2000원을 잃으셨습니다.");
            player.setMoney(player.getMoney() - 2000);
        }
    }

    public void playerHandDraw() {
        Hand playerHand = new Hand(deck, gameType);
        Hand computerHand = new Hand(deck, gameType);
        player.setPlayerHand(playerHand);
        computerPlayer.setPlayerHand(computerHand);
    }

    private void settingRank(Evaluator evaluator, Player player) {
        player.setHandsRank(evaluator.evaluate(player.getPlayerHand().getCardList()));
        player.getHandsRank().setNumRank(player.getPlayerHand().highNumCard());
        player.getPlayerHand().setHandRankPoint(player.getHandsRank().getHandsRank());
    }

    public void showHand(Player player) {
        int num = 1;
        System.out.println("패 보유 상황 \n");
        for(Card card : player.getPlayerHand().getCardList()) {
            System.out.println(num+". 문양 : "+card.getSuit()+" 숫자"+card.getRank());
            num+=1;
        }
        System.out.println();
    }

    public void printPlayerState() {
        System.out.println();
        System.out.println("플레이어의 돈 상태 "+player.getMoney());
        System.out.println("컴퓨터의 돈 상태 "+computerPlayer.getMoney());
        System.out.println();
    }
}