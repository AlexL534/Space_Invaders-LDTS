package com.space_invaders.viewer.game;

import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.SpaceShip;
import com.space_invaders.viewer.game.SpaceShipViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class SpaceShipViewerTest {

    @Test
    public void testDrawMethod() {
        SpaceShip spaceShip = Mockito.mock(SpaceShip.class);
        GUI mockGUI = Mockito.mock(GUI.class);

        SpaceShipViewer spaceShipViewer = new SpaceShipViewer();

        spaceShipViewer.draw(spaceShip, mockGUI);

        verify(mockGUI).drawSpaceship(spaceShip.getPosition());
    }
}