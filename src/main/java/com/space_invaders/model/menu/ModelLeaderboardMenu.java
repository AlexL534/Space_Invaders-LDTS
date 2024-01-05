package com.space_invaders.model.menu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModelLeaderboardMenu implements ModelMenu {
    private final int currentEntry = 3;

    @Override
    public boolean isSelected(int i) {
        return currentEntry == i;
    }
}