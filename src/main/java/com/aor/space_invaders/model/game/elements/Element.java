package com.aor.space_invaders.model.game.elements;

import com.aor.space_invaders.Position;

public abstract class  Element {
    private Position position;
    private boolean is_alive = true;
    public boolean isAlive() {
        return is_alive;
    }

    public void dies() {
        this.is_alive = false;
    }
    public Element(int x1, int y1) {
        position = new Position(x1,y1);
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public Position getPosition(){return this.position;}
}

