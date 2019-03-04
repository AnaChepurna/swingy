package com.achepurn.view;

import com.achepurn.controller.Controller;
import com.achepurn.controller.IController;
import com.achepurn.model.*;
import jline.ConsoleReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

/**
 * Created by achepurn on 1/30/19.
 */
public class ConsoleView implements IView {
    final String os = System.getProperty("os.name");
    private Model model;
    private Controller controller;
    private Map map;

    public ConsoleView(Model model, Controller controller) {
        this.model = model;
        this.controller = controller;
    }

    public void setMap(Map map) {
        try {
            this.map = (Map)map.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private void clearConsole() {
        try {
            ConsoleReader cr = new ConsoleReader();
            cr.clearScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            if (os.contains("Windows"))
//                Runtime.getRuntime().exec("cls");
//            else
//                Runtime.getRuntime().exec("clear");
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
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

    private void printMap() {
        System.out.print("*");
        for (int i = 0; i < map.getSize(); i++)
            System.out.print("---");
        System.out.println("*");
        for (int i = 0; i < map.getSize(); i++) {
            System.out.print("|");
            for (int j = 0; j < map.getSize(); j++) {
                String str = getSymbol(map.getValue(i, j));
                System.out.print(str);
            }
            System.out.println("|");
        }
        System.out.print("*");
        for (int i = 0; i < map.getSize(); i++)
            System.out.print("---");
        System.out.println("*");
    }

    public void run() {
        clearConsole();
        printMap();
    }
}
