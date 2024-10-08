package com.space_invaders.model.menu;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import com.space_invaders.model.menu.ModelMenu;
import org.junit.Test;

public class ModelMenuTest {

    private static class TestModelMenu implements ModelMenu {

        private final int selectedOption;

        public TestModelMenu(int selectedOption) {
            this.selectedOption = selectedOption;
        }

        @Override
        public boolean isSelected(int i) {
            return selectedOption == i;
        }
    }

    @Test
    public void testIsSelected() {
        ModelMenu modelMenu = new TestModelMenu(2);

        assertFalse(modelMenu.isSelected(0));
        assertFalse(modelMenu.isSelected(1));
        assertTrue(modelMenu.isSelected(2));
        assertFalse(modelMenu.isSelected(3));
    }
}