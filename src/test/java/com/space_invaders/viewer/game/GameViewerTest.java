package com.space_invaders.viewer.game;

import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.*;
import com.space_invaders.model.game.elements.bullets.Bullet;
import com.space_invaders.model.game.elements.bullets.SpaceShipBullet;
import com.space_invaders.model.game.space.Space;
import com.space_invaders.viewer.game.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class GameViewerTest {

    private GameViewer gameViewer;
    private Space mockSpace;
    private GUI mockGUI;

    @BeforeEach
    public void setUp() {
        mockSpace = mock(Space.class);
        mockGUI = mock(GUI.class);
        gameViewer = new GameViewer(mockSpace);
    }

    @Test
    public void testDrawElements() {
        // Mock data - elements to be drawn
        List<Alien> aliens = new ArrayList<>();
        aliens.add(new Alien(20, 20));
        // Add more elements to test different scenarios

        SpaceShip spaceShip = new SpaceShip(20, 20);
        SpaceShipBullet mockBullet = mock(SpaceShipBullet.class);
        spaceShip.addBullet(mockBullet); // Add the mock bullet to the spaceship

        // Set up more elements for testing

        // Mock the behavior of getModel() and other relevant methods to return expected data
        when(mockSpace.getAliens()).thenReturn(aliens);
        when(mockSpace.getSpaceship()).thenReturn(spaceShip);
        // Set up mock data for other elements

        // Invoke the method to be tested
        gameViewer.drawElements(mockGUI);

        // Verify that the expected methods are called on the GUI for each element
        verify(mockGUI, times(2)).drawText(any(), any(), any());
        verify(mockGUI, times(1)).drawSpaceship(any());
        verify(mockGUI, times(1)).drawSpaceShipBullet(any()); // Add verification for drawSpaceShipBullet
        // Verify other draw methods based on the number of elements expected to be drawn
    }



    // Add more tests for other private methods if needed
}
