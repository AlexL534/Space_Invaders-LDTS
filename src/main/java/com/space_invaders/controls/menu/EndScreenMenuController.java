package com.space_invaders.controls.menu;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.space_invaders.Game;
import com.space_invaders.controls.Controller;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.menu.ModelEndScreen;
import com.space_invaders.model.menu.ModelMainMenu;
import com.space_invaders.states.MainMenuState;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EndScreenMenuController extends Controller<ModelEndScreen> {

    int nameSize;
    int heheheha = 0;

    public EndScreenMenuController(ModelEndScreen model) {
        super(model);
        nameSize = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION gui, long time) throws IOException {
        if (heheheha == 0) {heheheha++;}
        else {
            KeyStroke key = game.getGUI().getChar();
            if (key.getKeyType() == KeyType.Enter) {
                String playername = getModel().getPlayerName();
                long score = getModel().getFinalScore();
                getModel().updateLeaderboard(score, playername);
                game.setState(new MainMenuState(new ModelMainMenu()));
            } else if (key.getKeyType() == KeyType.Character && Character.isLetterOrDigit(key.getCharacter())) {
                getModel().addLetter(key.getCharacter());
            }
            else if (key.getKeyType() == KeyType.Backspace){
                getModel().removeLetter();
            }
        }
    }
}
