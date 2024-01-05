package com.space_invaders.controls.game;

import com.space_invaders.*;
import com.space_invaders.*;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.game.elements.Alien;
import com.space_invaders.model.game.elements.bullets.EnemyBullet;
import com.space_invaders.model.game.space.Space;
import com.space_invaders.model.menu.ModelEndScreen;
import com.space_invaders.states.EndScreenState;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class AlienController extends GameController {
    public AlienController(Space space) {
        super(space);
    }
    Music music;
    private long lastMovement;
    private  long lastShoot = 0;
    private  long lastMovementofShot = 0;

    private long calculateFinalScore() {
        return getModel().getSpaceship().getScore();
    }
    private int[] maxColumnHeights(List<Alien> aliens){
        int[] columnHeights = new int[getModel().getWidth()];
        for (Alien alien : aliens) {
            int column = alien.getPosition().getX();
            int currentHeight = alien.getPosition().getY();

            if (currentHeight > columnHeights[column]) {
                columnHeights[column] = currentHeight;
            }
        }

        return columnHeights;
    }
    private void collisions(Game game){
        List<Alien> aliens = getModel().getAliens();
        for (Alien alien : aliens) {
            for (int i = 0; i<alien.getBullets().size();i++){
                if (alien.getBullets().get(i).getPosition().equals(getModel().getSpaceship().getPosition())) {
                    getModel().getSpaceship().setHP(getModel().getSpaceship().getHP()-1);
                    alien.removeBullet(alien.getBullets().get(i));
                    music = MusicManager.getInstance().getLostLifeMusic();
                    music.start();
                }
                else if (alien.getBullets().get(i).getPosition().getY() == 0) alien.removeBullet(alien.getBullets().get(i));
            }
            if (alien.getPosition().getY() == getModel().getSpaceship().getPosition().getY()) {
                long finalScore = calculateFinalScore();
                ModelEndScreen endScreen = new ModelEndScreen();
                endScreen.setFinalScore(finalScore);
                game.setState(new EndScreenState(endScreen));
                break;
            }
        }
    }
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        List<Alien> aliens = getModel().getAliens();
        int originalDelay = 700; // Initial delay between movements (adjust as per your game)
        int updatedDelay = (int) (originalDelay / GameManager.getInstance().getVelocityMultiplier());
        if (time - lastMovement > updatedDelay) {
            for (Alien alien : aliens) {
                alien.update();
            }
            boolean atRightBorder = false;
            boolean atLeftBorder = false;
            if(aliens.size() > 0) {
                atRightBorder = aliens.get(aliens.size() - 1).getPosition().getX() == getModel().getWidth() - 2;
                atLeftBorder = aliens.get(0).getPosition().getX() == 1;
            }
            if (atRightBorder || atLeftBorder) {
                for (Alien alien : aliens) {
                    alien.setPosition(new Position(alien.getPosition().getX(), alien.getPosition().getY() + 1));
                    alien.changeDirection();
                }
            }
            this.lastMovement = time;
        }
        int[] maxColumnHeights = maxColumnHeights(aliens);
        if (time - lastShoot > 500) {
            for (int i = 0; i < aliens.size(); i++) {
                Random random = new Random();
                int random_shoot = random.nextInt(6);
                int column = aliens.get(i).getPosition().getX();
                int maxColumnHeight = maxColumnHeights[column];
                if (aliens.get(i).getPosition().getY() == maxColumnHeight & random_shoot == 4) {
                    addBulletsAndFire(i);
                }
            }
            this.lastShoot = time;
        }
        if (time - lastMovementofShot > 150) {
            for (int i = 0; i < aliens.size(); i++) {
                moveBullets(i);
            }
            this.lastMovementofShot = time;
        }
        collisions(game);
    }
    private void moveBullets(int alienpos) {
        for (EnemyBullet bullet : getModel().getAliens().get(alienpos).getBullets()){
            bullet.tick();
        }
    }

    private void addBulletsAndFire(int alienpos) {
        getModel().getAliens().get(alienpos).addBullet(new EnemyBullet(getModel().getAliens().get(alienpos).getPosition().getX(),getModel().getAliens().get(alienpos).getPosition().getY()));
        for (EnemyBullet bullet : getModel().getAliens().get(alienpos).getBullets()){
            bullet.tick();
        }
    }
}