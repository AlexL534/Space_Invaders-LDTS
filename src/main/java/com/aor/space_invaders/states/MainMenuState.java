package com.aor.space_invaders.states;

import com.aor.space_invaders.controls.Controller;
import com.aor.space_invaders.controls.menu.MainMenuController;
import com.aor.space_invaders.model.game.space.Space;
import com.aor.space_invaders.model.menu.ModelMainMenu;
import com.aor.space_invaders.viewer.Viewer;
import com.aor.space_invaders.viewer.menu.MainMenuViewer;

public class MainMenuState extends State<ModelMainMenu> {
    public MainMenuState(ModelMainMenu model) {
        super(model);
    }
    @Override
    protected Viewer<ModelMainMenu> getViewer() {
        return new MainMenuViewer(getModel());
    }

    @Override
    protected Controller<ModelMainMenu> getController() {
        return new MainMenuController(getModel());
    }
}
