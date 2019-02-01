package com.achepurn.view;

import com.achepurn.controller.IController;
import com.achepurn.controller.SwingController;
import com.achepurn.model.Hero;
import com.achepurn.model.Model;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by achepurn on 1/30/19.
 */
public class SwingView implements IView {
    private Model model;
    private SwingController controller;
    private JFrame frame;
    private List<Hero> heroes;

    private void initFrame() {
        frame = new JFrame("Swingy");
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
    }

    public class Start implements Runnable {
        private List<Hero> heroes;
        public boolean finished = false;

        public Start(List<Hero> heroes) {
            this.heroes = heroes;
        }

        void setFinished() {
            finished = true;
        }

        @Override
        public void run() {
            initFrame();
            seeChooseHero();
        }

        private void seeChooseHero() {
            initFrame();
            JPanel chooseHero =  new JPanel();
            chooseHero.setLayout(new GridLayout(heroes.size() / 2 + heroes.size() % 2, 2));
            for (Hero h:
                    heroes) {
                chooseHero.add(heroButton(h));
            }
            JButton bnew = new JButton("new");
            bnew.setBackground(Color.gray);
            bnew.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    controller.createHero();
                }
            });
            chooseHero.add(bnew);
            frame.add(chooseHero, 0);
        }

        private JButton heroButton(final Hero hero) {
            JButton b = new JButton(hero.getName());
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    seeHeroInfo(hero);
                    frame.add(new JLabel("noooooo"));
                    System.out.println("noooooo");
                }
            });
            return b;
        }

        private void seeHeroInfo(final Hero hero) {
            initFrame();
            JPanel heroInfo = new JPanel();
            heroInfo.setLayout(new GridLayout(3, 2));
            heroInfo.add(new JLabel("name : "));
            heroInfo.add(new JLabel(hero.getName()));
            heroInfo.add(new JLabel("class : "));
            heroInfo.add(new JLabel("wtf??"));
            heroInfo.add(new JLabel("level : "));
            heroInfo.add(new JLabel("-42"));
            frame.add(heroInfo, 0);
            JPanel menu = new JPanel();
            menu.setLayout(new GridLayout(3, 1));
            JButton confirm = new JButton("Confirm");
            confirm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.add(new JLabel(hero.getName() + " is choosen!"));
                    controller.setHero(hero);
                    System.out.println("interrupt this shit");
                    setFinished();
                    if (finished)
                        System.out.println("yey");
                    System.out.println("interrupted?");
                }
            });
            menu.add(confirm);
            JButton cancel = new JButton("Cansel");
            cancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.add(new JLabel("noooooo"));
                    System.out.println("noooooo");
                    seeChooseHero();
                }
            });
            menu.add(cancel);
            JButton delete = new JButton("Delete");
            delete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    controller.delHeroFromList(hero);
                    seeChooseHero();
                }
            });
            menu.add(delete);
            frame.add(menu, 1);
        }
    }

    public SwingView(Model model) {
        this.model = model;
        this.controller = new SwingController(model, this);
    }

    public void chooseHeroList() {
        try {
            Start start = new Start(model.getHeroList());
            SwingUtilities.invokeAndWait(start);
            while (!start.finished) {
                System.out.println("-");
            }
            System.out.println("finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void userMessage(String message) {

    }

    public void showHero(Hero hero) {

    }

    public IController getController() {
        return controller;
    }

}
