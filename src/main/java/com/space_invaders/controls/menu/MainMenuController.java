package com.space_invaders.controls.menu;

import com.space_invaders.Game;
import com.space_invaders.controls.Controller;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.space.LoaderSpaceBuilder;
import com.space_invaders.model.menu.ModelInstructionMenu;
import com.space_invaders.model.menu.ModelLeaderboardMenu;
import com.space_invaders.model.menu.ModelMainMenu;
import com.space_invaders.states.GameState;
import com.space_invaders.states.InstructionState;
import com.space_invaders.states.LeaderboardState;

import java.io.IOException;

public class MainMenuController extends Controller<ModelMainMenu> {
    public MainMenuController(ModelMainMenu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new GameState(new LoaderSpaceBuilder(30,20).createSpace()));
                if (getModel().isSelectedInstructions()) game.setState(new InstructionState(new ModelInstructionMenu()));
                if (getModel().isSelectedLeaderboard()) game.setState(new LeaderboardState(new ModelLeaderboardMenu()));
        }
    }
}