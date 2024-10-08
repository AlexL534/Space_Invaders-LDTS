<<<<<<< HEAD
package com.aor.space_invaders.model.game.elements.powerups;

import com.aor.space_invaders.model.game.elements.SpaceShip;

public class SlowerFireRate extends PowerUp {
    public SlowerFireRate(int x1, int y1) {
        super(x1, y1);
    }
    private static final double VELOCITY_DIVIDER = 2.0;
    @Override
    public void makeChanges(SpaceShip spaceShip) {
        if (spaceShip.getBullet() != null) {
            spaceShip.getBullet().setVelocity(spaceShip.getBullet().getVelocity() / VELOCITY_DIVIDER);
        }
    }
}
=======
package com.aor.space_invaders.model.game.elements.powerups;

import com.aor.space_invaders.model.game.elements.SpaceShip;

public class SlowerFireRate extends PowerUp {
    public SlowerFireRate(int x1, int y1) {
        super(x1, y1);
    }
    private static final double VELOCITY_DIVIDER = 2.0;
    @Override
    public void makeChanges(SpaceShip spaceShip) {
        //if (spaceShip.getBullet() != null) {
         //   spaceShip.getBullet().setVelocity(spaceShip.getBullet().getVelocity() / VELOCITY_DIVIDER);
        //}
    }
}
>>>>>>> 4f06f33b1ab10fb6901ee4044b250ab34a12b343
