package com.aor.space_invaders.model.game.space;

import com.aor.space_invaders.model.game.elements.Alien;
import com.aor.space_invaders.model.game.elements.SpaceShip;

import java.util.ArrayList;
import java.util.List;

public class LoaderSpaceBuilder extends SpaceBuilder{

    private int width;
    private int height;
    private final int numberOfALiens;

    public LoaderSpaceBuilder(int width,int height){
        this.width = width;
        this.height = height;
        numberOfALiens = 55; //number of aliens in the game, 11 rows of 5 aliens.
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
        for(int x = 1 ; x<(numberOfALiens/5)+1 ; x++){
            for (int y = 2; y<(numberOfALiens/11)+2;y++){
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

    public int getNumberOfAliens() {
        return numberOfALiens;
    }
}
