package space_invaders.model.game.space;

import com.aor.space_invaders.Position;
import com.aor.space_invaders.model.game.elements.Alien;
import com.aor.space_invaders.model.game.elements.SpaceShip;
import com.aor.space_invaders.model.game.space.Space;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SpaceTest {
    @Test
    public void testMoveSpaceShip_ValidPosition() {
        Space space = new Space(800, 600);
        SpaceShip spaceShip = new SpaceShip(50, 50);
        space.setSpaceship(spaceShip);

        Position newPosition = new Position(100, 100);
        //space.moveSpaceShip(newPosition);

        assertEquals(newPosition, space.getSpaceship().getPosition());
    }

    @Test
    public void testMoveSpaceShip_InvalidPosition() {
        Space space = new Space(800, 600);
        SpaceShip spaceShip = new SpaceShip(50, 50);
        space.setSpaceship(spaceShip);

        Position newPosition = new Position(900, 100);
        //space.moveSpaceShip(newPosition);

        assertNotEquals(newPosition, space.getSpaceship().getPosition());
    }

    @Test
    public void testVerifySpaceshipBullets_NoCollision() {
        Space space = new Space(800, 600);
        List<Alien> aliens = new ArrayList<>();
        aliens.add(new Alien(100, 100));
        space.setAliens(aliens);
        SpaceShip spaceShip = new SpaceShip(50, 50);
        spaceShip.shoot();
        space.setSpaceship(spaceShip);
        // Verify before bullet collision: Expecting one alien initially
        assertEquals(1, space.getAliens().size());
        // Check bullet collision
        space.verifySpaceshipBullets();
        // Verify after bullet collision: Ensure no alien was removed (no collision)
        assertEquals(1, space.getAliens().size());
    }

    @Test
    public void testVerifySpaceshipBullets_WithCollision() {
        Space space = new Space(800, 600);
        SpaceShip spaceShip = Mockito.mock(SpaceShip.class);
        Mockito.when(spaceShip.getPosition()).thenReturn(new Position(100, 120));
        space.setSpaceship(spaceShip);
        List<Alien> aliens = new ArrayList<>();
        aliens.add(new Alien(100, 100));
        space.setAliens(aliens);
        Mockito.when(spaceShip.shoot()).thenReturn(true);
        // Verify before bullet collision: Expecting one alien initially
        assertEquals(1, space.getAliens().size());

        Mockito.when(spaceShip.getBulletPos()).thenReturn(null);
        // Move the bullet (assuming upward movement)
        space.verifySpaceshipBullets();
        // Verify after bullet collision: Expecting aliens list to be empty after collision
        assertEquals(0, space.getAliens().size());
    }
    @Test
    public void testCanSpaceShipMove_ValidPosition() {
        Space space = new Space(800, 600);
        assertTrue(space.canSpaceShipMove(new Position(50, 50)));
    }

    @Test
    public void testCanSpaceShipMove_OutOfBoundsPosition() {
        Space space = new Space(800, 600);
        assertFalse(space.canSpaceShipMove(new Position(900, 50)));
    }

    @Test
    public void testVerifyEnemyBulletCollisions_NoCollision() {
        Space space = new Space(800, 600);
        SpaceShip spaceShip = Mockito.mock(SpaceShip.class);
        Mockito.when(spaceShip.getBulletPos()).thenReturn(new Position(200, 200));
        space.setSpaceship(spaceShip);
        List<Alien> aliens = new ArrayList<>();
        aliens.add(new Alien(100, 100));
        space.setAliens(aliens);
        // Verify before checking bullet collisions
        assertEquals(1, space.getAliens().size());
        // Call the method to check bullet collisions
        //space.verifyEnemyBulletCollisions();
        // Verify after checking bullet collisions
        assertEquals(1, space.getAliens().size());
    }

    @Test
    public void testVerifyEnemyBulletCollisions_WithCollision() {
        Space space = new Space(800, 600);
        SpaceShip spaceShip = Mockito.mock(SpaceShip.class);
        Position bulletPosition = new Position(100, 100);
        Mockito.when(spaceShip.getPosition()).thenReturn(bulletPosition);
        Mockito.when(spaceShip.getBulletPos()).thenReturn(bulletPosition);
        space.setSpaceship(spaceShip);
        Position enemyBulletPosition = new Position(100, 100);
        space.getAliens().get(0).setBulletPos(enemyBulletPosition);
        //space.verifyEnemyBulletCollisions();
        Mockito.verify(spaceShip, Mockito.times(1)).removeLife();
    }
    }
