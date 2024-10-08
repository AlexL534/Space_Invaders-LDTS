package com.space_invaders.model.game.elements;

import com.space_invaders.model.game.elements.SpaceShip;
import com.space_invaders.model.game.elements.bullets.SpaceShipBullet;
import com.space_invaders.model.game.elements.powerups.PowerUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SpaceShipTest {

    private SpaceShip spaceShip;

    @BeforeEach
    public void setUp() {
        spaceShip = new SpaceShip(0, 0); // Provide appropriate x1, x2 values
    }

    @Test
    public void testInitialValues() {
        assertEquals(800, spaceShip.getTimeToWait());
        assertNull(spaceShip.getPowerUp());
        assertEquals(0, spaceShip.getScore());
        assertEquals(3, spaceShip.getHP());
        assertNotNull(spaceShip.getBullets());
        assertEquals(0, spaceShip.getBullets().size());
    }

    @Test
    public void testSettersAndGetters() {
        spaceShip.setTimeToWait(1000);
        assertEquals(1000, spaceShip.getTimeToWait());

        PowerUp powerUp = mock(PowerUp.class);
        spaceShip.setPowerup(powerUp);
        assertEquals(powerUp, spaceShip.getPowerUp());

        spaceShip.addScore();
        assertEquals(10, spaceShip.getScore());

        spaceShip.setScore(50);
        assertEquals(50, spaceShip.getScore());

        spaceShip.setHP(2);
        assertEquals(2, spaceShip.getHP());
    }

    @Test
    public void testBulletOperations() {
        SpaceShipBullet mockBullet = mock(SpaceShipBullet.class);
        spaceShip.addBullet(mockBullet);

        List<SpaceShipBullet> bullets = spaceShip.getBullets();
        assertEquals(1, bullets.size());

        spaceShip.removeBullet(mockBullet);
        assertEquals(0, bullets.size());
    }

    @Test
    public void testLifeOperations() {
        assertEquals(3, spaceShip.getHP());
        spaceShip.removeLife();
        assertEquals(2, spaceShip.getHP());
    }
}