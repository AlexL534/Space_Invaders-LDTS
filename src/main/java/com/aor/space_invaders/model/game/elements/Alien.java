package com.aor.space_invaders.model.game.elements;

import com.aor.space_invaders.Position;

public class Alien extends Element {
    Bullet temp_bullet;
    public Alien(int x1, int x2) {
        super(x1, x2);
    }
    public void shoot(){
        if (temp_bullet != null) temp_bullet.alienTick();
    }
    public Position getBulletPos(){
        return temp_bullet.getPosition();
    }
    public void deleteBullet(Position pos) {
        temp_bullet.setPosition(pos);
    }
}
