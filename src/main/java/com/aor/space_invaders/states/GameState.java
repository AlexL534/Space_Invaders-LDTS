package com.aor.space_invaders.states;

import com.aor.space_invaders.controls.Controller;
import com.aor.space_invaders.controls.game.SpaceController;
import com.aor.space_invaders.model.game.space.Space;
import com.aor.space_invaders.viewer.Viewer;
import com.aor.space_invaders.viewer.game.GameViewer;

public class GameState extends State<Space> {
    public GameState(Space space) {
        super(space);
    }

    @Override
    protected Viewer<Space> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Space> getController() {
        return new SpaceController(getModel());
    }
}
