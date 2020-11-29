package com.jbouchier.cg.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private Board gameBoard;
    private int playerId;
    private List<Card> hand;

    public Player() {
        super();
    }

    public Player(int playerId) {
        this.gameBoard = new Board();
        this.playerId = playerId;
        this.hand = new ArrayList<>();
    }

    public void addCardToHand() {
        hand.add(Card.generateRandomCard());
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public int getPlayerId() {
        return playerId;
    }

    public List<Card> getHand() {
        return hand;
    }
}