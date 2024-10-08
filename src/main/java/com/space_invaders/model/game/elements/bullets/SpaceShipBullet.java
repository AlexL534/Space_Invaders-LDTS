package com.space_invaders.model.game.elements.bullets;

import com.space_invaders.Position;
import com.space_invaders.model.game.elements.SpaceShip;
import com.space_invaders.model.game.elements.powerups.PowerUp;

public class SpaceShipBullet extends Bullet{
    PowerUp powerUp;

    public void tick() {
        setPosition(new Position(getPosition().getX(),getPosition().getY()-1));
    }

    public SpaceShipBullet(int x1, int x2) {
        super(x1, x2);
    }
    public void makeChanges(SpaceShip spaceShip){
        if (spaceShip.getPowerUp() != null) spaceShip.getPowerUp().makeChanges(spaceShip);
    }
}