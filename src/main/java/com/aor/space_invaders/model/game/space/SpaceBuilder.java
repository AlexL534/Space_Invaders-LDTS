package com.aor.space_invaders.model.game.space;
import com.aor.space_invaders.model.game.elements.Alien;
import com.aor.space_invaders.model.game.elements.SpaceShip;

import java.util.List;
public abstract class SpaceBuilder {
    public Space createSpace() {
            Space space = new Space(getWidth(), getHeight());
            space.setSpaceship(createSpaceship());
            space.setAliens(createAliens());
            return space;
        }
        protected abstract int getWidth();
        protected abstract int getHeight();
        protected abstract List<Alien> createAliens();
        protected abstract SpaceShip createSpaceship();
}
