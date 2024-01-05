package com.space_invaders.viewer.game;

import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.powerups.PowerUp;

public class RandomPowerUpViewer implements ElementViewer<PowerUp> {
    @Override
    public void draw(PowerUp element, GUI gui) {
        gui.drawRandomPowerUp(element.getPosition());
    }
}
