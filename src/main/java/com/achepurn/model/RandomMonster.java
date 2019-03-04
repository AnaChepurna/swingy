package com.achepurn.model;

import java.util.Random;

public class RandomMonster extends aUnit {
    static Random random = new Random();

    private boolean onHold = false;

    private int getLevelBaff(int level) {
        return level;
    }

    RandomMonster(int level) {
        hp = random.nextInt(90) + getLevelBaff(level);
        defense = random.nextInt(90) + getLevelBaff(level);
        attack = random.nextInt(90) + getLevelBaff(level);
    }

    void collision(aUnit unit) {

    }
}
