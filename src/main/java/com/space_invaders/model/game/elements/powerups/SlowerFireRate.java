package com.space_invaders.model.game.elements.powerups;

import com.space_invaders.model.game.elements.SpaceShip;

public class SlowerFireRate extends PowerUp {
    public SlowerFireRate(int x1, int y1) {
        super(x1, y1);
    }
    @Override
    public void makeChanges(SpaceShip spaceShip) {
        spaceShip.setTimeToWait(spaceShip.getTimeToWait()*2);
    }
}