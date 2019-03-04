package com.achepurn.model;

import java.util.Random;

public class Artifact extends aUnit {
    static Random random = new Random();
    eArtifactType type;
    eHeroClass clas;

    public enum eArtifactType {
        WEAPON, ARMOR, HELM
    }

    void collision(aUnit unit) {
    }

    private void initStat(int level){
        switch (this.type) {
            case HELM:
                hp = random.nextInt(level);
                break;
            case ARMOR:
                defense = random.nextInt(level);
                break;
            case WEAPON:
                attack = random.nextInt(level);
        }
    }

    Artifact() {
        clas = eHeroClass.values()[random.nextInt(eHeroClass.values().length)];
        eArtifactType type = eArtifactType.values()[random.nextInt(eArtifactType.values().length)];
        initStat(100);
    }
}
