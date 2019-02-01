package com.achepurn.controller;

import com.achepurn.model.Hero;
import com.achepurn.model.Model;
import com.achepurn.view.IView;
import com.achepurn.view.SwingView;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by achepurn on 1/30/19.
 */
public class SwingController implements IController {
    private Model model;
    private SwingView view;
    private Hero hero = null;

    public SwingController(Model model, IView view) {
        this.model = model;
        if (view instanceof SwingView)
            this.view = (SwingView) view;
    }

    public Hero getHero() {
        view.chooseHeroList();
        if (hero != null)
            System.out.println(hero.getName());
        System.out.println("hhohohohoh");
        return hero;
    }

    public Hero createHero() {
        return null;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void delHeroFromList(Hero hero) {
        model.delHeroFromList(hero);
    }
}
