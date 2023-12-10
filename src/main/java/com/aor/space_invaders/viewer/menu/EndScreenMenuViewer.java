package com.aor.space_invaders.viewer.menu;

import com.aor.space_invaders.Position;
import com.aor.space_invaders.gui.GUI;
import com.aor.space_invaders.model.menu.ModelEndScreen;
import com.aor.space_invaders.viewer.Viewer;

public class EndScreenMenuViewer extends Viewer<ModelEndScreen> {
    public EndScreenMenuViewer(ModelEndScreen model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "EndScreenMenu", "#FFFFFF");
    }
}
