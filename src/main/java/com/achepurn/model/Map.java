package com.achepurn.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {
    int size;
    int [][]map;
    static Random random = new Random();

    Map(int level) {
        size = (level-1)*5+10-(level%2);
        map = new int[size][size];
        clean();
    }

    private Map(){};

    public int getSize() {
        return size;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Map map = new Map();
        map.size = size;
        map.map = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                map.map[i][j] = this.map[i][j];
        }
        return map;
    }

    public int getValue(int x, int y) {
        return map[x][y];
    }

    void mapping(List<aUnit> list) {
        for (int i = 0; i < list.size(); i++) {
            aUnit unit = list.get(i);
            if (isEmpty(unit.x, unit.y))
                map[unit.x][unit.y] = i;
            else if (!isOutsideMap(unit.x, unit.y)) {
                unit.collision(list.get(map[unit.x][unit.y]));
                list.get(map[unit.x][unit.y]).collision(unit);
                i = 0;
            }
        }
    }

    private boolean isOutsideMap(int x, int y) {
        return ( x < 0  || x >= size || y < 0 || y >= size);
    }

    boolean isEmpty(int x, int y) {
        if (isOutsideMap(x, y))
            return false;
        return map[x][y] == -1;
    }

    void clean() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                map[i][j] = -1;
        }
    }

    public void setRandomPlace(aUnit unit) {
        unit.x = -1;
        unit.y = -1;
        int i = 0;
        while (i++ < 42) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            if (isEmpty(x, y)) {
                unit.x = x;
                unit.y = y;
                i = 42;
            }
        }
    }

}
