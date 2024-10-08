<<<<<<< HEAD
package com.aor.space_invaders.gui;

import com.aor.space_invaders.Position;
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
        private final Screen screen;
        public LGUI(Screen screen) {
            this.screen = screen;
        }
        public LGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
            AWTTerminalFontConfiguration fontConfig = loadSquareFont();
            Terminal terminal = createTerminal(width, height, fontConfig);
            this.screen = createScreen(terminal);
        }
        private Screen createScreen(Terminal terminal) throws IOException {
            final Screen screen;
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            return screen;
        }

        private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
            TerminalSize terminalSize = new TerminalSize(width, height + 1);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            terminalFactory.setForceAWTOverSwing(true);
            terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
            return terminalFactory.createTerminal();
        }

        private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
            URL resource = getClass().getClassLoader().getResource(""); // put font here
            assert resource != null;
            File fontFile = new File(resource.toURI());
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
            Font loadedFont = font.deriveFont(Font.PLAIN, 25);
            return AWTTerminalFontConfiguration.newInstance(loadedFont);
        }

        public ACTION getNextAction() throws IOException {
            KeyStroke keyStroke = screen.pollInput();
            if (keyStroke == null) return ACTION.NONE;
            if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
            if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;
            if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
            if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
            if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
            if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
            if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == ' ') return ACTION.SPACE;
            if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;
            return ACTION.NONE;
        }

        @Override
        public void drawSpaceship(Position position) {
            drawCharacter(position.getX(), position.getY(), 'X', "#FFD700");
        }


        @Override
        public void drawAlien(Position position) {
            drawCharacter(position.getX(), position.getY(), 'N', "#CC0000");
        }

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
=======
package com.aor.space_invaders.gui;

import com.aor.space_invaders.Position;
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
            //AWTTerminalFontConfiguration fontConfig = loadSquareFont();
            this.terminal = createTerminal(width, height);
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

        private Terminal createTerminal(int width, int height) throws IOException {
            TerminalSize terminalSize = new TerminalSize(width, height + 1);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            terminalFactory.setForceAWTOverSwing(true);
            return terminalFactory.createTerminal();
        }

        /*
        private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
            URL resource = getClass().getClassLoader().getResource(""); // put font here
            assert resource != null;
            File fontFile = new File(resource.toURI());
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
            Font loadedFont = font.deriveFont(Font.PLAIN, 25);
            return AWTTerminalFontConfiguration.newInstance(loadedFont);
        }
         */


        public ACTION getNextAction() throws IOException {
            KeyStroke keyStroke = screen.pollInput();
            if (keyStroke == null) return ACTION.NONE;
            if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
            if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;
            if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
            if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
            if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
            if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
            if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == ' ') return ACTION.SPACE;
            if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;
            return ACTION.NONE;
        }

        @Override
        public void drawSpaceship(Position position) {
            drawCharacter(position.getX(), position.getY(), 'S', "#FFFFFF");
        }


        @Override
        public void drawAlien(Position position) {
            drawCharacter(position.getX(), position.getY(), 'N', "#CC0000");
        }

    @Override
    public void drawPowerUpShip(Position position) {
        drawCharacter(position.getX(), position.getY(), 'P', "#FC0000");
    }

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
>>>>>>> 4f06f33b1ab10fb6901ee4044b250ab34a12b343
