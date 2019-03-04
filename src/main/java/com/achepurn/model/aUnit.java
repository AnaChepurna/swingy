package com.achepurn.model;

public abstract class aUnit {
    int attack;
    int defense;
    int hp;

    int x;
    int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    abstract void collision(aUnit unit);

    boolean fight(aUnit unit) {
        return true;
    };
}
