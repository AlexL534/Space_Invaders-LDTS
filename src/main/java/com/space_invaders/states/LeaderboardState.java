package com.space_invaders.states;

import com.space_invaders.controls.Controller;
import com.space_invaders.controls.menu.LeaderboardMenuController;
import com.space_invaders.model.menu.ModelLeaderboardMenu;
import com.space_invaders.viewer.Viewer;
import com.space_invaders.viewer.menu.LeaderboardMenuViewer;

public class LeaderboardState extends State<ModelLeaderboardMenu> {

    public LeaderboardState(ModelLeaderboardMenu model) {
        super(model);
    }

    @Override
    public Viewer<ModelLeaderboardMenu> getViewer() {
        return new LeaderboardMenuViewer(getModel());
    }

    @Override
    public Controller<ModelLeaderboardMenu> getController() {
        return new LeaderboardMenuController(getModel());
    }
}