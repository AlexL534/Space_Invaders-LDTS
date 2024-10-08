package com.space_invaders.viewer.menu;

import com.space_invaders.Position;
import com.space_invaders.gui.GUI;
import com.space_invaders.model.menu.ModelLeaderboardMenu; // Import the leaderboard menu model
import com.space_invaders.viewer.Viewer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeaderboardMenuViewer extends Viewer<ModelLeaderboardMenu> { // Change the class name and model type
    public LeaderboardMenuViewer(ModelLeaderboardMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        try {
            String rootPath = new File(System.getProperty("user.dir")).getPath();
            BufferedReader reader = new BufferedReader(new FileReader(rootPath + "/src/main/resources/leaderboardDraw.txt"));
            int lineNumber = 0;
            String line;
            while ((line = reader.readLine()) != null && lineNumber <= 20) {
                gui.drawText(new Position(0, lineNumber), line, "#FFFFFF");
                lineNumber++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*gui.drawText(new Position(0, 1), "     L E A D E R B O A R D  ", "#FFFFFF");
        gui.drawText(new Position(0, 3), " 1  - ThatOneKorean     99990", "#FFFFFF");
        gui.drawText(new Position(0, 4), " 2  - Kazzio            15080", "#FFFFFF");
        gui.drawText(new Position(0, 5), " 3  - Desumilde         08070", "#FFFFFF");
        gui.drawText(new Position(0, 6), " 4  - GTO               06370", "#FFFFFF");
        gui.drawText(new Position(0, 7), " 5  - JoaquimAlberto    01010", "#FFFFFF");
        gui.drawText(new Position(0, 8), " 6  - Waltuh            00800", "#FFFFFF");
        gui.drawText(new Position(0, 9), " 7  - Socas             00570", "#FFFFFF");
        gui.drawText(new Position(0, 10)," 8  - Guts              00300", "#FFFFFF");
        gui.drawText(new Position(0, 11), " 9  - ReadAndParse      00100", "#FFFFFF");
        gui.drawText(new Position(0, 12), " 10 - Gragas-ADC        00040", "#FFFFFF");
        gui.drawText(new Position(0, 14), "    PRESS ESC TO GO BACK ", "#FFFFFF");*/
    }
}