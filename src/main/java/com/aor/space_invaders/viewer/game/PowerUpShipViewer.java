package com.aor.space_invaders.viewer.game;

import com.aor.space_invaders.gui.GUI;
import com.aor.space_invaders.model.game.elements.PowerUpShip;
import com.aor.space_invaders.viewer.game.ElementViewer;

public class PowerUpShipViewer implements ElementViewer<PowerUpShip> {
    @Override
    public void draw(PowerUpShip element, GUI gui) {
        gui.drawPowerUpShip(element.getPosition());
    }
}
