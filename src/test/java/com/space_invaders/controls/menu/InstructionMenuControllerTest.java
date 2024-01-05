package com.space_invaders.controls.menu;

import com.space_invaders.Game;
import com.space_invaders.controls.menu.InstructionMenuController;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.menu.ModelInstructionMenu;
import com.space_invaders.model.menu.ModelMainMenu;
import com.space_invaders.states.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class InstructionMenuControllerTest {

    private InstructionMenuController instructionMenuController;
    private ModelInstructionMenu model;

    @BeforeEach
    void setUp() {
        model = new ModelInstructionMenu();
        instructionMenuController = new InstructionMenuController(model);
    }
/*
    @Test
    void testStepQuitAction() throws IOException {
        Game mockGame = mock(Game.class);
        GUI.ACTION quitAction = GUI.ACTION.QUIT;

        instructionMenuController.step(mockGame, quitAction, 0);

        assertTrue(mockGame.getState() instanceof MainMenuState);
    }

 */
}
