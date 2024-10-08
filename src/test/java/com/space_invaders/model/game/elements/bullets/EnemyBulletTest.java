package com.space_invaders.model.game.elements.bullets;

import com.space_invaders.Position;
import com.space_invaders.model.game.elements.bullets.EnemyBullet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemyBulletTest {

    @Test
    public void testEnemyBulletTick() {
        EnemyBullet enemyBullet = new EnemyBullet(5, 10);

        enemyBullet.tick();

        Position expectedPosition = new Position(5, 11);
        assertEquals(expectedPosition, enemyBullet.getPosition());
    }

    @Test
    public void testEnemyBulletConstructor() {
        EnemyBullet enemyBullet = new EnemyBullet(5, 10);

        assertEquals(5, enemyBullet.getPosition().getX());
        assertEquals(10, enemyBullet.getPosition().getY());
    }
}