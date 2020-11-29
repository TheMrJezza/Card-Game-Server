package com.jbouchier.cg.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {
    private final Player[] players;

    private final Logger LOG = LoggerFactory.getLogger(Game.class);

    public Game() {
        this(2);
    }

    public Game(int playerAmount) {
        if (playerAmount < 2) {
            playerAmount = 2;
            LOG.warn("Specified Player Amount has been increased to 2. Cannot run with anything less.");
        }
        players = new Player[playerAmount];

        LOG.info("Starting Game with {} players!", playerAmount);
        start();
    }

    public Player getPlayer(int playerId) {
        return players[playerId];
    }

    public void start() {
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(i);
        }

    }
}