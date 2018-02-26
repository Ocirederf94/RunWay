package com.mygdx.game.views.levels;

/**
 * Created by fredy on 26/02/2018.
 */

public enum LevelDesign {

    LEVEL1(new int[][]{{1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1}});

    private int[][] levelArray;

    LevelDesign(int[][] levelArray) {
        this.levelArray = levelArray;
    }

    public int[][] getLevelArray() {
        return levelArray;
    }
}
