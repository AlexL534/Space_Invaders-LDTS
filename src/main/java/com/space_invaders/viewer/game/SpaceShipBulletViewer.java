package com.space_invaders.viewer.game;

import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.bullets.Bullet;

public class SpaceShipBulletViewer extends BulletViewer{
    @Override
    public void draw(Bullet element, GUI gui) {
        gui.drawSpaceShipBullet(element.getPosition());
    }
}
