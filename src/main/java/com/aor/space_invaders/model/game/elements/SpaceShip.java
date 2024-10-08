<<<<<<< HEAD
package com.aor.space_invaders.model.game.elements;

import com.aor.space_invaders.Position;
import com.aor.space_invaders.model.game.elements.powerups.PowerUp;

public class SpaceShip extends Element {
    private Bullet temp_bullet = null;
    private int lives;
    private PowerUp powerUp = null;
    public SpaceShip(int x1, int x2) {
        super(x1, x2);
        this.lives = 3;
    }
    public Bullet getBullet() {
        return temp_bullet;
    }
    public void removeLife(){
        this.lives--;
    }
    public int getHP() {
        return this.lives;
    }
    public void addBullet(Bullet bullet){temp_bullet = bullet;}
    public void shoot(){
        if (temp_bullet!=null) temp_bullet.spaceshipTick();
    }
    public Position getBulletPos(){
        return temp_bullet.getPosition();
    }
    public void deleteBullet() {
        Position pos = new Position(-1,0);
        temp_bullet.setPosition(pos);
    }
    public void setHP(int i) {
        lives = i;
    }
}
=======
package com.aor.space_invaders.model.game.elements;

import com.aor.space_invaders.Position;
import com.aor.space_invaders.model.game.elements.powerups.PowerUp;

public class SpaceShip extends Element {
    //private Bullet temp_bullet = null;
    private int lives;
    private PowerUp powerUp = null;
    public SpaceShip(int x1, int x2) {
        super(x1, x2);
        this.lives = 3;
    }
    //public Bullet getBullet() { assert temp_bullet!= null; return  temp_bullet;
    //}
    public void removeLife(){
        this.lives--;
    }
    public int getHP() {
        return this.lives;
    }
    //public void addBullet(Bullet bullet){temp_bullet = bullet;}
    //public boolean shoot(){
     //   if (temp_bullet!=null) temp_bullet.spaceshipTick();
      //  return true;
    //}
   // public Position getBulletPos(){
    ///    assert temp_bullet != null; return temp_bullet.getPosition();
    //}
    //public void deleteBullet() {
     //   Position pos = new Position(-1,0);
      //  assert temp_bullet != null;
       // temp_bullet.setPosition(pos);
    //}
    public void setHP(int i) {
        lives = i;
    }
}
>>>>>>> 4f06f33b1ab10fb6901ee4044b250ab34a12b343
