package com.jbouchier.cg.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private int mana, shield;
    private Slot[] field;
    private ArrayList<Card> grave;

    public Board() {
        super();
        mana = 0;
        shield = 0;
        field = new Slot[5];
        Arrays.fill(field, new Slot());
        grave = new ArrayList<>();
    }

    public Board(int mana, int shield, Slot[] field, ArrayList<Card> grave) {
        this.mana = mana;
        this.shield = shield;
        this.field = field;
        this.grave = grave;
    }

    public int getMana() {
        return mana;
    }

    public int getShield() {
        return shield;
    }

    public Slot[] getField() {
        return field;
    }

    public ArrayList<Card> getGrave() {
        return grave;
    }
}