package com.space_invaders.model.game.elements.powerups;

import com.space_invaders.model.game.elements.SpaceShip;
import com.space_invaders.model.game.elements.powerups.FasterFireRate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FasterFireRateTest {

    @Test
    public void testFasterFireRateMakeChanges() {
        FasterFireRate fasterFireRate = new FasterFireRate(5, 10);
        SpaceShip spaceShip = new SpaceShip(0, 0);

        fasterFireRate.makeChanges(spaceShip);

        assertEquals(800 / 2, spaceShip.getTimeToWait());
    }
}

