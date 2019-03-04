package com.achepurn.view;

import com.achepurn.controller.IController;
import com.achepurn.model.Hero;
import com.achepurn.model.Model;

import java.util.List;

/**
 * Created by achepurn on 1/30/19.
 */
public class ConsoleView implements IView {
    private Model model;
    //private IController controller;

    public ConsoleView(Model model) {
        this.model = model;
        //this.controller = new ConsoleController(model, this);
    }

    public void chooseHeroList() {
        List<Hero> list = model.getHeroList();
        if (!list.isEmpty()) {
            System.out.println("List of heroes:");
            for (Hero h :
                    list) {
                System.out.println("    * " + h.getName() + ";");
            }
            System.out.println("Enter hero name to choose one; type 'new' to create new hero");
        }
        else {
            System.out.println("There are no previously created heroes!\nType 'new' to create one:");
        }
    }

    public void userMessage(String message) {
        System.out.println(message);
    }

    public IController getController() {
        //return controller;
        return null;
    }

    public void showHero(Hero hero) {
        System.out.println("Hero stat :");
        System.out.println("name : " + hero.getName());
    }
}
