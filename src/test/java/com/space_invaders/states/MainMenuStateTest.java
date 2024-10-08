package com.space_invaders.states;

import com.space_invaders.controls.Controller;
import com.space_invaders.model.menu.ModelMainMenu;
import com.space_invaders.states.MainMenuState;
import com.space_invaders.viewer.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MainMenuStateTest {

    @Mock
    private ModelMainMenu mockModel;


    private MainMenuState testState;

    @BeforeEach
    void setUp() {
        testState = new MainMenuState(mockModel);
    }

    @Test
    void testGetViewer() {
        Viewer<ModelMainMenu> viewer = testState.getViewer();

        assertNotNull(viewer);
    }

    @Test
    void testGetController() {
        Controller<ModelMainMenu> controller = testState.getController();

        assertNotNull(controller);
    }
}