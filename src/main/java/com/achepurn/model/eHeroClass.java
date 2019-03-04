package com.achepurn.model;

public enum eHeroClass {
    WIZARD, PALADIN, FIGHTER, RANGER, DRUID;

    int getHP (){
        switch (this) {
            case DRUID:
                return 100;
            case RANGER:
                return 60;
            case WIZARD:
                return 50;
            case PALADIN:
                return 70;
            case FIGHTER:
                return 80;
        }
        return 0;
    }

    int getAttack() {
        switch (this) {
            case FIGHTER:
                return 100;
            case PALADIN:
                return 50;
            case WIZARD:
                return 80;
            case RANGER:
                return 70;
            case DRUID:
                return 60;
        }
        return 0;
    }

    int getDefence() {
        switch (this) {
            case DRUID:
                return 60;
            case RANGER:
                return 70;
            case WIZARD:
                return 80;
            case PALADIN:
                return 100;
            case FIGHTER:
                return 50;
        }
        return 0;
    }
}
