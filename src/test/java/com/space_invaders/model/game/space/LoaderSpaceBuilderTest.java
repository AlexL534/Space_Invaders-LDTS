package com.space_invaders.model.game.space;

import com.space_invaders.model.game.elements.Alien;
import com.space_invaders.model.game.elements.SpaceShip;
import com.space_invaders.model.game.space.LoaderSpaceBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoaderSpaceBuilderTest {

    @Test
    public void testCreateAliens() {
        int expectedNumberOfAliens = 45;
        int expectedNumberOfRows = 5;

        int width = 100;
        int height = 200;

        LoaderSpaceBuilder loaderSpaceBuilder = new LoaderSpaceBuilder(width, height);
        List<Alien> aliens = loaderSpaceBuilder.createAliens();

        assertNotNull(aliens);
        assertEquals(expectedNumberOfAliens, aliens.size());

        // Count rows
        int numberOfRows = (int) aliens.stream().map(Alien::getX2).distinct().count();
        assertEquals(expectedNumberOfRows, numberOfRows);
    }

    @Test
    public void testCreateSpaceShip() {
        int width = 100; // Sample width
        int height = 200; // Sample height

        LoaderSpaceBuilder loaderSpaceBuilder = new LoaderSpaceBuilder(width, height);
        SpaceShip spaceShip = loaderSpaceBuilder.createSpaceship();

        assertNotNull(spaceShip);
        assertEquals(width / 2, spaceShip.getX1());
        assertEquals(height / 2 + 7, spaceShip.getX2());
    }
}
