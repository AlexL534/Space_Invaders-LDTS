package com.space_invaders.model.menu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModelEndScreen implements ModelMenu{
    private String playerName = "";
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    private final int currentEntry = 4;
    private long finalScore;

    @Override
    public boolean isSelected(int i) {
        return currentEntry == i;
    }
    public long getFinalScore() {return finalScore;}
    public void setFinalScore(long score) {finalScore = score;}
    public void addLetter(char letter) {
        if (playerName.length() < 11){
            playerName += letter;
        }
    }

    public void removeLetter() {
        if (!playerName.isEmpty()) {
            playerName = playerName.substring(0, playerName.length() - 1);
        }
    }



    public void updateLeaderboard(long score, String playerName) {
        String rootPath = new File(System.getProperty("user.dir")).getPath();
        File leaderboardFile = new File(rootPath + "/src/main/resources/leaderboardDraw.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(leaderboardFile))) {
            List<String> leaderboardEntries = new ArrayList<>();
            String line;

            // Read existing leaderboard entries
            while ((line = reader.readLine()) != null) {
                leaderboardEntries.add(line);
            }

            int rank = 1;
            boolean scoreInserted = false;

            // Get the lowest score in the leaderboard
            int lowestScore = getLowestScore(leaderboardEntries);

            // Rest of your code to insert/update the leaderboard entries...
            for (int i = 3; i < leaderboardEntries.size(); i++) {
                String entry = leaderboardEntries.get(i);
                int entryScore = extractScore(entry);

                if ((entryScore < score && rank <= 9) || score == 0) {
                    // Insert the new entry at the correct position
                    leaderboardEntries.add(i, formatEntry(playerName, score, rank));
                    scoreInserted = true;
                    break;
                } else if (entryScore == score && rank <= 9) {
                    // Update the existing entry and set foundScore to true
                    leaderboardEntries.set(i, formatEntry(playerName, score, rank));
                    scoreInserted = true;
                    break;
                }
                rank++;
            }

            // Remove the last entry if needed
            if (scoreInserted && leaderboardEntries.size() > 11) {
                leaderboardEntries.remove(leaderboardEntries.size() - 1);
            }

            // Write the updated leaderboard entries back to the file
            try (PrintWriter writer = new PrintWriter(new FileWriter(leaderboardFile))) {
                for (int i = 0; i < 11; i++) {
                    writer.println(leaderboardEntries.get(i));
                }
                // Add a new line for ESC message
                writer.println();
                writer.println("    PRESS ESC TO GO BACK");
            } catch (IOException e) {
                e.printStackTrace(); // Handle file writing errors
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    private int extractScore(String entry) {
        // Logic to extract the score from an entry string
        String[] parts = entry.split("\\s+"); // Assuming entries are separated by spaces
        if (parts.length > 0) {
            String scoreString = parts[parts.length - 1].trim(); // Extracting the last part
            try {
                return Integer.parseInt(scoreString);
            } catch (NumberFormatException e) {
                // Handle parsing errors if the score is not a valid integer
                return -1; // or any other default value indicating a problem
            }
        }
        return -1; // or any other default value indicating a problem
    }


    public String formatEntry(String playerName, long score, int rank) {
        String formattedName = formatName(playerName);
        String formattedScore = formatScore(score);
        return String.format(" %1d  - %-17s %5s", rank, formattedName, formattedScore);
    }

    private String formatName(String playerName) {
        return playerName.length() > 16 ? playerName.substring(0, 16) : playerName;
    }

    private String formatScore(long score) {
        return String.format("%05d", score);
    }


    public List<String> readLeaderboard(File leaderboardFile) {
        List<String> leaderboardEntries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(leaderboardFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                leaderboardEntries.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return leaderboardEntries;
    }

    public int getLowestScore(List<String> leaderboardEntries) {
        int lowestScore = Integer.MAX_VALUE;

        for (String entry : leaderboardEntries) {
            int entryScore = extractScore(entry);
            if (entryScore >= 0 && entryScore < lowestScore) {
                lowestScore = entryScore;
            }
        }

        return lowestScore;
    }
}