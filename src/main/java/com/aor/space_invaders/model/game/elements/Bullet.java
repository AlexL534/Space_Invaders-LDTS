package com.aor.space_invaders.model.game.elements;

import com.aor.space_invaders.Position;
import com.aor.space_invaders.model.game.elements.powerups.PowerUp;

public class Bullet extends Element {
    public double velocity = 110.0;
    private long timePassed;
    private long timeWait;
    private boolean playerShot = false;
    public double getVelocity(){return velocity;}
    public void setVelocity(double velocity){this.velocity = velocity;}
    public boolean isShootTime(long dt){
        timePassed += dt;
        if(timePassed >= timeWait){
            timePassed = 0;
            return true;
        }
        return false;
    }
    public void setTimeWait(long timeWait){this.timeWait = timeWait;}
    public long getTimeWait(){return timeWait;}
    public void setPlayerShot(boolean playerShot) {
        this.playerShot = playerShot;
    }
    public boolean isPlayerShot() {
        return playerShot;
    }

    public Bullet(int x1, int x2) {
        super(x1, x2);
    }

    public void spaceshipTick() {
        //shots of spaceship
    }

    public void alienTick() {
        //shots of aliens
    }
}

