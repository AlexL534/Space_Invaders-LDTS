package com.aor.space_invaders.model.game.elements.powerups;

import com.aor.space_invaders.Position;
import com.aor.space_invaders.model.game.elements.Element;
import com.aor.space_invaders.model.game.elements.SpaceShip;

public abstract class PowerUp extends Element {
    public PowerUp(int x1, int y1) {
        super(x1, y1);
    }
    public abstract void makeChanges(SpaceShip spaceShip);

}
