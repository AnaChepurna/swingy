package com.achepurn.controller;

import com.achepurn.model.Hero;
import com.achepurn.model.Model;
import com.achepurn.view.IView;

import java.io.IOException;

/**
 * Created by achepurn on 1/30/19.
 */
public class SwingController implements IController {
    private Model model;
    private IView view;

    public SwingController(Model model, IView view) {
        this.model = model;
        this.view = view;
    }

    public Hero getHero() {
        view.chooseHeroList();
        return null;
    }

    public String getUserString() throws IOException {
        return null;
    }
}
