package com.space_invaders.controls.game;

import com.space_invaders.Game;
import com.space_invaders.Music;
import com.space_invaders.MusicManager;
import com.space_invaders.Position;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.bullets.SpaceShipBullet;
import com.space_invaders.model.game.space.Space;

import java.io.IOException;

public class SpaceShipController extends GameController {
    Music music;
    private long lastMovement;
    private long lastShoot;
    public SpaceShipController(Space model) {
        super(model);
    }
    public void moveRight(){
        Position temp = getModel().getSpaceship().getPosition();
        moveSpaceShip(new Position(temp.getX()+1,temp.getY()));
    }
    private void addBulletsAndFire() {
        getModel().getSpaceship().addBullet(new SpaceShipBullet(getModel().getSpaceship().getPosition().getX(),getModel().getSpaceship().getPosition().getY()));
        for (SpaceShipBullet bullet : getModel().getSpaceship().getBullets()){
            bullet.tick();
        }
    }
    private void moveBullets() {
        for (SpaceShipBullet bullet : getModel().getSpaceship().getBullets()){
            bullet.tick();
        }
    }

    public void moveLeft() {
        Position temp = getModel().getSpaceship().getPosition();
        moveSpaceShip(new Position(temp.getX()-1,temp.getY()));
    }
    private void moveSpaceShip(Position position) {
        if (position.getX() < getModel().getWidth() - 2  && position.getX() > 0) {
            getModel().getSpaceship().setPosition(position);
        }
    }
    @Override
    public void step(Game game, GUI.ACTION action , long time) throws IOException {
        if (action == GUI.ACTION.RIGHT) moveRight();
        else if (action == GUI.ACTION.LEFT) moveLeft();
        else if (action == GUI.ACTION.SPACE){

            if (time - lastShoot > getModel().getSpaceship().getTimeToWait()) {
                 addBulletsAndFire();
                 music = MusicManager.getInstance().getShootMusic();
                 music.start();
                this.lastShoot=time;
            }
        }
        else if(time-lastMovement>10){
            moveBullets();
            this.lastMovement=time;
        }
    }



}