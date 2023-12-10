package com.aor.space_invaders.controls.game;

import com.aor.space_invaders.Game;
import com.aor.space_invaders.gui.GUI;
import com.aor.space_invaders.model.game.elements.SpaceShip;
import com.aor.space_invaders.model.game.space.Space;
import com.aor.space_invaders.model.menu.ModelMainMenu;
import com.aor.space_invaders.states.MainMenuState;

import java.io.IOException;

public class SpaceController extends GameController {
    private final SpaceShipController spaceShipController;
    private final AlienController alienController;

    public SpaceController(Space space) {
        super(space);

        this.spaceShipController = new SpaceShipController(space);
        this.alienController = new AlienController(space);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getSpaceship().getHP() == 0)
            game.setState(new MainMenuState(new ModelMainMenu()));
        else {
            spaceShipController.step(game, action, time);
            alienController.step(game, action, time);
        }
    }
}