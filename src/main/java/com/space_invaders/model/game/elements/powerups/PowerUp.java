package com.space_invaders.model.game.elements.powerups;

import com.space_invaders.Position;
import com.space_invaders.model.game.elements.Element;
import com.space_invaders.model.game.elements.SpaceShip;

public abstract class PowerUp extends Element {
    public PowerUp(int x1, int y1) {
        super(x1, y1);
    }
    public abstract void makeChanges(SpaceShip spaceShip);

    public void tick() {
        setPosition(new Position(getPosition().getX(),getPosition().getY()+1));
    }
}
