package com.aor.space_invaders.model.game.elements;

import com.aor.space_invaders.Position;

public class SpaceShip extends Element {
    Bullet temp_bullet;
    private int health;
    public SpaceShip(int x1, int x2) {
        super(x1, x2);
        this.health = 3;
    }
    public void removeLife(){
        this.health--;
    }
    public int getHP() {
        return this.health;
    }
    public void shoot(){
        temp_bullet.spaceshipTick();
    }
    public Position getBulletPos(){
        return temp_bullet.getPosition();
    }

    public void deleteBullet() {
        Position pos = new Position(-1,0);
        temp_bullet.setPosition(pos);
    }
}
