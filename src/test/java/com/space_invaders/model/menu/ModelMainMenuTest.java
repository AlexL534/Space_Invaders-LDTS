package com.space_invaders.model.menu;

import com.space_invaders.model.menu.ModelMainMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ModelMainMenuTest {

    private ModelMainMenu mainMenu;

    @BeforeEach
    public void setUp() {
        mainMenu = new ModelMainMenu();
    }
/*
    @Test
    public void testNextEntry() {
        int initialEntry = mainMenu.getNumberEntries();

        // Move to the last entry and verify wrapping around
        for (int i = 0; i < initialEntry; i++) {
            mainMenu.nextEntry();
        }
        Assertions.assertTrue(mainMenu.isSelectedExit());

        // Move one more step and verify it goes back to the first entry
        mainMenu.nextEntry();
        Assertions.assertTrue(mainMenu.isSelectedStart());
    }
*/
    @Test
    public void testPreviousEntry() {
        int initialEntry = mainMenu.getNumberEntries();

        // Move to the first entry and verify wrapping around
        mainMenu.previousEntry();
        Assertions.assertTrue(mainMenu.isSelectedExit());

        // Move one step back and verify it goes to the last entry
        mainMenu.previousEntry();
        Assertions.assertTrue(mainMenu.isSelectedLeaderboard());
    }

    @Test
    public void testSelectedEntries() {
        Assertions.assertTrue(mainMenu.isSelectedStart());
        Assertions.assertFalse(mainMenu.isSelectedInstructions());
        Assertions.assertFalse(mainMenu.isSelectedLeaderboard());
        Assertions.assertFalse(mainMenu.isSelectedExit());
    }
}