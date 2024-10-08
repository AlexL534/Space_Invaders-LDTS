package com.space_invaders.gui;

import com.space_invaders.Position;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


public class LGUI implements GUI{
        Screen screen;
        protected  Terminal terminal;
        public LGUI(Screen screen) {
            this.screen = screen;
        }
    public LGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        this.terminal = createTerminal(width, height,fontConfig);
        this.screen = createScreen(terminal);
        }
    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);  // we don't need a cursor
        screen.startScreen();           // we need to start it
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height,AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        return terminalFactory.createTerminal();
    }


    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("Fonts/Ohio.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }
    public KeyStroke getChar() throws IOException {
            return screen.readInput();
    }

    public ACTION getNextAction() throws IOException {
            KeyStroke keyStroke = screen.pollInput();
            if (keyStroke == null) return ACTION.NONE;
            if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
            if (keyStroke.getKeyType() == KeyType.Escape) return ACTION.QUIT;
            if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
            if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
            if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
            if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
            if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == ' ') return ACTION.SPACE;
            if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;
            if (keyStroke.getKeyType() == KeyType.Backspace) return ACTION.BACKSPACE;
            if (keyStroke.getKeyType() == KeyType.Character) return ACTION.OTHER;
            return ACTION.NONE;
        }
        @Override
        public void drawSpaceship(Position position) {
            drawCharacter(position.getX(), position.getY(), '{', "#FFFFFF");
        }
        public void drawSpaceShipBullet(Position position) {
                drawCharacter(position.getX(), position.getY(), '|', "#FFFFFF");
         }
        public void drawAlienBullet(Position position) {
            drawCharacter(position.getX(), position.getY(), '|', "#FFF333");
        }

        @Override
        public void drawAlien(Position position) {
            drawCharacter(position.getX(), position.getY(), '}', "#00ff00");
        }

    @Override
    public void drawPowerUpShip(Position position) {
        drawCharacter(position.getX(), position.getY(), '@', "#FC0000");
    }
    public void drawRandomPowerUp(Position position){ drawCharacter(position.getX(), position.getY(), '?', "#FC0054");}
    @Override
        public void drawText(Position position, String text, String color) {
            TextGraphics tg = screen.newTextGraphics();
            tg.setForegroundColor(TextColor.Factory.fromString(color));
            tg.putString(position.getX(), position.getY(), text);
        }

        private void drawCharacter(int x, int y, char c, String color) {
            TextGraphics tg = screen.newTextGraphics();
            tg.setForegroundColor(TextColor.Factory.fromString(color));
            tg.putString(x, y + 1, "" + c);
        }

        @Override
        public void clear() {
            screen.clear();
        }

        @Override
        public void refresh() throws IOException {
            screen.refresh();
        }

        @Override
        public void close() throws IOException {
            screen.close();
        }
}