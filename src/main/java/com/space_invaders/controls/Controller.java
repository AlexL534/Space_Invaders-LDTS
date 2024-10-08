package com.space_invaders.controls;

import com.space_invaders.Game;
import com.space_invaders.gui.GUI;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, GUI.ACTION gui, long time) throws IOException;
}