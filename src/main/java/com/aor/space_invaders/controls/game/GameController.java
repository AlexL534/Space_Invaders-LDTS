package com.aor.space_invaders.controls.game;

import com.aor.space_invaders.controls.Controller;
import com.aor.space_invaders.model.game.space.Space;

public abstract class GameController extends Controller<Space> {
    public GameController(Space space) {
        super(space);
    }
}
