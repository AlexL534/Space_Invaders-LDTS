package com.space_invaders.model.game.elements.powerups;

import com.space_invaders.model.game.elements.SpaceShip;
import com.space_invaders.model.game.elements.powerups.PowerUp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PowerUpTest {

    @Test
    public void testPowerUpTick() {
        PowerUp powerUp = new PowerUp(0, 0) {
            @Override
            public void makeChanges(SpaceShip spaceShip) {
            }
        };

        assertDoesNotThrow(powerUp::tick);
    }
}
