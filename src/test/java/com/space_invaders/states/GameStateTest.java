package com.space_invaders.states;

import com.space_invaders.GameManager;
import com.space_invaders.controls.Controller;
import com.space_invaders.controls.game.SpaceController;
import com.space_invaders.model.game.elements.SpaceShip;
import com.space_invaders.model.game.space.LoaderSpaceBuilder;
import com.space_invaders.model.game.space.Space;
import com.space_invaders.states.GameState;
import com.space_invaders.viewer.Viewer;
import com.space_invaders.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameStateTest {

    @Mock
    private Space mockSpace;

    @Mock
    private LoaderSpaceBuilder mockLoaderSpaceBuilder;

    @Mock
    private GameManager mockGameManager;

    @InjectMocks
    private GameState testState;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testResetWithNewSpace() {
        Space previousSpace = mock(Space.class);
        SpaceShip mockSpaceship = mock(SpaceShip.class);
        when(previousSpace.getSpaceship()).thenReturn(mockSpaceship);
        when(mockSpaceship.getScore()).thenReturn(100L);
        GameManager realGameManager = GameManager.getInstance();
        realGameManager.setVelocityMultiplier(1.0);
        Space result = testState.resetWithNewSpace(previousSpace);
        assertEquals(1.5, realGameManager.getVelocityMultiplier(), 0.01);
    }
    @Test
    void testGetViewer() {
        // Act
        Viewer<Space> viewer = testState.getViewer();

        // Assert
        assertNotNull(viewer);
        assertTrue(viewer instanceof GameViewer);
        assertSame(mockSpace, viewer.getModel());
    }

    @Test
    void testGetController() {
        // Act
        Controller<Space> controller = testState.getController();

        // Assert
        assertNotNull(controller);
        assertTrue(controller instanceof SpaceController);
        assertSame(mockSpace, controller.getModel());
    }
}