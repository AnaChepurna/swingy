package com.achepurn.controller;

import com.achepurn.model.Model;
import com.achepurn.view.IView;

public class Controller {
    private IView view;
    private Model model;

    public Controller() {}
    public void initController(IView view, Model model){
        this.model = model;
        this.view = view;
    }

    public void provideUserMoovement(UserControl control){
        switch (control) {
            case UP:
                model.getHero().setY(model.getHero().getX() > 0 ?
                        model.getHero().getX() - 1 : 0);
                break;
            case DOWN:
                model.getHero().setY(model.getHero().getX() < model.getMapSize() - 1 ?
                        model.getHero().getX() + 1 : model.getHero().getX());
                break;
            case LEFT:
                model.getHero().setY(model.getHero().getY() > 0 ?
                        model.getHero().getY() - 1 : 0);
                break;
            case RIGHT:
                model.getHero().setY(model.getHero().getY() < model.getMapSize() - 1 ?
                        model.getHero().getY() + 1 : model.getHero().getY());
                break;
        }
    }
}
