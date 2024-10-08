package com.space_invaders.viewer.game;

import com.space_invaders.Position;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.bullets.Bullet;
import com.space_invaders.viewer.game.EnemyBulletViewer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class EnemyBulletViewerTest {

    @Test
    public void testDrawEnemyBullet() {
        Bullet bullet = Mockito.mock(Bullet.class);
        GUI mockGUI = Mockito.mock(GUI.class);

        EnemyBulletViewer enemyBulletViewer = new EnemyBulletViewer();

        Position position = new Position(30, 40);
        Mockito.when(bullet.getPosition()).thenReturn(position);

        enemyBulletViewer.draw(bullet, mockGUI);

        Mockito.verify(mockGUI).drawAlienBullet(position);
    }
}