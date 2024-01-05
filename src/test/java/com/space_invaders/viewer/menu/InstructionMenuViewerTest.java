package com.space_invaders.viewer.menu;

import com.space_invaders.gui.GUI;
import com.space_invaders.model.menu.ModelInstructionMenu;
import com.space_invaders.viewer.menu.InstructionMenuViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class InstructionMenuViewerTest {

    @Test
    public void testDrawElements() {
        GUI mockGUI = Mockito.mock(GUI.class);

        ModelInstructionMenu mockMenu = Mockito.mock(ModelInstructionMenu.class);

        InstructionMenuViewer instructionMenuViewer = new InstructionMenuViewer(mockMenu);
        instructionMenuViewer.drawElements(mockGUI);

        verify(mockGUI).drawText(any(), eq("    I N S T R U C T I O N S    "), eq("#FFFFFF"));
        verify(mockGUI).drawText(any(), eq("       GAME OBJECTIVE:         "), eq("#FFFFFF"));
        verify(mockGUI).drawText(any(), eq("   Protect Earth from aliens   "), eq("#FFFFFF"));
        verify(mockGUI).drawText(any(), eq("    by using your spaceship   "), eq("#FFFFFF"));
        verify(mockGUI).drawText(any(), eq("     to destroy them while        "), eq("#FFFFFF"));
        verify(mockGUI).drawText(any(), eq("      dodging their shots.      "), eq("#FFFFFF"));
        verify(mockGUI).drawText(any(), eq("    Avoid getting hit three   "), eq("#FFFFFF"));
        verify(mockGUI).drawText(any(), eq("     times and letting them  "), eq("#FFFFFF"));
        verify(mockGUI).drawText(any(), eq("       reach the bottom!            "), eq("#FFFFFF"));
        verify(mockGUI).drawText(any(), eq("     GAMEPLAY CONTROLS:        "), eq("#FFFFFF"));
        verify(mockGUI).drawText(any(), eq(" ARROW_LEFT  --> MOVE LEFT      "), eq("#FFFFFF"));
        verify(mockGUI).drawText(any(), eq(" ARROW_RIGHT --> MOVE RIGHT     "), eq("#FFFFFF"));
        verify(mockGUI).drawText(any(), eq(" SPACE BAR   --> SHOOTING      "), eq("#FFFFFF"));
        verify(mockGUI).drawText(any(), eq(" ENTER       --> SELECT       "), eq("#FFFFFF"));
        verify(mockGUI).drawText(any(), eq(" ESC         --> GO BACK      "), eq("#FFFFFF"));
        verify(mockGUI).drawText(any(), eq("   "), eq("#FFFFFF"));
    }
}
