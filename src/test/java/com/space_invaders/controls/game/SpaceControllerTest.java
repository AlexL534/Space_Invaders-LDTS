package com.space_invaders.controls.game;

import com.space_invaders.Game;
import com.space_invaders.Position;
import com.space_invaders.controls.game.SpaceController;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.bullets.SpaceShipBullet;
import com.space_invaders.model.game.space.LoaderSpaceBuilder;
import com.space_invaders.model.game.space.Space;
import com.space_invaders.model.menu.ModelEndScreen;
import com.space_invaders.model.menu.ModelMainMenu;
import com.space_invaders.states.EndScreenState;
import com.space_invaders.states.GameState;
import com.space_invaders.states.MainMenuState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.mockito.Mockito.*;

class SpaceControllerTest {
    private SpaceController spaceController;
    Space mockSpace;
    private Game mockGame;

    @BeforeEach
    void setUp() {
        mockSpace = new LoaderSpaceBuilder(20,30).createSpace();
        spaceController = new SpaceController(mockSpace);
        mockGame = mock(Game.class);
    }

    @Test
    void testGameOverStateWhenSpaceshipHPZero() throws IOException {
        spaceController.getModel().getSpaceship().setHP(0);
        spaceController.step(mockGame, GUI.ACTION.NONE,0L);
        Mockito.when(mockGame.getState()).thenReturn(new EndScreenState(mock(ModelEndScreen.class)));
        Assertions.assertTrue(mockGame.getState() instanceof EndScreenState);
    }

    @Test
    void testMainMenuStateWhenQuitAction() throws IOException, InstantiationException, IllegalAccessException {
        spaceController.step(mockGame, GUI.ACTION.QUIT,0L);
        Mockito.when(mockGame.getState()).thenReturn(new MainMenuState(mock(ModelMainMenu.class)));
        Assertions.assertTrue(mockGame.getState() instanceof MainMenuState);
    }

    @Test
    void testInteractionsWithAliens() throws IOException {
        spaceController.step(mockGame, GUI.ACTION.NONE,1L);
        Assertions.assertFalse(spaceController.getModel().getAliens().isEmpty());

    }

    @Test
    void testSpaceShipBullets() throws IOException {
        Position help = spaceController.getModel().getAliens().get(0).getPosition();
        spaceController.getModel().getSpaceship().addBullet(new SpaceShipBullet(help.getX(),help.getY()));
        spaceController.step(mockGame, GUI.ACTION.QUIT,0L);
        Mockito.when(mockGame.getState()).thenReturn(new MainMenuState(mock(ModelMainMenu.class)));
    }
}