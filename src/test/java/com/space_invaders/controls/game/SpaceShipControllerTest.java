package com.space_invaders.controls.game;

import com.space_invaders.Game;
import com.space_invaders.Position;
import com.space_invaders.controls.game.SpaceShipController;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.SpaceShip;
import com.space_invaders.model.game.elements.bullets.SpaceShipBullet;
import com.space_invaders.model.game.space.Space;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class SpaceShipControllerTest {
    private SpaceShipController spaceShipController;
    private SpaceShip spaceShip;
    private Space space;

    @BeforeEach
    void setUp() {
        space = new Space(20,30);
        spaceShip = new SpaceShip(5,5);
        space.setSpaceship(spaceShip);
        spaceShipController =new SpaceShipController(space);
    }

    @Test
    void testMoveRight() {
        spaceShipController.moveRight();
        assertEquals(new Position(6, 5), space.getSpaceship().getPosition());
    }



    @Test
    void testMoveLeft() throws IOException {
        spaceShipController.moveLeft();
        assertEquals(new Position(4, 5), space.getSpaceship().getPosition());
    }

    @Test
    void testMoveLeftOnLeftBorder() throws IOException {
        spaceShip.setPosition(new Position (0,0));
        spaceShipController.moveLeft();
        assertEquals(new Position(0, 0), space.getSpaceship().getPosition());
    }

    @Test
    void testMoveLeftOnRightBorder() throws IOException {
        spaceShip.setPosition(new Position (20,0));
        spaceShipController.moveRight();
        assertEquals(new Position(20, 0), space.getSpaceship().getPosition());
    }

    @Test
    void testaddBulletsandFireandMovement() throws IOException {
        spaceShipController.step(mock(Game.class), GUI.ACTION.SPACE,810L);
        Assertions.assertNotNull(spaceShipController.music);
        Assertions.assertNotNull(space.getSpaceship().getBullets());
        Position before = space.getSpaceship().getBullets().get(0).getPosition();
        Position newers = new Position(before.getX(),before.getY()-1);
        spaceShipController.step(mock(Game.class), GUI.ACTION.NONE,820L);
        Assertions.assertNotNull(space.getSpaceship().getBullets());
        Assertions.assertEquals(newers,space.getSpaceship().getBullets().get(0).getPosition());
    }
}