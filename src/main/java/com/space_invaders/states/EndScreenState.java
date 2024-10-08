package com.space_invaders.states;

import com.space_invaders.Music;
import com.space_invaders.MusicManager;
import com.space_invaders.controls.Controller;
import com.space_invaders.controls.menu.EndScreenMenuController;
import com.space_invaders.model.menu.ModelEndScreen;
import com.space_invaders.viewer.Viewer;
import com.space_invaders.viewer.menu.EndScreenMenuViewer;

public class EndScreenState extends State<ModelEndScreen>{
    Music music;
    public EndScreenState(ModelEndScreen model) {
        super(model);
        MusicManager.getInstance().stopMenuMusic();
        music = MusicManager.getInstance().getGameOverMusic();
        music.start();
    }

    @Override
    public Viewer<ModelEndScreen> getViewer() {
        return new EndScreenMenuViewer(getModel());
    }

    @Override
    public Controller<ModelEndScreen> getController() {
        return new EndScreenMenuController(getModel());
    }
}