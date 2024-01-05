package com.space_invaders.states;

import com.space_invaders.controls.Controller;
import com.space_invaders.model.menu.ModelInstructionMenu;
import com.space_invaders.states.InstructionState;
import com.space_invaders.viewer.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InstructionStateTest {

    @Mock
    private ModelInstructionMenu mockModel;

    @InjectMocks
    private InstructionState testState;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetViewer() {
        Viewer<ModelInstructionMenu> viewer = testState.getViewer();

        assertNotNull(viewer);
    }

    @Test
    public void testGetController() {
        Controller<ModelInstructionMenu> controller = testState.getController();

        assertNotNull(controller);
    }
}