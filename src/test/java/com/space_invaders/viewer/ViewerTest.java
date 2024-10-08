package com.space_invaders.viewer;

import com.space_invaders.gui.GUI;
import com.space_invaders.viewer.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ViewerTest {
    @Mock
    private GUI mockedGUI;

    private Viewer<String> viewer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        viewer = new Viewer<String>("TestModel") {
            @Override
            protected void drawElements(GUI gui) {
            }
        };
    }

    @Test
    void testDraw() throws IOException {
        viewer.draw(mockedGUI);
        verify(mockedGUI, times(1)).clear();
        verify(mockedGUI, times(1)).refresh();
    }
}
