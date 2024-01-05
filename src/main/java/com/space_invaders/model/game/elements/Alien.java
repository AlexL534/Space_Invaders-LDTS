package com.space_invaders.model.game.elements;

import com.space_invaders.Position;
import com.space_invaders.model.game.elements.bullets.EnemyBullet;

import java.util.ArrayList;
import java.util.List;

public class Alien extends Element {
    private List<EnemyBullet> bullets;
    private int direction = 1;

    private int x1,x2;
    public Alien(int x1, int x2) {
        super(x1, x2);
        bullets = new ArrayList<>(); {
        }
        this.x1 = x1;
        this.x2 = x2;
    }
    public List<EnemyBullet> getBullets() {
        return bullets;
    }
    public void addBullet(EnemyBullet x){
        bullets.add(x);
    }
    public void removeBullet(EnemyBullet bullet) {
        bullets.remove(bullet);
    }
    public void changeDirection(){
        direction*=-1;
    }
    public void update(){
        this.setPosition(new Position(this.getPosition().getX()+direction,this.getPosition().getY()));
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getDirection() {
        return direction;
    }
}
