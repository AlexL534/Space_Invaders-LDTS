import com.googlecode.lanterna.graphics.TextGraphics;



public abstract class  Element {
    private Position position;
    public abstract void draw(TextGraphics graphics);

    public Element(int x1, int x2) {
        position = new Position(x1,x2);
    }

    public int getX(){return position.getX();}
    public void setX(int x1){position.setX(x1);}
    public int getY(){return position.getY();}
    public void setY(int y1){position.setY(y1);}
    public void setPosition(Position position) {
        this.position = position;
    }
}

