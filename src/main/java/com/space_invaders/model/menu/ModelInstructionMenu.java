package com.space_invaders.model.menu;

public class ModelInstructionMenu implements ModelMenu{
    private final int currentEntry = 2;
    @Override
    public boolean isSelected(int i) {
        return currentEntry == i;
    }
}