package com.jbouchier.cg.model;

import java.util.ArrayList;

public class Slot {
    private Card focus;
    private ArrayList<Card> modifiers;

    public Slot() {
        super();
        modifiers = new ArrayList<>();
    }

    public Slot(Card focus, ArrayList<Card> modifiers) {
        this.focus = focus;
        this.modifiers = modifiers;
    }

    public Card getFocus() {
        return focus;
    }

    public ArrayList<Card> getModifiers() {
        return modifiers;
    }
}