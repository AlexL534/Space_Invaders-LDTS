import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class Game{
    Space space;
    Screen screen;
    public Game()  {
        try {
            space = new Space(100,50);
            TerminalSize terminalSize = new TerminalSize(space.getWidth(),space.getHeight());
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary
            TextGraphics graphics = screen.newTextGraphics();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processKey(KeyStroke key) throws IOException {
        space.processKey(key);
    }
    private void draw() throws IOException {
        space.draw(screen.newTextGraphics());
        (space.spaceship).draw(screen.newTextGraphics());
        (space.controller).draw(screen.newTextGraphics());
        screen.refresh();
    }
    public void run() throws IOException {
        int i = 0;
        while(true) {
            i++;
            if (i%9999999==0) {
                KeyStroke key = screen.pollInput();
                if (key!=null) {
                    if (key.getKeyType() == KeyType.EOF) break;
                    else if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') screen.close();
                    else processKey(key);
                }
                else {
                    space.controller.tick();
                    draw();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.run();
    }
}