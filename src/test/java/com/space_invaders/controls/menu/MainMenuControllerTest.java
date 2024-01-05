package com.space_invaders.controls.menu;

import com.space_invaders.Game;
import com.space_invaders.controls.menu.MainMenuController;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.menu.ModelMainMenu;
import com.space_invaders.states.GameState;
import com.space_invaders.states.InstructionState;
import com.space_invaders.states.LeaderboardState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MainMenuControllerTest {

    private MainMenuController mainMenuController;
    private ModelMainMenu modelMainMenu;

    @BeforeEach
    void setUp() {
        modelMainMenu = new ModelMainMenu();
        mainMenuController = new MainMenuController(modelMainMenu);
    }

    @Test
    void testStepSelectExit() throws IOException {
        Game mockGame = mock(Game.class);

        mainMenuController.step(mockGame, GUI.ACTION.SELECT, 0);

        assertNull(mockGame.getState()); // Verify that the game state is null for exit
    }
/*
    @Test
    void testStepSelectStart() throws IOException {
        Game mockGame = mock(Game.class);

        mainMenuController.getModel().setSelectedStart(true);
        mainMenuController.step(mockGame, GUI.ACTION.SELECT, 0);

        assertTrue(mockGame.getState() instanceof GameState); // Verify the GameState is set
    }
*/
    // Similar tests for SELECT actions on Instructions and Leaderboard

    @Test
    void testStepUp() {
        // Implement test for UP action
    }

    @Test
    void testStepDown() {
        // Implement test for DOWN action
    }
}
