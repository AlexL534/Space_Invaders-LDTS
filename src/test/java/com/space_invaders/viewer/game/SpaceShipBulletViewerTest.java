package com.space_invaders.viewer.game;

import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.bullets.Bullet;
import com.space_invaders.viewer.game.SpaceShipBulletViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class SpaceShipBulletViewerTest {

    @Test
    public void testDrawMethod() {
        Bullet bullet = Mockito.mock(Bullet.class);
        GUI mockGUI = Mockito.mock(GUI.class);

        SpaceShipBulletViewer spaceShipBulletViewer = new SpaceShipBulletViewer();

        spaceShipBulletViewer.draw(bullet, mockGUI);

        verify(mockGUI).drawSpaceShipBullet(bullet.getPosition());
    }
}