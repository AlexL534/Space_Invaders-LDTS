package com.aor.space_invaders.controls;

import com.aor.space_invaders.Game;
import com.aor.space_invaders.gui.GUI;
import com.googlecode.lanterna.input.KeyStroke;

import javax.swing.*;
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
