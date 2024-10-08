package space_invaders.model.game.elements;

import com.aor.space_invaders.Position;
import com.aor.space_invaders.model.game.elements.Bullet;
import com.aor.space_invaders.model.game.elements.SpaceShip;
import com.aor.space_invaders.model.game.elements.powerups.PowerUp;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpaceShipTest {
    @Test
    public void testConstructor() {
        SpaceShip spaceShip = new SpaceShip(0, 0);
        assertEquals(3, spaceShip.getHP());
    }

    @Test
    public void testGetHP() {
        SpaceShip spaceShip = new SpaceShip(0,0);
        assertEquals(3,spaceShip.getHP());
    }

    @Test
    public void testRemoveLife() {
        SpaceShip spaceShip = new SpaceShip(0, 0);
        spaceShip.removeLife();
        assertEquals(2, spaceShip.getHP());
    }

    @Test
    public void testAddBullet() {
        Bullet bulletMock = Mockito.mock(Bullet.class);
        SpaceShip spaceShip = new SpaceShip(0, 0);
        spaceShip.addBullet(bulletMock);
        assertEquals(bulletMock, spaceShip.getBullet());
    }


}
