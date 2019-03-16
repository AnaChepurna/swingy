package com.achepurn.view;

import com.achepurn.controller.Controller;
import com.achepurn.controller.UserControl;
import com.achepurn.model.*;
import jline.AnsiWindowsTerminal;
import jline.console.ConsoleReader;


import java.io.IOException;

/**
 * Created by achepurn on 1/30/19.
 */
public class ConsoleView implements IView {
    final String os = System.getProperty("os.name");
    private Model model;
    private Controller controller;
    private Map map;
    private UserControlListener listener;
    AnsiWindowsTerminal terminal;
    ConsoleReader console;


    public ConsoleView(Model model, Controller controller) {
        this.model = model;
        this.controller = controller;
        try {
            initConsole();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initConsole() throws Exception {
        this.terminal = new AnsiWindowsTerminal();
        terminal.init();
        this.console = new ConsoleReader(System.in, System.out, terminal);
        console.setExpandEvents(true);
        listener = new UserControlListener(console.getInput(), this);
    }

    public void setMap(Map map) {
        try {
            this.map = (Map)map.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private void clearConsole() throws IOException {
        console.clearScreen();
        console.flush();
    }

    private String getSymbol(int value) {
        if (value == -1)
            return "   ";
        aUnit unit = model.getUnit(value);
        if (unit instanceof Hero)
            return "<H>";
        if (unit instanceof RandomMonster)
            return "<M>";
        if (unit instanceof Artifact)
            return "<A>";
        return "###";
    }

    private void printMap() throws IOException {
        console.print("*");
        for (int i = 0; i < map.getSize(); i++)
            console.print("---");
        console.println("*");
        for (int i = 0; i < map.getSize(); i++) {
            console.print("|");
            for (int j = 0; j < map.getSize(); j++) {
                String str = getSymbol(map.getValue(i, j));
                console.print(str);
            }
            console.println("|");
        }
        console.print("*");
        for (int i = 0; i < map.getSize(); i++)
            console.print("---");
        console.println("*");
        console.flush();
    }

    public void run() {
        try {
            clearConsole();
            printMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void takeUserControl(UserControl control) {
        controller.provideUserMoovement(control);
    }
}
