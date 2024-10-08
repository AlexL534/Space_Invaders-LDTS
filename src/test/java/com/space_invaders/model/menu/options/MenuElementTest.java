package com.space_invaders.model.menu.options;

import com.googlecode.lanterna.TextColor;
import com.space_invaders.model.menu.options.MenuElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuElementTest {

    @Test
    void testMenuElementConstructorAndGetters() {
        Integer id = 1;
        MenuElement<Integer> menuElement = new MenuElement<>(id);

        assertEquals(id.toString(), menuElement.getIdentifier());
        assertFalse(menuElement.isSelected());
        assertEquals(new TextColor.RGB(255, 255, 255), menuElement.getFillColor());
        assertEquals(new TextColor.RGB(255, 255, 255), menuElement.getBorderColor());
    }

    @Test
    void testSelectAndDeselect() {
        MenuElement<String> menuElement = new MenuElement<>("ID");

        menuElement.select();
        assertTrue(menuElement.isSelected());
        assertEquals(new TextColor.RGB(255, 202, 24), menuElement.getFillColor());
        assertEquals(new TextColor.RGB(255, 202, 24), menuElement.getBorderColor());

        menuElement.deselect();
        assertFalse(menuElement.isSelected());
        assertEquals(new TextColor.RGB(255, 255, 255), menuElement.getFillColor());
        assertEquals(new TextColor.RGB(255, 255, 255), menuElement.getBorderColor());
    }

    @Test
    void testSetFillColorAndBorderColor() {
        MenuElement<Boolean> menuElement = new MenuElement<>(true);

        TextColor newFillColor = new TextColor.RGB(0, 0, 0);
        TextColor newBorderColor = new TextColor.RGB(128, 128, 128);

        menuElement.setFillColor(newFillColor);
        menuElement.setBorderColor(newBorderColor);

        assertEquals(newFillColor, menuElement.getFillColor());
        assertEquals(newBorderColor, menuElement.getBorderColor());
    }
}