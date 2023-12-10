package com.aor.space_invaders.viewer.menu;

import com.aor.space_invaders.Position;
import com.aor.space_invaders.gui.GUI;
import com.aor.space_invaders.model.menu.ModelInstructionMenu;
import com.aor.space_invaders.model.menu.ModelMainMenu;
import com.aor.space_invaders.viewer.Viewer;

public class InstructionMenuViewer extends Viewer<ModelInstructionMenu> {
    public InstructionMenuViewer(ModelInstructionMenu menu) {
        super(menu);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "InstructionMenu", "#FFFFFF");
    }
}
