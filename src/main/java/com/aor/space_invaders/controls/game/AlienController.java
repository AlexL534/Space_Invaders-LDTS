package com.aor.space_invaders.controls.game;

import com.aor.space_invaders.Game;
import com.aor.space_invaders.Position;
import com.aor.space_invaders.gui.GUI;
import com.aor.space_invaders.model.game.elements.Alien;
import com.aor.space_invaders.model.game.space.Space;

import java.io.IOException;

public class AlienController extends GameController {
    public AlienController(Space space) {
        super(space);
    }
    private long lastMovement;

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 100) {
            for (Alien alien : getModel().getAliens()) {
                alien.update();
                Position first_alien = getModel().getAliens().get(0).getPosition();
                if (first_alien.getX()+getModel().getAliens().size()/5 -1  == getModel().getWidth()-2 || first_alien.getX() == 1){
                    alien.changeDirection();
                }
            }
            this.lastMovement = time;
        }
    }
}
