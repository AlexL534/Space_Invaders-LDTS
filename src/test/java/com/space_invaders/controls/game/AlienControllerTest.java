package com.space_invaders.controls.game;

import com.space_invaders.Game;
import com.space_invaders.Position;
import com.space_invaders.controls.game.AlienController;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.Alien;
import com.space_invaders.model.game.elements.SpaceShip;
import com.space_invaders.model.game.elements.bullets.EnemyBullet;
import com.space_invaders.model.game.space.LoaderSpaceBuilder;
import com.space_invaders.model.game.space.Space;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class AlienControllerTest {
    private List<Alien> aliens;
    private AlienController alienController;
    private Space space;

    @BeforeEach
    void setUp() {
        space = new LoaderSpaceBuilder(20,30).createSpace();
        aliens = space.getAliens();
        alienController = new AlienController(space);
    }

    @Test
    void testAlienMovement() throws IOException {
        // Set initial positions for aliens
        List<Position> initialPositions = new ArrayList<>();
        for (Alien alien : aliens) {
            initialPositions.add(alien.getPosition());
        }

        // Trigger the movement based on time intervals
        long time = 0;
        while (time < 1000) { // Simulate 1000 milliseconds
            try {
                alienController.step(mock(Game.class), GUI.ACTION.NONE, time);
                time += 50; // Simulate a time interval of 50 milliseconds
            } catch (IOException e) {
                fail("IOException occurred during movement test.");
            }
        }

        // Assert the positions of aliens after specific time intervals
        for (int i = 0; i < aliens.size(); i++) {
            Position newPosition = aliens.get(i).getPosition();
            assertNotEquals(initialPositions.get(i), newPosition, "Alien " + i + " did not move.");
        }
    }




}
