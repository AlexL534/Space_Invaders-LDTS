package com.aor.space_invaders.gui;
import com.aor.space_invaders.Position;
import java.io.IOException;

public interface GUI {
        ACTION getNextAction() throws IOException;
        void drawSpaceship(Position position);
        void drawAlien(Position position);
        void drawPowerUpShip(Position position);
        void drawText(Position position, String text, String color);
        void clear();
        void refresh() throws IOException;
        void close() throws IOException;
        enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SPACE, SELECT}
}
