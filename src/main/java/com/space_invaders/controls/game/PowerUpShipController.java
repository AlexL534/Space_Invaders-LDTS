package com.space_invaders.controls.game;

import com.space_invaders.Game;
import com.space_invaders.Music;
import com.space_invaders.MusicManager;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.PowerUpShip;
import com.space_invaders.model.game.elements.powerups.NoPowerUp;
import com.space_invaders.model.game.elements.powerups.PowerUp;
import com.space_invaders.model.game.space.Space;

import java.io.IOException;

public class PowerUpShipController extends GameController {
    Music music;
    boolean flag = false;
    private long lastmovement = 0;
    private long lastDrop = 0;
    private long lastPicked = 0;
    public PowerUpShipController(Space model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION gui, long time) throws IOException {
        if (getModel().getSpaceship().getScore() % 150 == 0 & !flag & getModel().getSpaceship().getScore()>99){
            getModel().addPowerUpShip(new PowerUpShip(0,0));
            music = MusicManager.getInstance().getPowerUpShipAlive();
            music.menustart();
            flag = true;
        }
        if (time - lastmovement > 600) {
            for (PowerUpShip powerUpShip : getModel().getPowerUpShips()) {
                powerUpShip.update();
                if (powerUpShip.getPosition().getX() == getModel().getWidth()) {
                    MusicManager.getInstance().stopPowerShipMusic();
                }
                if (powerUpShip.getPosition().getX() == getModel().getWidth() + 6) {
                    getModel().removePowerUpShip(powerUpShip);
                    MusicManager.getInstance().stopPowerShipMusic();
                    music = MusicManager.getInstance().getPowerUpShipDead();
                    flag = false;
                    break;
                }
            }
            lastmovement = time;
        }
        checkCollisions();
        for (PowerUpShip powerUpShip: getModel().getPowerUpShips()){
            if (powerUpShip.isDropping()){
                if (time - lastDrop > 150) {
                    for (PowerUp powerUp : powerUpShip.getPowerUps()) {
                        powerUp.tick();
                    }
                    lastDrop = time;
                }
            }
        }
        if (time - lastPicked> 100000){
            PowerUp powerUp = new NoPowerUp(-1,-1);
            powerUp.makeChanges(getModel().getSpaceship());
            lastPicked = time;
        }

    }

    public void checkCollisions() {
        if (getModel().getPowerUpShips().isEmpty()) return;
        for (int i = 0; i<getModel().getSpaceship().getBullets().size(); i++){
            if (!getModel().getPowerUpShips().isEmpty() & getModel().getSpaceship().getBullets().get(i).getPosition().equals(getModel().getPowerUpShips().get(0).getPosition()) & !getModel().getPowerUpShips().get(0).isDropping()) {
                if (getModel().getPowerUpShips().get(0).getPowerUps().isEmpty()) getModel().getPowerUpShips().get(0).addPowerUp();
                MusicManager.getInstance().stopPowerShipMusic();
                music = MusicManager.getInstance().getPowerUpShipDead();
                music.start();
                getModel().getPowerUpShips().get(0).drop();
                getModel().getSpaceship().removeBullet(getModel().getSpaceship().getBullets().get(i));
                break;
            }
            else{
                for (PowerUp powerUp : getModel().getPowerUpShips().get(0).getPowerUps()){
                    if (powerUp.getPosition().equals(getModel().getSpaceship().getPosition())){
                        music = MusicManager.getInstance().getPowerUpMusic();
                        music.start();
                        powerUp.makeChanges(getModel().getSpaceship());
                        getModel().getPowerUpShips().get(0).removePowerUp(powerUp);
                        getModel().getPowerUpShips().get(0).setDropping();
                        for (int z = 0; z<5 ; z++) {
                            getModel().getSpaceship().setScore(getModel().getSpaceship().getScore() + 10);
                        }
                        break;
                    }
                    else if (powerUp.getPosition().getY() == 0){
                        getModel().getPowerUpShips().get(0).removePowerUp(powerUp);
                        getModel().getPowerUpShips().get(0).setDropping();
                        break;
                    }
                }
            }
        }
    }
}
