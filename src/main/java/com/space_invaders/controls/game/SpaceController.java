package com.space_invaders.controls.game;

import com.space_invaders.Game;
import com.space_invaders.Music;
import com.space_invaders.MusicManager;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.space.Space;
import com.space_invaders.model.menu.ModelEndScreen;
import com.space_invaders.model.menu.ModelMainMenu;
import com.space_invaders.states.EndScreenState;
import com.space_invaders.states.GameState;
import com.space_invaders.states.MainMenuState;

import java.io.IOException;

public class SpaceController extends GameController {
    private final SpaceShipController spaceShipController;
    private final AlienController alienController;
    private final PowerUpShipController powerupshipController;
    private int nOfAliens = 45;
    private int pointsToAdd = 10;
    Music music;
    Game game;

    private long calculateFinalScore() {
        return getModel().getSpaceship().getScore();
    }
    public void verifySpaceshipBullets() {
        for(int j = 0; j<getModel().getAliens().size(); j++){
            for (int i = 0; i<getModel().getSpaceship().getBullets().size(); i++){
                if (getModel().getSpaceship().getBullets().get(i).getPosition().equals(getModel().getAliens().get(j).getPosition())){
                    getModel().getAliens().remove(getModel().getAliens().get(j));
                    getModel().getSpaceship().removeBullet(getModel().getSpaceship().getBullets().get(i));
                    getModel().getSpaceship().addScore();
                    music = MusicManager.getInstance().getAlienKilledMusic();
                    music.start();
                    nOfAliens--;
                    break;
                }
            }
        }
    }

    private int getNumberOfAliens() {
        return nOfAliens;
    }


    public SpaceController(Space space) {
        super(space);
        this.spaceShipController = new SpaceShipController(space);
        this.alienController = new AlienController(space);
        this.powerupshipController = new PowerUpShipController(space);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT )
            game.setState(new MainMenuState(new ModelMainMenu()));
        else if (getModel().getSpaceship().getHP() == 0) {
            long finalScore = calculateFinalScore();
            ModelEndScreen endScreen = new ModelEndScreen();
            endScreen.setFinalScore(finalScore);
            MusicManager.getInstance().stopPowerShipMusic();
            game.setState(new EndScreenState(endScreen));
        }
        else {
            powerupshipController.step(game,action,time);
            spaceShipController.step(game, action, time);
            alienController.step(game, action, time);
            verifySpaceshipBullets();
            if (getNumberOfAliens() == 0) {
                music = MusicManager.getInstance().getRoundClearMusic();
                music.start();
                Space newSpace = ((GameState) game.getState()).resetWithNewSpace(getModel());
                game.setState(new GameState(newSpace));
            }
        }
    }
}