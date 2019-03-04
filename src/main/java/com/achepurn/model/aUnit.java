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

    void collision(aUnit unit) {

    }
}
