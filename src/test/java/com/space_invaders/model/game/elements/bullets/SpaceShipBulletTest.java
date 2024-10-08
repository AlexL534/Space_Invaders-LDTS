package com.space_invaders.model.game.elements.bullets;

import com.space_invaders.Position;
import com.space_invaders.model.game.elements.SpaceShip;
import com.space_invaders.model.game.elements.bullets.SpaceShipBullet;
import com.space_invaders.model.game.elements.powerups.PowerUp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SpaceShipBulletTest {

    @Test
    public void testSpaceShipBulletTick() {
        SpaceShipBullet spaceShipBullet = new SpaceShipBullet(5, 10);

        spaceShipBullet.tick();

        Position expectedPosition = new Position(5, 9);
        assertEquals(expectedPosition, spaceShipBullet.getPosition());
    }

    @Test
    public void testSpaceShipBulletMakeChanges() {
        SpaceShipBullet spaceShipBullet = new SpaceShipBullet(5, 10);
        SpaceShip spaceShip = mock(SpaceShip.class);
        PowerUp mockPowerUp = mock(PowerUp.class);

        when(spaceShip.getPowerUp()).thenReturn(mockPowerUp);

        spaceShipBullet.makeChanges(spaceShip);

        verify(mockPowerUp, times(1)).makeChanges(spaceShip);
    }
}