package com.aor.space_invaders.elements;

import com.aor.space_invaders.Position;

public abstract class  Element {
    private Position position;
    public Element(int x1, int y1) {
        position = new Position(x1,y1);
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public Position getPosition(){return this.position;}
}

