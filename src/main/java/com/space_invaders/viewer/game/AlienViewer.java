package com.space_invaders.viewer.game;

import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.Alien;

public class AlienViewer implements ElementViewer<Alien> {
    @Override
    public void draw(Alien element, GUI gui) {
        gui.drawAlien(element.getPosition());
    }
}
