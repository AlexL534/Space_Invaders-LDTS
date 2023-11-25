package com.aor.space_invaders.model.game.space;

import com.aor.space_invaders.elements.Alien;
import com.aor.space_invaders.elements.SpaceShip;

import java.util.ArrayList;
import java.util.List;

public class LoaderSpaceBuilder extends SpaceBuilder{

    private final int width;
    private final int height;
    private final int numberOfALiens;

    public LoaderSpaceBuilder(int width,int height){
        this.width = width;
        this.height = height;
        numberOfALiens = 55; //number of aliens in the game, 5 rows of 11 aliens.
    }
    @Override
    protected int getWidth() {
        return width;
    }
    @Override
    protected int getHeight() {
        return height;
    }
    @Override
    protected List<Alien> createAliens() {
        List<Alien> aliens = new ArrayList<>();
        for(int x = 1 ; x<(numberOfALiens/11)+1 ; x++){
            for (int y = 2; y<(numberOfALiens/5)+2;y++){
                Alien alien = new Alien(x,y);
                aliens.add(alien);
            }
        }
        return aliens;
    }

    @Override
    protected SpaceShip createSpaceship() {
        return new SpaceShip(width/2 ,height - 3);
    }
}
