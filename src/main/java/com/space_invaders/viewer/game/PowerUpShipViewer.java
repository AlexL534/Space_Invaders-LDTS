package com.space_invaders.viewer.game;

import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.PowerUpShip;

public class PowerUpShipViewer implements ElementViewer<PowerUpShip> {
    @Override
    public void draw(PowerUpShip element, GUI gui) {
        gui.drawPowerUpShip(element.getPosition());
    }
}