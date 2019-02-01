package com.achepurn.controller;

import com.achepurn.model.Hero;
import com.achepurn.view.IView;

import java.util.List;

/**
 * Created by achepurn on 1/30/19.
 */
public class HeroFactory {
    private List<Hero> listHero;
    private IController controller;
    private IView view;

    public HeroFactory(IController controller, IView view, List<Hero> list) {
        listHero = list;
        this.controller = controller;
        this.view = view;
    }

    public Hero createHero() {
        return null;
    }
}
