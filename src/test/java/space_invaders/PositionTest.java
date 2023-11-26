package space_invaders;

import com.aor.space_invaders.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @Test
    public void testMoveLeft() {
        Position initialPosition = new Position(5, 5);
        Position newPosition = initialPosition.moveLeft();
        assertEquals(4, newPosition.getX());
        assertEquals(5, newPosition.getY());
    }

    @Test
    public void testMoveRight() {
        Position initialPosition = new Position(5, 5);
        Position newPosition = initialPosition.moveRight();
        assertEquals(6, newPosition.getX());
        assertEquals(5, newPosition.getY());
    }

    @Test
    public void testMoveUp() {
        Position initialPosition = new Position(5, 5);
        Position newPosition = initialPosition.moveUp();
        assertEquals(5, newPosition.getX());
        assertEquals(4, newPosition.getY());
    }

    @Test
    public void testMoveDown() {
        Position initialPosition = new Position(5, 5);
        Position newPosition = initialPosition.moveDown();
        assertEquals(5, newPosition.getX());
        assertEquals(6, newPosition.getY());
    }
}