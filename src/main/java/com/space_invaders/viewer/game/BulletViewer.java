package com.space_invaders.viewer.game;

import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.bullets.Bullet;

public abstract class BulletViewer implements ElementViewer<Bullet>{
    public abstract void draw(Bullet bullet, GUI gui);
}
