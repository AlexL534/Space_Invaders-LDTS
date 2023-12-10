package com.aor.space_invaders.model.menu;

import java.util.Arrays;
import java.util.List;

public class ModelMainMenu implements ModelMenu {
    private final List<String> entries;
    private int currentEntry = 0;

    public ModelMainMenu() {
        this.entries = Arrays.asList("Start", "Exit");
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }
    @Override
    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }
    public boolean isSelectedInstructions() {
        return isSelected(2);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
