package com.space_invaders.states;

import com.space_invaders.GameManager;
import com.space_invaders.controls.Controller;
import com.space_invaders.controls.game.SpaceController;
import com.space_invaders.model.game.space.LoaderSpaceBuilder;
import com.space_invaders.model.game.space.Space;
import com.space_invaders.viewer.Viewer;
import com.space_invaders.viewer.game.GameViewer;

public class GameState extends State<Space> {
    public GameState(Space space) {
        super(space);
    }

    public Space resetWithNewSpace(Space previousSpace) {
        long score = previousSpace.getSpaceship().getScore();
        Space newSpace = new LoaderSpaceBuilder(30, 20).createSpace();
        newSpace.setSpaceship(previousSpace.getSpaceship());
        newSpace.setScore(score);
        GameManager.getInstance().setVelocityMultiplier(1.5);

        return newSpace;
    }
    @Override
    public Viewer<Space> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    public Controller<Space> getController() {
        return new SpaceController(getModel());
    }
}