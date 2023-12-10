package com.aor.space_invaders.viewer.game;

import com.aor.space_invaders.gui.GUI;
import com.aor.space_invaders.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}

