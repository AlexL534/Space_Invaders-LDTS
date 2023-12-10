package com.aor.space_invaders;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Position p = (Position) o;
        return getX() == p.getX() && getY() == p.getY();
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x1) {
        x = x1;
    }

    public void setY(int i1) {
        y = i1;
    }

    public Position moveLeft() {
        return new Position(getX()-1,getY());
    }
    public Position moveRight() {
        return new Position(getX()+1,getY());
    }
    public Position moveUp() {
        return new Position(getX(),getY()-1);
    }
    public Position moveDown() {
        return new Position(getX(),getY()+1);
    }

}