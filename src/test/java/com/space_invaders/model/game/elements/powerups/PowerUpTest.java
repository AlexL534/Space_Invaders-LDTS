package com.space_invaders.model.game.elements.powerups;

import com.space_invaders.model.game.elements.SpaceShip;
import com.space_invaders.model.game.elements.powerups.SlowerFireRate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlowerFireRateTest {

    @Test
    public void testMakeChanges() {
        int initialTimeToWait = 1000;
        SpaceShip spaceShip = new SpaceShip(0, 0);
        spaceShip.setTimeToWait(initialTimeToWait);
        SlowerFireRate slowerFireRate = new SlowerFireRate(0, 0);

        slowerFireRate.makeChanges(spaceShip);

        assertEquals(initialTimeToWait * 2, spaceShip.getTimeToWait());
    }
}