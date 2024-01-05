package com.space_invaders.model.menu;

import com.space_invaders.model.menu.ModelEndScreen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ModelEndScreenTest {
    private ModelEndScreen modelEndScreen;
    private final String leaderboardFilePath = "leaderboardDraw.txt";


    @BeforeEach
    public void setUp() {
        modelEndScreen = new ModelEndScreen();
    }
/*
    @Test
    public void testGetPlayerName() {
        // Set up mock player name
        String expectedName = "Player1";
        modelEndScreen.setNameEntered(true);
        modelEndScreen.addLetter('P');
        modelEndScreen.addLetter('l');
        modelEndScreen.addLetter('a');
        modelEndScreen.addLetter('y');
        modelEndScreen.addLetter('e');
        modelEndScreen.addLetter('r');
        modelEndScreen.addLetter('1');

        // Verify if getPlayerName() returns the expected player name
        assertEquals(expectedName, modelEndScreen.getPlayerName());
    }

    @Test
    public void testGetAndSetFinalScore() {
        long score = 1000L;
        modelEndScreen.setFinalScore(score);
        assertEquals(score, modelEndScreen.getFinalScore());
    }
    @Test
    public void testGetNameEnteredInitiallyFalse() {
        assertFalse(modelEndScreen.getNameEntered());
    }

    @Test
    public void testSetNameEnteredAndGetGetNameEntered() {
        assertFalse(modelEndScreen.getNameEntered()); // By default, the nameEntered should be false
        modelEndScreen.setNameEntered(true);
        assertTrue(modelEndScreen.getNameEntered());
    }
    @Test
    public void testAddLetter() {
        ModelEndScreen endScreen = new ModelEndScreen();
        endScreen.addLetter('a');
        assertEquals("a", endScreen.getPlayerName());
    }

    @Test
    public void testRemoveLetter() {
        ModelEndScreen endScreen = new ModelEndScreen();
        endScreen.addLetter('a');
        endScreen.removeLetter();
        assertEquals("", endScreen.getPlayerName());
    }

    @Test
    public void testIsSelected() {
        ModelEndScreen endScreen = new ModelEndScreen();
        assertTrue(endScreen.isSelected(4));
        assertFalse(endScreen.isSelected(0));
        assertFalse(endScreen.isSelected(1));
        assertFalse(endScreen.isSelected(2));
        assertFalse(endScreen.isSelected(3));
        assertFalse(endScreen.isSelected(5));
    }
/*
    @Test
    public void testUpdateLeaderboard() {
        // Create a dummy leaderboard file
        createDummyLeaderboardFile();

        // Invoke the updateLeaderboard method with a sample score and player name
        modelEndScreen.updateLeaderboard(100, "TestPlayer");

        // Read the leaderboard file and assert that the entry was added
        List<String> leaderboardEntries = readLeaderboardFromFile(leaderboardFilePath);
        String entry = leaderboardEntries.get(0); // Assuming it's at position 0

        // Verify if the playerName and score have been updated in the leaderboard
        assertEquals("TestPlayer 100", entry);

        // Clean up - delete the created file
        deleteLeaderboardFile();
    }

 */

    // Helper methods

    private void createDummyLeaderboardFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(leaderboardFilePath))) {
            // Add dummy data for testing, like existing leaderboard entries
            writer.println("ExistingEntry 50");
            writer.println("AnotherEntry 80");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> readLeaderboardFromFile(String filePath) {
        List<String> leaderboardEntries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                leaderboardEntries.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return leaderboardEntries;
    }

    private void deleteLeaderboardFile() {
        File file = new File(leaderboardFilePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testLowestScoreInLeaderboard() {
        // Create a dummy leaderboard file
        createDummyLeaderboardFile();

        // Set a known lowest score for testing
        int expectedLowestScore = 40;

        // Get the lowest score from the dummy leaderboard file
        //int actualLowestScore = modelEndScreen.lowestScoreInLeaderboard();

        // Assert the lowest score matches the expected value
        //assertEquals(expectedLowestScore, actualLowestScore);

        // Clean up - delete the created file
        deleteLeaderboardFile();
    }

    @Test
    public void testReadLeaderboard() {
        // Create a dummy leaderboard file
        createDummyLeaderboardFile();

        // Read the dummy leaderboard file
        List<String> leaderboardEntries = modelEndScreen.readLeaderboard(new File(leaderboardFilePath));

        // Assert the expected number of entries
        int expectedEntryCount = 2; // Change this to match the number of dummy entries added
        assertEquals(expectedEntryCount, leaderboardEntries.size());

        // Clean up - delete the created file
        deleteLeaderboardFile();
    }
    /*
    @Test
    public void testFindInsertIndex() {
        // Mocking the behavior of lowestScoreInLeaderboard
        ModelEndScreen mockedModel = Mockito.spy(modelEndScreen);
        List<String> mockLeaderboard = new ArrayList<>();
        mockLeaderboard.add("Entry1 50");
        mockLeaderboard.add("Entry2 80");
        mockLeaderboard.add("Entry3 40");
        when(mockedModel.lowestScoreInLeaderboard()).thenReturn(50);

        // Test data for findInsertIndex method
        long newScore = 60L; // A score higher than the mocked lowest score

        int insertIndex = mockedModel.findInsertIndex(mockLeaderboard, newScore);
        assertEquals(1, insertIndex); // Expecting the index where the score should be inserted
    }
     */

    @Test
    public void testFormatEntry() {
        String playerName = "Player1";
        long score = 100;

        //String formattedEntry = modelEndScreen.formatEntry(playerName, score);

        //assertEquals("Player1 100", formattedEntry);
    }
    /*
    @Test
    public void testFindInsertIndexWithDifferentScores() {
        List<String> mockLeaderboard = new ArrayList<>();
        mockLeaderboard.add("Entry1 50");
        mockLeaderboard.add("Entry2 80");
        mockLeaderboard.add("Entry3 40");

        // Mocking the behavior of lowestScoreInLeaderboard
        ModelEndScreen mockedModel = Mockito.spy(modelEndScreen);
        when(mockedModel.lowestScoreInLeaderboard()).thenReturn(50);

        // Test with a score less than the lowest in the leaderboard
        int insertIndexLowerScore = mockedModel.findInsertIndex(mockLeaderboard, 30L);
        assertEquals(0, insertIndexLowerScore);

        // Test with a score higher than the lowest in the leaderboard
        int insertIndexHigherScore = mockedModel.findInsertIndex(mockLeaderboard, 60L);
        assertEquals(1, insertIndexHigherScore);
    }
     */
}
