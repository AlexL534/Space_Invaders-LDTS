package com.aor.space_invaders.viewer.game;

import com.aor.space_invaders.Position;
import com.aor.space_invaders.gui.GUI;
import com.aor.space_invaders.model.game.elements.Element;
import com.aor.space_invaders.model.game.space.Space;
import com.aor.space_invaders.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Space> {
    public GameViewer(Space space) {
        super(space);
    }
    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getAliens(), new AlienViewer());
        drawElement(gui, getModel().getSpaceship(), new SpaceShipViewer());

        gui.drawText(new Position(0, 0), "Lives: " + getModel().getSpaceship().getHP(), "#FFD700");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
