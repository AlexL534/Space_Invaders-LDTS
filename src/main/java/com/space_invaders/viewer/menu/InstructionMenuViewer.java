package com.space_invaders.viewer.menu;

import com.space_invaders.Position;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.menu.ModelInstructionMenu;
import com.space_invaders.viewer.Viewer;

public class InstructionMenuViewer extends Viewer<ModelInstructionMenu> {
    public InstructionMenuViewer(ModelInstructionMenu menu) {
        super(menu);
    }
    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(0, 1), "    I N S T R U C T I O N S    ", "#FFFFFF");
        gui.drawText(new Position(0, 3), "       GAME OBJECTIVE:         ", "#FFFFFF");
        gui.drawText(new Position(0, 4), "   Protect Earth from aliens   ", "#FFFFFF");
        gui.drawText(new Position(0, 5), "    by using your spaceship   ", "#FFFFFF");
        gui.drawText(new Position(0, 6), "     to destroy them while        ", "#FFFFFF");
        gui.drawText(new Position(0, 7), "      dodging their shots.      ", "#FFFFFF");
        gui.drawText(new Position(0, 8), "    Avoid getting hit three   ", "#FFFFFF");
        gui.drawText(new Position(0, 9), "     times and letting them  ", "#FFFFFF");
        gui.drawText(new Position(0, 10), "       reach the bottom!            ", "#FFFFFF");
        gui.drawText(new Position(0, 13), "     GAMEPLAY CONTROLS:        ", "#FFFFFF");
        gui.drawText(new Position(0, 14), " ARROW_LEFT  --> MOVE LEFT      ", "#FFFFFF");
        gui.drawText(new Position(0, 15), " ARROW_RIGHT --> MOVE RIGHT     ", "#FFFFFF");
        gui.drawText(new Position(0, 16), " SPACE BAR   --> SHOOTING      ", "#FFFFFF");
        gui.drawText(new Position(0, 17), " ENTER       --> SELECT       ", "#FFFFFF");
        gui.drawText(new Position(0, 18), " ESC         --> GO BACK      ", "#FFFFFF");
        gui.drawText(new Position(0, 19), "   ", "#FFFFFF");

    }
}