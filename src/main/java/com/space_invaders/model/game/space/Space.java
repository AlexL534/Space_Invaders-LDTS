package com.space_invaders.model.game.space;

import com.space_invaders.Position;
import com.space_invaders.model.game.elements.Alien;
import com.space_invaders.model.game.elements.PowerUpShip;
import com.space_invaders.model.game.elements.SpaceShip;

import java.util.List;

public class Space {
        List<Alien> aliens;
        List<PowerUpShip> powerUpShips;
        SpaceShip spaceship;
        private int width;
        private int height;

        private long score;

        public Space(int width, int height) {
            setWidth(width);
            setHeight(height);
            this.score = 0;
        }
        public long getScore() {return spaceship.getScore();}
        public void setScore(long score) {this.score = score;}
        public void incrementScore(int points) {this.score += points;}
        public SpaceShip getSpaceship() {
             return spaceship;
        }
        public void setSpaceship(SpaceShip spaceship) {
           this.spaceship = spaceship;
        }
        public List<Alien> getAliens() {
            return aliens;
        }
        public void setAliens(List<Alien> aliens){this.aliens = aliens;}
        public List<PowerUpShip> getPowerUpShips() {
            return powerUpShips;
        }
        public void setPowerUpShips(List<PowerUpShip> powerUpShips){
            this.powerUpShips = powerUpShips;
        }
        public void addPowerUpShip(PowerUpShip powerUpShip) {
            powerUpShips.add(powerUpShip);
        }
        public void removePowerUpShip(PowerUpShip powerUpShip){
            powerUpShips.remove(powerUpShip);
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }


        public void verifySpaceshipBullets() {
            for(int j = 0; j<aliens.size(); j++){
                for (int i = 0; i<spaceship.getBullets().size(); i++){
                    if (spaceship.getBullets().get(i).getPosition().equals(aliens.get(j).getPosition())){
                        aliens.remove(aliens.get(j));
                        spaceship.removeBullet(spaceship.getBullets().get(i));
                        incrementScore(10);
                    }
                }
            }
        }
        public boolean canSpaceShipMove(Position position) {return position.getX()<width-1 && position.getX()>0;}
    }
