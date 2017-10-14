package com.mygdx.game.player.character.wepons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.utils.GameConstants;
import com.mygdx.game.player.character.MainCharacter;

/**
 * Created by fredy on 23/09/2017.
 */

public class LaserPointer extends ShapeRenderer {
    private MainCharacter mainCharacter;

    public LaserPointer(MainCharacter mainCharacter){
        super();
        this.mainCharacter = mainCharacter;
        this.begin(ShapeType.Line);
        this.setColor(Color.RED);
        this.line(mainCharacter.getMainCharacterCamera().position.x, mainCharacter.getMainCharacterCamera().position.y + GameConstants.LASER_LENGTH, 0, 0);
        this.end();
        Gdx.gl.glLineWidth(1);

    }

}
