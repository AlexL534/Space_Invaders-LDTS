package com.aor.space_invaders.model.game.elements.powerups;

import com.aor.space_invaders.model.game.elements.SpaceShip;

public class ExtraLife extends PowerUp{
    public ExtraLife(int x1, int y1) {
        super(x1, y1);
    }
    @Override
    public void makeChanges(SpaceShip spaceShip) {
        spaceShip.setHP(spaceShip.getHP()+1);
    }
}
