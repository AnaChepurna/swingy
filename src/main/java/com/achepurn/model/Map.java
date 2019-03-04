package com.achepurn.model;

import java.util.ArrayList;
import java.util.List;

public class Map {
    int size;
    int [][]map;

    Map(int level) {
        size = (level-1)*5+10-(level%2);
        map = new int[size][size];
        clean();
    }

    private void mapping(List<aUnit> list) {
        for (int i = 0; i < list.size(); i++) {
            aUnit unit = list.get(i);
            if (map[unit.x][unit.y] == -1)
                map[unit.x][unit.y] = i;
            else {
                unit.collision(list.get(map[unit.x][unit.y]));
                i = 0;
            }
        }
        clean();
    }

    boolean isEmpty(int x, int y) {
        return map[x][y] == -1;
    }

    private void clean() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                map[i][j] = -1;
        }
    }
}
