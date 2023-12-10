package com.aor.space_invaders.controls.game;

import com.aor.space_invaders.Game;
import com.aor.space_invaders.Position;
import com.aor.space_invaders.gui.GUI;
import com.aor.space_invaders.model.game.space.Space;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class SpaceShipController extends GameController {
    public SpaceShipController(Space model) {
        super(model);
    }
    private void moveRight(){
        Position temp = getModel().getSpaceship().getPosition();
        moveSpaceShip(new Position(temp.getX()+1,temp.getY()));
    }
    private void moveLeft() {
        Position temp = getModel().getSpaceship().getPosition();
        moveSpaceShip(new Position(temp.getX()-1,temp.getY()));
    }
    private void moveSpaceShip(Position position) {
        if (position.getY() < getModel().getWidth() - 1  && position.getY() > 0) {
            getModel().getSpaceship().setPosition(position);
            //if (getModel().verifyEnemyBulletCollisions(position)) getModel().getSpaceship().setHP(getModel().getSpaceship().getHP()-1);
        }
    }
    @Override
    public void step(Game game, GUI.ACTION action , long time) throws IOException {
        if (action == GUI.ACTION.RIGHT) moveRight();
        else if (action == GUI.ACTION.LEFT) moveLeft();
    }

}
