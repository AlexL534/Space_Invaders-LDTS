package com.space_invaders.model.game.elements.powerups;

import com.space_invaders.model.game.elements.SpaceShip;
import com.space_invaders.model.game.elements.powerups.ExtraLife;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtraLifeTest {

    @Test
    public void testExtraLifeMakeChanges() {
        ExtraLife extraLife = new ExtraLife(5, 10);
        SpaceShip spaceShip = new SpaceShip(0, 0);

        extraLife.makeChanges(spaceShip);

        assertEquals(4, spaceShip.getHP());
    }
}