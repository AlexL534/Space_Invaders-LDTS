package com.space_invaders.model.game.elements.bullets;


import com.space_invaders.Position;

public class EnemyBullet extends Bullet{

    public void tick() {
        setPosition(new Position(getPosition().getX(),getPosition().getY()+1));
    }

    public EnemyBullet(int x1, int x2) {
        super(x1, x2);
    }
}
