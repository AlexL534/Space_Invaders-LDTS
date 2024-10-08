package com.space_invaders.controls.game;

import com.space_invaders.Game;
import com.space_invaders.MusicManager;
import com.space_invaders.Position;
import com.space_invaders.controls.game.PowerUpShipController;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.PowerUpShip;
import com.space_invaders.model.game.elements.SpaceShip;
import com.space_invaders.model.game.elements.bullets.SpaceShipBullet;
import com.space_invaders.model.game.elements.powerups.PowerUp;
import com.space_invaders.model.game.space.LoaderSpaceBuilder;
import com.space_invaders.model.game.space.Space;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PowerUpShipControllerTest {
    private PowerUpShipController powerUpShipController;
    private Space space;

    @BeforeEach
    void setUp() {
        space = new LoaderSpaceBuilder(20,30).createSpace();
        powerUpShipController =new PowerUpShipController(space);
    }

    @Test
    public void stepTestFirst() throws IOException {
        space.getSpaceship().setScore(150);
        powerUpShipController.step(mock(Game.class),GUI.ACTION.NONE,0L);
        Assertions.assertNotNull(space.getPowerUpShips().get(0));
        Position initial = new Position(0,0);
        Assertions.assertNotNull(powerUpShipController.music);
        Assertions.assertEquals(initial,space.getPowerUpShips().get(0).getPosition());
        powerUpShipController.step(mock(Game.class),GUI.ACTION.NONE,700L);
        Assertions.assertTrue(powerUpShipController.flag);
        Position after = new Position(1,0);
        Assertions.assertEquals(after,space.getPowerUpShips().get(0).getPosition());
        space.getPowerUpShips().get(0).setPosition(new Position(space.getWidth()+1,0));
        Assertions.assertFalse(MusicManager.getInstance().getPowerUpMusic().isPlaying());

    }
    @Test
    public void checkCollisionsTest() throws IOException{
        space.getSpaceship().setScore(150);
        powerUpShipController.step(mock(Game.class),GUI.ACTION.NONE,330L);
        Position helper = space.getPowerUpShips().get(0).getPosition();
        space.getSpaceship().addBullet(new SpaceShipBullet(helper.getX(),helper.getY()));
        Assertions.assertEquals(space.getPowerUpShips().get(0).getPosition(), space.getSpaceship().getBullets().get(0).getPosition());
        Assertions.assertFalse(space.getPowerUpShips().get(0).isDropping());
        Assertions.assertNotNull(space.getPowerUpShips());
    }

}