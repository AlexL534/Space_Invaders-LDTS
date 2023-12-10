package com.aor.space_invaders.viewer.game;

import com.aor.space_invaders.gui.GUI;
import com.aor.space_invaders.model.game.elements.Bullet;

public interface BulletViewer <T extends Bullet>{
    public void draw(T bullet, GUI gui);
}
