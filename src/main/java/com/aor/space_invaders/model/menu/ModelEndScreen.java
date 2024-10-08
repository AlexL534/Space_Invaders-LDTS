package com.aor.space_invaders.model.menu;

public class ModelEndScreen implements ModelMenu{
    private final int currentEntry = 3;
    @Override
    public boolean isSelected(int i) {
        return currentEntry == i;
    }
}

