package com.space_invaders.viewer.game;

import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.bullets.Bullet;

public class EnemyBulletViewer extends BulletViewer{
    @Override
    public void draw(Bullet bullet, GUI gui) {
            gui.drawAlienBullet(bullet.getPosition());
    }
}
