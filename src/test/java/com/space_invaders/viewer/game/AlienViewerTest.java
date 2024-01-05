package com.space_invaders.viewer.game;

import com.space_invaders.Position;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.Alien;
import com.space_invaders.viewer.game.AlienViewer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AlienViewerTest {

    @Test
    public void testDrawAlien() {
        Alien alien = Mockito.mock(Alien.class);
        GUI mockGUI = Mockito.mock(GUI.class);

        AlienViewer alienViewer = new AlienViewer();

        Position position = new Position(10, 20);
        Mockito.when(alien.getPosition()).thenReturn(position);

        alienViewer.draw(alien, mockGUI);

        Mockito.verify(mockGUI).drawAlien(position);
    }
}
