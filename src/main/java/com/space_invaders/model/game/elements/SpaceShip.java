package com.space_invaders.model.game.elements;

import com.space_invaders.model.game.elements.bullets.SpaceShipBullet;
import com.space_invaders.model.game.elements.powerups.PowerUp;

import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends Element {
    PowerUp powerup;
    private long timeToWait;
    private List<SpaceShipBullet> bullets;
    private long score;
    private int lives;

    private int x1,x2;
    public SpaceShip(int x1, int x2) {
        super(x1, x2);
        this.lives = 3;
        bullets = new ArrayList<>();
        score = 0;
        timeToWait = 800;
        powerup = null;
        this.x1 = x1;
        this.x2 = x2;
    }
    public long getTimeToWait(){return timeToWait;}
    public void setTimeToWait(long time){timeToWait = time;}
    public void setPowerup(PowerUp power_up){
        powerup = power_up;
    }
    public PowerUp getPowerUp(){
        return powerup;
    }
    public void addBullet(SpaceShipBullet x){
        bullets.add(x);
    }
    public void removeLife(){
        this.lives--;
    }
    public int getHP() {
        return this.lives;
    }
    public void removeBullet(SpaceShipBullet bullet) {
        bullets.remove(bullet);
    }
    public SpaceShipBullet getBullet(){
        return bullets.get(0);
    }

    public void setHP(int i) {
        lives = i;
    }

    public List<SpaceShipBullet> getBullets() {
        return bullets;
    }

    public long getScore() {
        return score;
    }

    public void addScore() {
        score+=10;
    }

    public void setScore(long score) {
        this.score = score;
    }
    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }
}
