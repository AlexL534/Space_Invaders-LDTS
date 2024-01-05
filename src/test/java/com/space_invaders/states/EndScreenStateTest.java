package com.space_invaders.states;

import com.space_invaders.controls.Controller;
import com.space_invaders.model.menu.ModelEndScreen;
import com.space_invaders.states.EndScreenState;
import com.space_invaders.viewer.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.*;

public class EndScreenStateTest {

    @Mock
    private ModelEndScreen mockModel;

    @InjectMocks
    private EndScreenState testState;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetViewer() {
        Viewer<ModelEndScreen> viewer = testState.getViewer();

        assertNotNull(viewer);
    }

    @Test
    public void testGetController() {
        Controller<ModelEndScreen> controller = testState.getController();

        assertNotNull(controller);
    }
}