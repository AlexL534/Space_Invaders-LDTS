package com.space_invaders.model.game.elements;

import com.space_invaders.Position;
import com.space_invaders.model.game.elements.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElementTest {

    private Element element;

    @BeforeEach
    public void setUp() {
        element = new Element(0, 0); // Provide appropriate x, y values
    }

    @Test
    public void testIsAlive() {
        assertTrue(element.isAlive());
    }

    @Test
    public void testDies() {
        element.dies();
        assertFalse(element.isAlive());
    }

    @Test
    public void testInitialPosition() {
        Position position = element.getPosition();
        assertNotNull(position);
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
    }

    @Test
    public void testSetPosition() {
        Position newPosition = new Position(5, 10);
        element.setPosition(newPosition);

        Position currentPosition = element.getPosition();
        assertNotNull(currentPosition);
        assertEquals(5, currentPosition.getX());
        assertEquals(10, currentPosition.getY());
    }
}
