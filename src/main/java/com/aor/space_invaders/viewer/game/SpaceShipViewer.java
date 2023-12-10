package com.aor.space_invaders.viewer.game;

import com.aor.space_invaders.gui.GUI;
import com.aor.space_invaders.model.game.elements.SpaceShip;
import com.aor.space_invaders.viewer.game.ElementViewer;

public class SpaceShipViewer implements ElementViewer<SpaceShip> {

    @Override
    public void draw(SpaceShip element, GUI gui) {
       gui.drawSpaceship(element.getPosition());
    }
}
