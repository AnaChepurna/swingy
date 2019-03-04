package com.achepurn.model;

import java.util.ArrayList;

public class Game {
    Model model;
    Hero hero;
    ArrayList<aUnit>list = new ArrayList<aUnit>();
    Map map;
    private int nextLivel;

    Game(Hero hero, Model model) {
        this.model = model;
        this.hero = hero;
        initMap();
        this.nextLivel = calculateNextLevel(hero.level);
    }

    public boolean getAccept(){
        return model.getAccept();
    }

    private int calculateNextLevel(int level){
        return level * 1000 + (level - 1) * (level - 1) * 450;
    }

    private void initMap() {
        this.map = new Map(hero.level);
        hero.x = map.size / 2;
        hero.y = map.size / 2;
        int monsterNum = RandomMonster.random.nextInt(hero.level) + hero.level;
        for (int i = 0; i < monsterNum; i++) {
            RandomMonster monster = new RandomMonster(hero.level);
            map.setRandomPlace(monster);
            list.add(monster);
        }
        list.add(hero);
    }

    aUnit getUnit(int i) {
        if (i >= list.size() || i < 0)
            return null;
        else
            return list.get(i);
    }
}
