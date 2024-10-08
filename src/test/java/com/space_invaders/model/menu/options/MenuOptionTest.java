package com.space_invaders.model.menu.options;

import com.space_invaders.model.menu.options.MenuOption;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuOptionTest {

        @Test
        void testMenuOptionText() {
                assertEquals("START", MenuOption.START.getText());
                assertEquals("INSTRUCTIONS", MenuOption.INSTRUCTIONS.getText());
                assertEquals("EXIT", MenuOption.EXIT.getText());
        }
}
