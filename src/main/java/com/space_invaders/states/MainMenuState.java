package com.space_invaders.states;

import com.space_invaders.Music;
import com.space_invaders.MusicManager;
import com.space_invaders.controls.Controller;
import com.space_invaders.controls.menu.MainMenuController;
import com.space_invaders.model.menu.ModelMainMenu;
import com.space_invaders.viewer.Viewer;
import com.space_invaders.viewer.menu.MainMenuViewer;

public class MainMenuState extends State<ModelMainMenu> {
    Music music;
    public MainMenuState(ModelMainMenu model) {
        super(model);
        music = MusicManager.getInstance().getMenuMusic();
        if(!music.isPlaying())
            music.menustart();
    }
    @Override
    public Viewer<ModelMainMenu> getViewer() {
        return new MainMenuViewer(getModel());
    }

    @Override
    public Controller<ModelMainMenu> getController() {
        return new MainMenuController(getModel());
    }

}