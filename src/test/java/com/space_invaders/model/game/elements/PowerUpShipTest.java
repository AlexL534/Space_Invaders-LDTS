package com.space_invaders.model.game.elements;

import com.space_invaders.Position;
import com.space_invaders.model.game.elements.PowerUpShip;
import com.space_invaders.model.game.elements.powerups.ExtraLife;
import com.space_invaders.model.game.elements.powerups.FasterFireRate;
import com.space_invaders.model.game.elements.powerups.PowerUp;
import com.space_invaders.model.game.elements.powerups.SlowerFireRate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PowerUpShipTest {

    private PowerUpShip powerUpShip;

    @BeforeEach
    public void setUp() {
        powerUpShip = new PowerUpShip(0, 0); // Provide appropriate x, y values
    }

    @Test
    public void testUpdate() {
        powerUpShip.update();
        assertEquals(1, powerUpShip.getPosition().getX());
        assertEquals(0, powerUpShip.getPosition().getY());
    }

    @Test
    public void testIsDropping() {
        assertFalse(powerUpShip.isDropping());
    }

    @Test
    public void testAddPowerUp() {
        powerUpShip.addPowerUp();
        List<PowerUp> powerUps = powerUpShip.getPowerUps();
        assertFalse(powerUps.isEmpty());
        assertTrue(powerUps.get(0) instanceof FasterFireRate
                || powerUps.get(0) instanceof SlowerFireRate
                || powerUps.get(0) instanceof ExtraLife);
    }

    @Test
    public void testDrop() {
        powerUpShip.addPowerUp();
        powerUpShip.drop();
        assertTrue(powerUpShip.isDropping());
    }

    @Test
    public void testRemovePowerUp() {
        powerUpShip.addPowerUp();
        List<PowerUp> powerUps = powerUpShip.getPowerUps();
        assertEquals(1, powerUps.size());

        PowerUp powerUpToRemove = powerUps.get(0);
        powerUpShip.removePowerUp(powerUpToRemove);

        powerUps = powerUpShip.getPowerUps();
        assertEquals(0, powerUps.size());
    }
}
