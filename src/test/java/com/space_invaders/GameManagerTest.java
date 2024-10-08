package com.space_invaders;

import com.space_invaders.GameManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameManagerTest {

    private GameManager gameManager ;

    @BeforeEach
    public void setUp() {
        gameManager = new GameManager();
    }

    @Test
    public void testSingletonInstance() {
        GameManager instance1 = GameManager.getInstance();
        GameManager instance2 = GameManager.getInstance();

        Assertions.assertSame(instance1, instance2);
    }

    @Test
    public void testInitialVelocityMultiplier() {

        assertEquals(1.0, gameManager.getVelocityMultiplier());
    }

    @Test
    public void testVelocityMultiplierChange() {
        double initialMultiplier = gameManager.getVelocityMultiplier();
        gameManager.setVelocityMultiplier(2.0);
        double updatedMultiplier = gameManager.getVelocityMultiplier();

        assertEquals(initialMultiplier * 2.0, updatedMultiplier);
    }
}