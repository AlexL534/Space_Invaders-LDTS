package com.space_invaders.model.game.space;

import com.space_invaders.model.game.elements.Alien;
import com.space_invaders.model.game.elements.PowerUpShip;
import com.space_invaders.model.game.elements.SpaceShip;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class CustomSpaceBuilder extends SpaceBuilder {
    @Override
    protected List<PowerUpShip> createPowerUpShips() {
        return new ArrayList<>();
    }

    @Override
    protected int getWidth() {
        return 100;
    }

    @Override
    protected int getHeight() {
        return 100;
    }

    @Override
    protected List<Alien> createAliens() {
        return new ArrayList<>();
    }

    @Override
    protected SpaceShip createSpaceship() {
        return mock(SpaceShip.class);
    }
}

class SpaceBuilderTest {
    @Test
    void testCreateSpace() {
        CustomSpaceBuilder spaceBuilder = new CustomSpaceBuilder();
        Space space = spaceBuilder.createSpace();

        assertEquals(100, space.getWidth());
        assertEquals(100, space.getHeight());
    }
}
