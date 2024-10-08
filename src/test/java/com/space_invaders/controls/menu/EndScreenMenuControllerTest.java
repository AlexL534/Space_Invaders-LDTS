package com.space_invaders.controls.menu;

import com.space_invaders.Game;
import com.space_invaders.controls.menu.EndScreenMenuController;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.menu.ModelEndScreen;
import com.space_invaders.model.menu.ModelMainMenu;
import com.space_invaders.states.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class EndScreenMenuControllerTest {

    private EndScreenMenuController endScreenMenuController;
    private ModelEndScreen model;

    @BeforeEach
    void setUp() {
        model = new ModelEndScreen();
        endScreenMenuController = new EndScreenMenuController(model);
    }

    /*
    @Test
    void testStepSelectAction() throws IOException, URISyntaxException, FontFormatException {
        Game mockGame = new Game();
        GUI.ACTION selectAction = GUI.ACTION.SELECT;
        model.setPlayerName("Player");
        model.setFinalScore(100);

        endScreenMenuController.step(mockGame, selectAction, 0);

        assertEquals(MainMenuState.class, mockGame.getState().getClass());
    }

     */


    @Test
    void testStepBackspaceAction() throws IOException {
        GUI.ACTION backspaceAction = GUI.ACTION.BACKSPACE;
        model.setPlayerName("Player");

        endScreenMenuController.step(null, backspaceAction, 0);

        assertEquals(6, model.getPlayerName().length());
    }
}