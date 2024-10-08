package com.space_invaders.model.game.elements.powerups;

import com.space_invaders.model.game.elements.SpaceShip;
import com.space_invaders.model.game.elements.powerups.NoPowerUp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoPowerUpTest {

    @Test
    public void testNoPowerUpMakeChanges() {
        // Arrange
        NoPowerUp noPowerUp = new NoPowerUp(5, 10);
        SpaceShip spaceShip = new SpaceShip(0, 0);

        // Act
        noPowerUp.makeChanges(spaceShip);

        // Assert
        assertEquals(800, spaceShip.getTimeToWait());
    }
}