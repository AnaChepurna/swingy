package com.achepurn.model;

import com.achepurn.controller.IController;
import com.achepurn.view.ConsoleView;
import com.achepurn.view.IView;
import com.achepurn.view.SwingView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by achepurn on 1/30/19.
 */

public class Model {
    private ArrayList<Hero> heroList = new ArrayList<Hero>();
   // private IController controller;
    private IView view;
    private Hero hero;

    public Model(String str) {
       // heroList.add(new Hero("Olly"));
      //  heroList.add(new Hero("John"));
       // heroList.add(new Hero("Elsa"));
      //  heroList.add(new Hero("Katty"));
        if (str.equals("console")) {
          //  this.view = new ConsoleView(this);
          //  this.controller = view.getController();
        }
        else if (str.equals("swing")) {
         //   this.view = new SwingView(this);
         //   this.controller = view.getController();
        }
    }

    public void run() {
        //hero = controller.getHero();
    }

    public final List<Hero> getHeroList() {
        return heroList;
    }

    public void delHeroFromList(Hero hero) {
        heroList.remove(hero);
    }

    public static void main(String[] args) {
        Model model = new Model("swing");
        model.run();
//        System.out.println(model.hero.getName());
        System.out.println("Hello Swingy!");

    }
}
