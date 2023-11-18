import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Allien extends Element{

    public Allien(int x1, int x2) {
        super(x1, x2);
    }

    public Position moveLeft() {
        return new Position(getX() -1 , getY() );
    }
    public Position moveRight() {
        return new Position(getX() + 1 , getY() );
    }
    public Position moveDown() {
        return new Position(getX(), getY() + 1);
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#964B00"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getX(), getY()), "A");
    }
    public Position getPosition() {
        return new Position(getX(),getY());
    }

}
