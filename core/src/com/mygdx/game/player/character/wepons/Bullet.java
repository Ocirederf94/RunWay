package com.mygdx.game.player.character.wepons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.player.character.MainCharacter;
import com.mygdx.game.player.character.controllers.DirectionController;

import static com.mygdx.game.utils.GameConstants.BULLET_SPEED;

/**
 * Created by fredy on 22/09/2017.
 */

public class Bullet {
    private SpriteBatch spriteBatch;
    private Sprite sprite;
    private float initialX = Gdx.graphics.getWidth() / 2;
    private float initialY = Gdx.graphics.getHeight() / 2;
    private DirectionController directionController;
    private float dx, dy, knobX, knobY, charSpriteHalfWidth, charSpriteHalfHeight;

    public Bullet(MainCharacter mainCharacter, Texture texture, DirectionController directionController) {
        this.sprite = new Sprite(texture);
        this.spriteBatch = new SpriteBatch();
        this.directionController = directionController;
        this.charSpriteHalfWidth = mainCharacter.getSprite().getWidth() / 2;
        this.charSpriteHalfHeight = mainCharacter.getSprite().getHeight() / 2;
        this.sprite.setPosition(mainCharacter.getSprite().getX() + charSpriteHalfWidth, mainCharacter.getSprite().getY() + charSpriteHalfHeight);
        this.knobX = directionController.getKnobPercentX();
        this.knobY = directionController.getKnobPercentY();
        this.dx = MathUtils.cos(3.1415f / 4) * BULLET_SPEED;
        this.dy = MathUtils.sin(3.1415f / 4) * BULLET_SPEED;
    }

    public void renderBullet() {
        this.sprite.translate(dx * (knobX) , dy * (knobY));
        this.spriteBatch.begin();
        this.sprite.draw(spriteBatch);
        this.spriteBatch.end();
    }

    public void disposeBullet() {
        spriteBatch.dispose();
    }
}
