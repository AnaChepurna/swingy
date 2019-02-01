package com.achepurn.controller;

import com.achepurn.model.Hero;
import com.achepurn.model.Model;
import com.achepurn.view.IView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by achepurn on 1/30/19.
 */
public class ConsoleController implements IController {
    private Model model;
    private IView view;

    public ConsoleController(Model model, IView view) {
        this.model = model;
        this.view = view;
    }

    private boolean confirmHero(Hero hero) throws IOException {
        view.showHero(hero);
        view.userMessage("Enter 'y' to choose this hero / 'n' to cancel / 'd' to delete hero from the list");
        String user = getUserString();
        if (user.length() == 1) {
            char u = user.charAt(0);
            switch (u) {
                case 'y' :
                    return true;
                case 'n' :
                    return false;
                case 'd' :
                    model.delHeroFromList(hero);
                    return false;
            }
        }
        view.userMessage("!!!Cannot recognize request!!!");
        return confirmHero(hero);
    }

    public Hero getHero() {
        Hero hero = null;
        List<Hero> listHero = model.getHeroList();
        while (hero == null) {
            try {
                view.chooseHeroList();
                String user = getUserString();
                if (user.equals("new"))
                    hero = createHero(listHero);
                else {
                    for (Hero h :
                            listHero) {
                        if (user.equals(h.getName())) {
                            hero = h;
                            break;
                        }
                    }
                }
                if (hero == null)
                    view.userMessage("!!!Cannot find that hero!!!");
                else if (!confirmHero(hero))
                    hero = null;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return hero;
    }

    public Hero createHero(List<Hero> list) {
        HeroFactory heroFactory = new HeroFactory(this, view, list);
        return heroFactory.createHero();
    }

    public String getUserString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine().trim();
    }
}
