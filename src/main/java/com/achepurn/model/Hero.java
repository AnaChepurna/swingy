package com.achepurn.model;

import com.achepurn.controller.Controller;

import java.lang.management.GarbageCollectorMXBean;

/**
 * Created by achepurn on 1/30/19.
 */
public class Hero extends aUnit {
    Controller controller;
    String name;
    eHeroClass clas;
    int level;
    int experience;
    private Artifact weapon;
    private Artifact armor;
    private Artifact helm;

    public Hero(String name, eHeroClass clas, Controller controller) {
        this.name = name;
        this.clas = clas;
        this.attack = clas.getAttack();
        this.defense = clas.getDefence();
        this.level = 1;
        this.experience = 0;
        this.hp = clas.getHP();
        this.controller = controller;
    }

    public final String getName() {
        return name;
    }

    private void getArtifact(Artifact artifact) {
       // if (game.getAccept()) {
           // game.list.remove(artifact);
            switch (artifact.type) {
                case WEAPON:
                    if (weapon != null) {
                        weapon.x = artifact.x;
                        weapon.y = artifact.y;
                       // game.list.add(weapon);
                    }
                    weapon = artifact;
                    break;
                case ARMOR:
                    if (armor != null) {
                        armor.x = artifact.x;
                        armor.y = artifact.y;
                       // game.list.add(armor);
                    }
                    armor = artifact;
                    break;
                case HELM:
                    if (helm != null) {
                        helm.x = artifact.x;
                        helm.y = artifact.y;
                      //  game.list.add(armor);
                    }
                    helm = artifact;
            }
       // }
    }

    void collision(aUnit unit) {
        if (unit instanceof RandomMonster) {
            if (fight(unit)) {

            }
        }
        else if (unit instanceof Artifact)
            getArtifact((Artifact) unit);
    }
}
