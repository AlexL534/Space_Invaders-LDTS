package com.space_invaders.viewer.game;

import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.SpaceShip;

public class SpaceShipViewer implements ElementViewer<SpaceShip> {

    @Override
    public void draw(SpaceShip element, GUI gui) {
       gui.drawSpaceship(element.getPosition());
    }
}