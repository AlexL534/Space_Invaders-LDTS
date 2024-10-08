package com.space_invaders.viewer.menu;

import com.space_invaders.Position;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.menu.ModelMainMenu;
import com.space_invaders.viewer.menu.MainMenuViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MainMenuViewerTest {

    @Test
    public void testDrawElements() {
        GUI mockGUI = Mockito.mock(GUI.class);
        ModelMainMenu mockMenu = Mockito.mock(ModelMainMenu.class);

        reset(mockMenu);

        when(mockMenu.getNumberEntries()).thenReturn(1);

        MainMenuViewer mainMenuViewer = new MainMenuViewer(mockMenu);
        mainMenuViewer.drawElements(mockGUI);

        verify(mockMenu, times(2)).getNumberEntries();
    }
}