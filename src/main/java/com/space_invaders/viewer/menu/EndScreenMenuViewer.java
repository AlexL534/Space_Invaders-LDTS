package com.space_invaders.viewer.menu;

import com.space_invaders.Position;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.menu.ModelEndScreen;
import com.space_invaders.viewer.Viewer;

public class EndScreenMenuViewer extends Viewer<ModelEndScreen> {
    public EndScreenMenuViewer(ModelEndScreen model) {super(model);}
    private boolean blinkState = true;

    private int currentLetterIndex = 0;

    @Override
    public void drawElements(GUI gui) {
        long finalScore = getModel().getFinalScore();
        String playerName = getModel().getPlayerName();
        gui.drawText(new Position(0, 5), "===============================", "#FF0000");
        gui.drawText(new Position(0, 6), "           GAME OVER           ", "#FF0000");
        gui.drawText(new Position(0, 7), "===============================", "#FF0000");
        gui.drawText(new Position(0, 9), "       Final Score: " + finalScore, "#FFFFFF");
        gui.drawText(new Position(0, 12), " Enter your name: " + playerName, "#FFFFFF");
        gui.drawText(new Position(0, 15), "   Press ENTER to confirm      ", "#FFFFFF");
    }
}
