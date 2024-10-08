package com.space_invaders.model.game.elements;

import com.space_invaders.Position;
import com.space_invaders.model.game.elements.Alien;
import com.space_invaders.model.game.elements.bullets.EnemyBullet;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AlienTest {

    @Test
    public void testAddBullet() {
        Alien alien = new Alien(10, 20);
        EnemyBullet bullet = mock(EnemyBullet.class);
        alien.addBullet(bullet);

        List<EnemyBullet> bullets = alien.getBullets();

        assertEquals(1, bullets.size());
        assertEquals(bullet, bullets.get(0));
    }

    @Test
    public void testRemoveBullet() {
        Alien alien = new Alien(10, 20);
        EnemyBullet bullet = mock(EnemyBullet.class);
        alien.addBullet(bullet);

        alien.removeBullet(bullet);

        List<EnemyBullet> bullets = alien.getBullets();
        assertEquals(0, bullets.size());
    }

    @Test
    public void testChangeDirection() {
        Alien alien = new Alien(10, 20);
        alien.changeDirection();
        assertEquals(-1, alien.getDirection());

        alien.changeDirection();
        assertEquals(1, alien.getDirection());
    }

    @Test
    public void testUpdate() {
        Alien alien = new Alien(10, 20);
        Position initialPosition = alien.getPosition();

        alien.update();

        assertEquals(initialPosition.getX() + alien.getDirection(), alien.getPosition().getX());
        assertEquals(initialPosition.getY(), alien.getPosition().getY());
    }
}