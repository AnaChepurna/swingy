package com.achepurn.model;

import com.achepurn.controller.Controller;
import com.achepurn.view.ConsoleView;

import java.util.ArrayList;

/**
 * Created by achepurn on 1/30/19.
 */

public class Model {
    private ArrayList<Hero> heroList = new ArrayList<Hero>();
    private Controller controller;
    private ConsoleView view;
    private Game game;

    boolean getAccept() {
        return true;
    }

    public Model(String str) {
       // heroList.add(new Hero("Olly"));
      //  heroList.add(new Hero("John"));
       // heroList.add(new Hero("Elsa"));
      //  heroList.add(new Hero("Katty"));
//        if (str.equals("console")) {
//          //  this.view = new ConsoleView(this);
//          //  this.controller = view.getController();
//        }
//        else if (str.equals("swing")) {
//         //   this.view = new SwingView(this);
//         //   this.controller = view.getController();
//        }
        controller = new Controller();
        game = new Game(new Hero("Olly", eHeroClass.WIZARD, controller), this);
        view = new ConsoleView( this, controller);
        controller.initController(view, this);
    }

    public void run() {
        game.map.mapping(game.list);
        view.setMap(game.map);
        view.run();
        System.out.println("lol");
        view.run();
    }

    public static void main(String[] args) {
        Model model = new Model("swing");
        model.run();
//        System.out.println(model.hero.getName());
        System.out.println("Hello Swingy!");

    }

    public aUnit getUnit(int i) {
        return game.getUnit(i);
    }

    public aUnit getHero() {
        return game.hero;
    }

    public int getMapSize(){
        return game.map.size;
    }
}
