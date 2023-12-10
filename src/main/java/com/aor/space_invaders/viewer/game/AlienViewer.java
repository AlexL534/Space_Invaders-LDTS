package com.aor.space_invaders.viewer.game;

import com.aor.space_invaders.gui.GUI;
import com.aor.space_invaders.model.game.elements.Alien;

public class AlienViewer implements ElementViewer<Alien> {
    @Override
    public void draw(Alien element, GUI gui) {
        gui.drawAlien(element.getPosition());
    }
}
