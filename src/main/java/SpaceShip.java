import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.LinkedList;

public class SpaceShip extends Element{
    public SpaceShip(int x1, int x2) {
        super(x1, x2);
    }
    public Position moveLeft() {
        return new Position(getX() - 2 , getY() );
    }
    public Position moveRight() {
        return new Position(getX() + 2 , getY() );
    }


    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getX(), getY()), "X");
    }
    public Object getPosition() {
        Position pos = new Position(getX(),getY());
        return pos;
    }
}
