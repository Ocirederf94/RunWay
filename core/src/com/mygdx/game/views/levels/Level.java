package com.mygdx.game.views.levels;

/**
 * Created by fredy on 26/02/2018.
 */

public class Level {
    private LevelDesign levelDesign;

    public Level() {
        this.levelDesign = LevelFactory.getLevel();
    }


}
