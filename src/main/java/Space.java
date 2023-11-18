import com.googlecode.lanterna.graphics.TextGraphics;
import java.io.IOException;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.swing.TerminalScrollController;

import javax.xml.stream.events.Characters;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

    public class Space {
        List<Allien> alliens;
        SpaceShip spaceship;
        Controller controller;
        private int width;
        private int height;

        public Space(int width, int height) {
            setWidth(width);
            setHeight(height);
            spaceship = new SpaceShip(50, 47);
            controller = new Controller();
        }


        private void setHeight(int height) {
            this.height = height;
        }

        private void setWidth(int width) {
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
        public void moveAlliens() {
            int count = 0;
            Position a = alliens.get(alliens.size() - 1).getPosition();
            for (Allien allien : alliens){
                if (a.getY()<=width && a.getY()>=0 && count%2==0) allien.setPosition(allien.moveRight());
                else if (a.getY()<=width && a.getY()>=0 && count%2!=0) allien.setPosition(allien.moveLeft());
                else {allien.setPosition(allien.moveDown()); count++;}
            }
        }
        boolean verifyAlliensBullets() {
            return true;
        }
        private boolean canSpaceShipMove(Position position) {
            return position.getX()<width-1 && position.getX()>0;
        }

        void processKey(KeyStroke key) throws IOException {
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == ' ') {
                controller.addBullet(new Bullet(spaceship.getX(), spaceship.getY()));
                controller.tick();
            }
            else if (key.getKeyType() == KeyType.ArrowLeft) moveSpaceShip(spaceship.moveLeft());
            else if (key.getKeyType() == KeyType.ArrowRight)moveSpaceShip(spaceship.moveRight());
        }

        public void draw(TextGraphics graphics) throws IOException {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
            graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        }

        public boolean verifyEnemyBulletCollisions() {
            return true;
        }
    }
