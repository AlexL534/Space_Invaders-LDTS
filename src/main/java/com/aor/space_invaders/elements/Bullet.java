package com.aor.space_invaders.elements;

import com.aor.space_invaders.Position;

public class Bullet extends Element {
    public Bullet(int x1, int x2) {
        super(x1, x2);
    }
    public void spaceshipTick() {
        while(this.getPosition().getY()>0) this.getPosition().setY(this.getPosition().getY() - 1);
    }
    public void alienTick(Position spaceship_position) {
        while(this.getPosition().getY()>spaceship_position.getY()) this.getPosition().setY(this.getPosition().getY() + 1);
    }
}

