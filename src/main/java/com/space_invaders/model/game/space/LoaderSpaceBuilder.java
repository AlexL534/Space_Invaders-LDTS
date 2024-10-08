package com.space_invaders.model.game.space;

import com.space_invaders.model.game.elements.Alien;
import com.space_invaders.model.game.elements.PowerUpShip;
import com.space_invaders.model.game.elements.SpaceShip;

import java.util.ArrayList;
import java.util.List;

public class LoaderSpaceBuilder extends SpaceBuilder{

    private int width;
    private int height;
    private final int numberOfALiens;

    public LoaderSpaceBuilder(int width,int height){
        this.width = width;
        this.height = height;
        numberOfALiens = 45;
    }
    @Override
    public int getWidth() {
        return width;
    }
    @Override
    public int getHeight() {
        return height;
    }
    @Override
    public List<Alien> createAliens() {
        List<Alien> aliens = new ArrayList<>();
        for(int x = 1 ; x<(numberOfALiens/5)*2+1 ; x++){
            if (x%2 == 0){continue;}
            for (int y = 2; y<(numberOfALiens/9)+2;y++){
                Alien alien = new Alien(x,y);
                aliens.add(alien);
            }
        }
        return aliens;
    }

    @Override
    public SpaceShip createSpaceship() {
        return new SpaceShip(width/2,height/2 +7);
    }
    public List<PowerUpShip> createPowerUpShips() {
        List<PowerUpShip> l = new ArrayList<>();
        return l;
    }
}