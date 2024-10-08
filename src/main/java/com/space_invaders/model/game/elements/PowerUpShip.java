package com.space_invaders.model.game.elements;

import com.space_invaders.Music;
import com.space_invaders.Position;
import com.space_invaders.model.game.elements.powerups.*;
import com.space_invaders.model.game.elements.powerups.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PowerUpShip extends Element{
    Music music;
    List<PowerUp> powerUps = new ArrayList<>();
    private boolean isdropping = false;
    public PowerUpShip(int x, int y) {
        super(x, y);
    }
    public void update(){
        this.setPosition(new Position(this.getPosition().getX()+1,this.getPosition().getY()));
    }
    public boolean isDropping(){
        return isdropping;
    }
    public void setDropping(){
        isdropping = false;
    }
    public List<PowerUp> getPowerUps(){
        return powerUps;
    }
    public void removePowerUp(PowerUp p){
        powerUps.remove(p);
    }
    public void addPowerUp(){
        Random rng = new Random();
        int random = rng.nextInt(3) + 1;
        switch (random) {
            case 1:
                powerUps.add(new FasterFireRate(this.getPosition().getX(), this.getPosition().getY()));
                break;
            case 2:
                powerUps.add(new SlowerFireRate(this.getPosition().getX(), this.getPosition().getY()));
                break;
            case 3:
                powerUps.add(new ExtraLife(this.getPosition().getX(), this.getPosition().getY()));
                break;
        }
    }

    public void drop(){
        if (!powerUps.isEmpty()) {
            powerUps.get(0).tick();
            isdropping = true;
        }
    }

}