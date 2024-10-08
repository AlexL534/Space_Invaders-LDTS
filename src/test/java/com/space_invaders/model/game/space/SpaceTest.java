package com.space_invaders.model.game.space;

import com.space_invaders.Position;
import com.space_invaders.model.game.elements.*;
import com.space_invaders.model.game.elements.bullets.Bullet;
import com.space_invaders.model.game.elements.bullets.SpaceShipBullet;
import com.space_invaders.model.game.space.Space;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SpaceTest {

    private Space space;

    @BeforeEach
    public void setUp() {
        space = new Space(100, 100);
    }

    @Test
    public void testGettersAndSetters() {
        SpaceShip spaceShip = new SpaceShip(20,20);
        List<Alien> aliens = new ArrayList<>();
        List<PowerUpShip> powerUpShips = new ArrayList<>();

        space.setSpaceship(spaceShip);
        space.setAliens(aliens);
        space.setPowerUpShips(powerUpShips);

        assertEquals(spaceShip, space.getSpaceship());
        assertEquals(aliens, space.getAliens());
        assertEquals(powerUpShips, space.getPowerUpShips());
    }

    @Test
    public void testCanSpaceShipMove() {
        assertTrue(space.canSpaceShipMove(new Position(50, 50)));
        assertFalse(space.canSpaceShipMove(new Position(101, 50)));
    }
}
