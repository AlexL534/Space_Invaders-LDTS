package com.aor.space_invaders;
import com.aor.space_invaders.gui.LGUI;
import com.aor.space_invaders.model.menu.ModelMainMenu;
import com.aor.space_invaders.model.menu.ModelMenu;
import com.aor.space_invaders.states.MainMenuState;
import com.aor.space_invaders.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class Game {
    private final LGUI gui;
    private State state;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LGUI(30,20);
        this.state = new MainMenuState(new ModelMainMenu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }
}
