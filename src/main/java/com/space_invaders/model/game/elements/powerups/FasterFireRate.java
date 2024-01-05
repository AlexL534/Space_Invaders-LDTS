package com.space_invaders.model.game.elements.powerups;

import com.space_invaders.model.game.elements.SpaceShip;

public class FasterFireRate extends PowerUp {

    public FasterFireRate(int x1, int y1) {
        super(x1, y1);
    }
    @Override
    public void makeChanges(SpaceShip spaceShip) {
       spaceShip.setTimeToWait(spaceShip.getTimeToWait()/2);
    }
}