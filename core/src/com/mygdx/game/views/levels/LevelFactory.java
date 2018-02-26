package com.mygdx.game.views.levels;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fredy on 26/02/2018.
 */

public class LevelFactory {

    private static List<LevelDesign> levelDesignList = Arrays.asList(LevelDesign.values());
    private static int counter = 0;

    public static LevelDesign getLevel() {
        LevelDesign levelDesign = levelDesignList.get(counter);
        if (counter < levelDesignList.size() - 1) counter++;
        return levelDesign;
    }
}
