<<<<<<< HEAD
package com.aor.space_invaders.model.game.space;

import com.aor.space_invaders.Position;
import com.aor.space_invaders.model.game.elements.Alien;
import com.aor.space_invaders.model.game.elements.SpaceShip;

import java.util.List;

public class Space {
        List<Alien> aliens;
        SpaceShip spaceship;
        private int width;
        private int height;

        public Space(int width, int height) {
            setWidth(width);
            setHeight(height);
        }
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

        public void moveSpaceShip(Position position) {
            if (canSpaceShipMove(position)) spaceship.setPosition(position);
        }
        public void verifySpaceshipBullets() {
            for(Alien alien : aliens){
                if (spaceship.getBulletPos() == alien.getPosition()) {aliens.remove(alien); spaceship.deleteBullet();}
            }
        }
        public boolean canSpaceShipMove(Position position) {return position.getX()<width-1 && position.getX()>0;
        }

        public void verifyEnemyBulletCollisions(){
            for(Alien alien : aliens){
                if (alien.getBulletPos() == alien.getPosition()) {spaceship.removeLife(); alien.deleteBullet(spaceship.getPosition());}
            }
        }
    }
=======
package com.aor.space_invaders.model.game.space;

import com.aor.space_invaders.Position;
import com.aor.space_invaders.model.game.elements.Alien;
import com.aor.space_invaders.model.game.elements.SpaceShip;

import java.util.List;

public class Space {
        List<Alien> aliens;
        SpaceShip spaceship;
        private int width;
        private int height;

        public Space(int width, int height) {
            setWidth(width);
            setHeight(height);
        }
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
        //public void verifySpaceshipBullets() {
         //   for(Alien alien : aliens){
          //      if (spaceship.getBulletPos().equals(alien.getPosition())) {
           //         aliens.remove(alien);
             //       spaceship.deleteBullet();
              //  }
            //}
        //}
        public boolean canSpaceShipMove(Position position) {return position.getX()<width-1 && position.getX()>0;
        }

        //public boolean verifyEnemyBulletCollisions(Position position){
         //   for(Alien alien : aliens){
          //      if (alien.getBulletPos() == alien.getPosition()) {
           //         alien.deleteBullet(spaceship.getPosition());
            //        return true;
             //   }
            //}
            //return false;
        //}
    }
>>>>>>> 4f06f33b1ab10fb6901ee4044b250ab34a12b343
