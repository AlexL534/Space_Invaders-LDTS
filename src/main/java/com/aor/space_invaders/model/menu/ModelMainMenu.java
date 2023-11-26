package com.aor.space_invaders.model.menu;

import com.googlecode.lanterna.TextColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModelMainMenu implements ModelMenu {
    private final List<MenuOptions> options;
    private int selected;
    private boolean run;

    public ModelMainMenu() {
        run = true;
        options = new ArrayList<>();
    }


        @Override
        public void setRun ( boolean run){
            this.run = run;
        }

        @Override
        public boolean isRunning () {
            return run;
        }
    }
