<<<<<<< HEAD
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
=======
package com.aor.space_invaders.model.game.elements;

import com.aor.space_invaders.Position;

public class Alien extends Element {
    //private Bullet temp_bullet;
    private int direction = 1;
    public Alien(int x1, int x2) {
        super(x1, x2);
    }
    //public void shoot(){
        //if (temp_bullet != null) temp_bullet.alienTick();
    //}
    //public Position getBulletPos(){
     //   assert temp_bullet!= null; return  temp_bullet.getPosition();
    //}
    //public void deleteBullet(Position pos) {
     //   assert temp_bullet!= null; temp_bullet.setPosition(pos);
    //}
    //public void setBulletPos(Position enemyBulletPosition) {
     //   assert temp_bullet!= null; temp_bullet.setPosition(enemyBulletPosition);
    //}
    public void changeDirection(){
        direction*=-1;
    }
    public void update(){
        this.setPosition(new Position(this.getPosition().getX()+direction,this.getPosition().getY()));
    }
}
>>>>>>> 4f06f33b1ab10fb6901ee4044b250ab34a12b343
