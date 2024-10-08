package com.aor.space_invaders.viewer.menu;

import com.aor.space_invaders.Position;
import com.aor.space_invaders.gui.GUI;
import com.aor.space_invaders.model.menu.ModelMainMenu;
import com.aor.space_invaders.model.menu.ModelMenu;
import com.aor.space_invaders.viewer.Viewer;

public class MainMenuViewer extends Viewer<ModelMainMenu> {

    public MainMenuViewer(ModelMainMenu menu) {
        super(menu);
    }

        @Override
        public void drawElements(GUI gui) {
            gui.drawText(new Position(5, 5), "Menu", "#FFFFFF");
            for (int i = 0; i < getModel().getNumberEntries(); i++)
                gui.drawText(
                        new Position(5, 7 + i),
                        getModel().getEntry(i),
                        getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
}
