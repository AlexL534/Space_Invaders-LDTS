package com.space_invaders.model.menu;

import com.space_invaders.model.menu.ModelLeaderboardMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ModelLeaderboardMenuTest {

    private ModelLeaderboardMenu leaderboardMenu;

    @BeforeEach
    public void setUp() {
        leaderboardMenu = new ModelLeaderboardMenu();
    }

    @Test
    public void testIsSelectedWhenTrue() {
        int selectedEntry = 3;
        Assertions.assertTrue(leaderboardMenu.isSelected(selectedEntry));
    }

    @Test
    public void testIsSelectedWhenFalse() {
        int nonSelectedEntry = 5;
        Assertions.assertFalse(leaderboardMenu.isSelected(nonSelectedEntry));
    }
}
