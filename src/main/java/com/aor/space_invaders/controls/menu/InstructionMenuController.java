package com.aor.space_invaders.controls.menu;

import com.aor.space_invaders.Game;
import com.aor.space_invaders.controls.Controller;
import com.aor.space_invaders.gui.GUI;
import com.aor.space_invaders.model.menu.ModelInstructionMenu;
import com.aor.space_invaders.model.menu.ModelMainMenu;
import com.aor.space_invaders.states.MainMenuState;

import java.io.IOException;

public class InstructionMenuController extends Controller<ModelInstructionMenu> {
    public InstructionMenuController(ModelInstructionMenu model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION gui, long time) throws IOException {
        if (gui == GUI.ACTION.SELECT) game.setState(new MainMenuState(new ModelMainMenu()));
    }
}
