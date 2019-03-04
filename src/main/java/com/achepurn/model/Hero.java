package com.achepurn.model;

/**
 * Created by achepurn on 1/30/19.
 */
public class Hero extends aUnit {
    String name;
    eHeroClass clas;
    int level;
    int experience;

    private int calculateHP(){
        return this.level * 1000 + (this.level - 1) * (this.level - 1) * 450;
    }

    public Hero(String name, eHeroClass clas) {
        this.name = name;
        this.clas = clas;
        this.attack = clas.getAttack();
        this.defense = clas.getDefence();
        this.level = 1;
        this.experience = 0;
        this.hp = clas.getHP();
    }

    public final String getName() {
        return name;
    }
}
