package com.space_invaders.states;

import com.space_invaders.controls.Controller;
import com.space_invaders.model.menu.ModelLeaderboardMenu;
import com.space_invaders.states.LeaderboardState;
import com.space_invaders.viewer.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LeaderboardStateTest {

    @Mock
    private ModelLeaderboardMenu mockModel;

    private LeaderboardState testState;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        testState = new LeaderboardState(mockModel);
    }

    @Test
    void testGetViewer() {
        Viewer<ModelLeaderboardMenu> viewer = testState.getViewer();

        assertNotNull(viewer);
    }

    @Test
    void testGetController() {
        Controller<ModelLeaderboardMenu> controller = testState.getController();

        assertNotNull(controller);
    }
}