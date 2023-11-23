public class Position {
    private int x;
    private int y;

    public Position(int x, int i) {
        this.x = x;
        y = i;
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
}