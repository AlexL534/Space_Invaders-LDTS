<<<<<<< HEAD
package com.aor.space_invaders.model.game.elements;

import com.aor.space_invaders.Position;
import com.aor.space_invaders.model.game.elements.powerups.*;

import java.util.Random;

public class PowerUpShip extends Element{
    PowerUp powerUp = null;
    public PowerUpShip(int x, int y) {
        super(x, y);
        Random rng = new Random();
        int random = rng.nextInt(1, 4);
        switch (random) {
            case 1:
                powerUp = new FasterFireRate(x, y);
                break;
            case 2:
                powerUp = new SlowerFireRate(x, y);
                break;
            case 3:
                powerUp = new ExtraLife(x, y);
                break;
            case 4:
                powerUp = new TripleShot(x, y);
        }
    }
    
}
=======
package com.aor.space_invaders.model.game.elements;

import com.aor.space_invaders.Position;
import com.aor.space_invaders.model.game.elements.powerups.*;

import java.util.Random;

public class PowerUpShip extends Element{
    PowerUp powerUp = null;
    public PowerUpShip(int x, int y) {
        super(x, y);
        Random rng = new Random();
        int random = rng.nextInt(1, 4);
        switch (random) {
            case 1:
                powerUp = new FasterFireRate(x, y);
                break;
            case 2:
                powerUp = new SlowerFireRate(x, y);
                break;
            case 3:
                powerUp = new ExtraLife(x, y);
                break;
            case 4:
                powerUp = new TripleShot(x, y);
        }
    }

}
>>>>>>> 4f06f33b1ab10fb6901ee4044b250ab34a12b343
