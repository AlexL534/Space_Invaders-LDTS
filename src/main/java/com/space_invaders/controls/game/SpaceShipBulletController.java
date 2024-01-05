package com.space_invaders.controls.game;

import com.space_invaders.Game;
import com.space_invaders.controls.Controller;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.bullets.SpaceShipBullet;

import java.io.IOException;

public class SpaceShipBulletController extends Controller<SpaceShipBullet> {
    public SpaceShipBulletController(SpaceShipBullet model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION gui, long time) throws IOException {
    }
}
