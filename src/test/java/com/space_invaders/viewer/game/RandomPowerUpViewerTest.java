package com.space_invaders.viewer.game;

import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.powerups.PowerUp;
import com.space_invaders.viewer.game.RandomPowerUpViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class RandomPowerUpViewerTest {

    @Test
    public void testDrawMethod() {
        PowerUp powerUp = Mockito.mock(PowerUp.class);
        GUI mockGUI = Mockito.mock(GUI.class);

        RandomPowerUpViewer randomPowerUpViewer = new RandomPowerUpViewer();

        randomPowerUpViewer.draw(powerUp, mockGUI);

        verify(mockGUI).drawRandomPowerUp(powerUp.getPosition());
    }
}