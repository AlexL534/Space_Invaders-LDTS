package com.space_invaders.model.game.space;
import com.space_invaders.model.game.elements.Alien;
import com.space_invaders.model.game.elements.PowerUpShip;
import com.space_invaders.model.game.elements.SpaceShip;

import java.util.List;
public abstract class SpaceBuilder {
    public Space createSpace() {
            Space space = new Space(getWidth(), getHeight());
            space.setSpaceship(createSpaceship());
            space.setAliens(createAliens());
            space.setPowerUpShips(createPowerUpShips());
            return space;
        }
        protected abstract List<PowerUpShip> createPowerUpShips();
        protected abstract int getWidth();
        protected abstract int getHeight();
        protected abstract List<Alien> createAliens();
        protected abstract SpaceShip createSpaceship();
}