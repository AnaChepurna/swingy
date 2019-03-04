package com.achepurn.model;

/**
 * Created by achepurn on 1/30/19.
 */
public class Hero extends aUnit {
    Model model;
    String name;
    eHeroClass clas;
    int level;
    int experience;
    private Artifact weapon;
    private Artifact armor;
    private Artifact helm;

    private int calculateHP(){
        return this.level * 1000 + (this.level - 1) * (this.level - 1) * 450;
    }

    public Hero(String name, eHeroClass clas, Model model) {
        this.name = name;
        this.clas = clas;
        this.attack = clas.getAttack();
        this.defense = clas.getDefence();
        this.level = 1;
        this.experience = 0;
        this.hp = clas.getHP();
        this.model = model;
    }

    public final String getName() {
        return name;
    }

    private void getArtifact(Artifact artifact) {
        if (model.getAccept()) {
            switch (artifact.type) {
                case WEAPON:

            }
        }
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
