package com.aor.space_invaders.model.game.elements.powerups;

import com.aor.space_invaders.model.game.elements.SpaceShip;

public class TripleShot extends PowerUp{
    public TripleShot(int x1, int y1) {
        super(x1, y1);
    }
    @Override
    public void makeChanges(SpaceShip spaceShip) {
        //shoot 3 bullets instead of 1
    }
}
