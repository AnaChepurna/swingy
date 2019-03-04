package com.achepurn.model;

import java.util.ArrayList;

public class Game {
    Hero hero;
    ArrayList<aUnit>list;
    Map map;

    Game(Hero hero) {
        this.hero = hero;
        initMap();
    }

    private void initMap() {
        this.map = new Map(hero.level);
        hero.x = map.size / 2 + 1;
        hero.y = map.size / 2 + 1;
        int monsterNum = RandomMonster.random.nextInt(hero.level) + hero.level;
        for (int i = 0; i < monsterNum; i++)
            list.add(new RandomMonster(hero.level));
        list.add(hero);
    }

}
