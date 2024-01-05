package com.space_invaders.viewer.game;

import com.space_invaders.Position;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.Alien;
import com.space_invaders.model.game.elements.Element;
import com.space_invaders.model.game.elements.PowerUpShip;
import com.space_invaders.model.game.elements.SpaceShip;
import com.space_invaders.model.game.elements.bullets.Bullet;
import com.space_invaders.model.game.elements.powerups.PowerUp;
import com.space_invaders.model.game.space.Space;
import com.space_invaders.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Space> {
    public GameViewer(Space space) {
        super(space);
    }
    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getAliens(), new AlienViewer());
        drawElement(gui, getModel().getSpaceship(), new SpaceShipViewer());
        drawSpaceShipBullets(getModel().getSpaceship(),new SpaceShipBulletViewer(),gui);
        drawPowerUpShips(getModel().getPowerUpShips(),new PowerUpShipViewer(),gui);
        drawRandomPowerUps(getModel().getPowerUpShips(),new RandomPowerUpViewer(),gui);
        drawEnemyBullets(getModel().getAliens(),new EnemyBulletViewer(),gui);
        gui.drawText(new Position(0, 0), "Score: " + getModel().getScore(), "#FFD700");
        gui.drawText(new Position(0, getModel().getHeight()), "Lives: " + getModel().getSpaceship().getHP(), "#18da3b");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
    private void drawRandomPowerUps(List<PowerUpShip> powerUpShips, RandomPowerUpViewer randomPowerUpViewer, GUI gui) {
        for (PowerUpShip powerUpShip : powerUpShips){
            for (PowerUp powerUp : powerUpShip.getPowerUps()){
                randomPowerUpViewer.draw(powerUp,gui);
            }
        }
    }
    private void drawSpaceShipBullets(SpaceShip spaceShip, SpaceShipBulletViewer spaceShipBulletViewer, GUI gui){
            if(!spaceShip.getBullets().isEmpty()){
                for (Bullet bullet : spaceShip.getBullets()){
                    spaceShipBulletViewer.draw(bullet,gui);
                }
            }

    }
    private void drawEnemyBullets(List<Alien> aliens, EnemyBulletViewer enemyBulletViewer, GUI gui) {
        for (Alien alien : aliens){
            if (!alien.getBullets().isEmpty()){
                for (Bullet bullet : alien.getBullets()){
                    enemyBulletViewer.draw(bullet,gui);
                }
            }
        }
    }
    private void drawPowerUpShips(List<PowerUpShip> powerUpShips, PowerUpShipViewer powerUpShipViewer,GUI gui){
        for (PowerUpShip powerUpShip : powerUpShips){
            powerUpShipViewer.draw(powerUpShip,gui);
        }
    }
}
