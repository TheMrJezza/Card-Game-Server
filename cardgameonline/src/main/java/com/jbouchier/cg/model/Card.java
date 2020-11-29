package com.jbouchier.cg.model;

import com.jbouchier.cg.RandomUtils;

import static com.jbouchier.cg.RandomUtils.*;

public class Card {

    private static transient String[] types = {"MINION", "SPELL", "ARTIFACT", "ENCHANT"};

    private String type, name, desc;
    private int attack, def, cost;

    public Card() {
        super();
    }

    public Card(String type, String name, String desc, int attack, int def, int cost) {
        this.type = type;
        this.name = name;
        this.desc = desc;
        this.attack = attack;
        this.def = def;
        this.cost = cost;
    }

    public static Card generateRandomCard() {
        String type = types[nextRandom(4)];
        return new Card(type, type + "#" + nextRandom(10000),
                "Some Random Description", nextRandom(10),
                nextRandom(10), nextRandom(10));
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return desc;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return def;
    }

    public int getCost() {
        return cost;
    }
}