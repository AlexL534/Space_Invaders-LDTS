package com.space_invaders.viewer.game;

import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.PowerUpShip;
import com.space_invaders.viewer.game.PowerUpShipViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class PowerUpShipViewerTest {

    @Test
    public void testDrawMethod() {
        PowerUpShip powerUpShip = Mockito.mock(PowerUpShip.class);
        GUI mockGUI = Mockito.mock(GUI.class);

        PowerUpShipViewer powerUpShipViewer = new PowerUpShipViewer();

        powerUpShipViewer.draw(powerUpShip, mockGUI);

        verify(mockGUI).drawPowerUpShip(powerUpShip.getPosition());
    }
}
