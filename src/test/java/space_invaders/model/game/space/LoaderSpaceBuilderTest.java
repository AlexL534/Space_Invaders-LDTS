package space_invaders.model.game.space;

import com.aor.space_invaders.model.game.elements.Alien;
import com.aor.space_invaders.model.game.elements.SpaceShip;
import com.aor.space_invaders.model.game.space.LoaderSpaceBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoaderSpaceBuilderTest{
    @Test
    public void testLoaderSpaceBuilderConstructor() {
        int width = 800;
        int height = 600;
        LoaderSpaceBuilder loaderSpaceBuilder = new LoaderSpaceBuilder(width, height);
        assertEquals(width, loaderSpaceBuilder.getWidth());
        assertEquals(height, loaderSpaceBuilder.getHeight());
        // Check if the number of aliens is properly calculated based on the provided formula
        int expectedNumberOfAliens = 55; // Expected number of aliens for 5 rows of 11 aliens
        assertEquals(expectedNumberOfAliens, loaderSpaceBuilder.getNumberOfAliens());
    }

    @Test
    public void testCreateSpaceship() {
        int width = 800;
        int height = 600;
        LoaderSpaceBuilder loaderSpaceBuilder = new LoaderSpaceBuilder(width, height);
        SpaceShip spaceship = loaderSpaceBuilder.createSpaceship();
        assertEquals(width / 2, spaceship.getPosition().getX()); // Verify X position
        assertEquals(height - 3, spaceship.getPosition().getY()); // Verify Y position
    }

    @Test
    public void testCreateAliens() {
        int width = 800;
        int height = 600;
        LoaderSpaceBuilder loaderSpaceBuilder = new LoaderSpaceBuilder(width, height);
        List<Alien> aliens = loaderSpaceBuilder.createAliens();
        int expectedNumberOfAliens = loaderSpaceBuilder.getNumberOfAliens();
        assertEquals(expectedNumberOfAliens, aliens.size());
        // Verify if the positions of the created aliens are within the bounds
        int expectedRows = expectedNumberOfAliens / 11; // Expected number of rows (assuming 11 aliens per row)
        int expectedColumns = expectedNumberOfAliens / 5; // Expected number of columns (assuming 5 aliens per column)
        for (Alien alien : aliens) {
            int xPosition = alien.getPosition().getX();
            int yPosition = alien.getPosition().getY();
            // Check if the alien's x and y positions are within the expected range
            assertTrue(xPosition >= 1 && xPosition <= expectedRows);
            assertTrue(yPosition >= 2 && yPosition <= expectedColumns);
        }
    }
}
