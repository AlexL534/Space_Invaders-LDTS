package com.space_invaders.model.menu;

import com.space_invaders.model.menu.ModelInstructionMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ModelInstructionMenuTest {

    private ModelInstructionMenu instructionMenu;

    @BeforeEach
    public void setUp() {
        instructionMenu = new ModelInstructionMenu();
    }

    @Test
    public void testIsSelectedWhenTrue() {
        int selectedEntry = 2; // Set the expected selected entry
        Assertions.assertTrue(instructionMenu.isSelected(selectedEntry));
    }

    @Test
    public void testIsSelectedWhenFalse() {
        int nonSelectedEntry = 5; // Set an entry that's not currently selected
        Assertions.assertFalse(instructionMenu.isSelected(nonSelectedEntry));
    }
}