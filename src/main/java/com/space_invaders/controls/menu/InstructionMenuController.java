package com.space_invaders.controls.menu;

import com.space_invaders.Game;
import com.space_invaders.controls.Controller;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.menu.ModelInstructionMenu;
import com.space_invaders.model.menu.ModelMainMenu;
import com.space_invaders.states.MainMenuState;

import java.io.IOException;

public class InstructionMenuController extends Controller<ModelInstructionMenu> {
    public InstructionMenuController(ModelInstructionMenu model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION gui, long time) throws IOException {
        if (gui == GUI.ACTION.QUIT) game.setState(new MainMenuState(new ModelMainMenu()));
    }
}