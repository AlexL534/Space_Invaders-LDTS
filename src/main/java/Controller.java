import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.LinkedList;

public class Controller {
    private LinkedList<Bullet> bullets = new LinkedList<Bullet>();
    Bullet temp_bullet;
    public void tick(){
        for (Bullet bullet : bullets) {
            temp_bullet = bullet;
            temp_bullet.tick();
        }
    }
    public void draw(TextGraphics graphics){
        for(int i = 0; i<bullets.size();i++){
            temp_bullet = bullets.get(i);
            temp_bullet.draw(graphics);
        }
    }
    public void addBullet(Bullet b){
        bullets.add(b);
    }
    public void removeBullet(Bullet b){
        bullets.remove(b);
    }

}
