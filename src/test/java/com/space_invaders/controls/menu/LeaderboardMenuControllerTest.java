package com.space_invaders.controls.menu;

import com.space_invaders.Game;
import com.space_invaders.controls.menu.LeaderboardMenuController;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.menu.ModelLeaderboardMenu;
import com.space_invaders.model.menu.ModelMainMenu;
import com.space_invaders.states.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class LeaderboardMenuControllerTest {

    private LeaderboardMenuController leaderboardMenuController;
    private ModelLeaderboardMenu model;

    @BeforeEach
    void setUp() {
        model = new ModelLeaderboardMenu();
        leaderboardMenuController = new LeaderboardMenuController(model);
    }
    /*
    @Test
    void testStepQuitAction() throws IOException, URISyntaxException, FontFormatException {
        Game mockGame = new Game();
        GUI.ACTION quitAction = GUI.ACTION.QUIT;

        leaderboardMenuController.step(mockGame, quitAction, 0);

        assertTrue(mockGame.getState() instanceof MainMenuState);
    }

     */


}