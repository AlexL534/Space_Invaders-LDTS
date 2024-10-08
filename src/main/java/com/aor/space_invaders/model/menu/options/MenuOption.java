package com.aor.space_invaders.model.menu.options;

public enum MenuOption {
        START("START"), INSTRUCTIONS("INSTRUCTIONS"), EXIT("EXIT");
        private final String text;

        MenuOption(String text) {
                this.text = text;
        }

        public String getText() {
                return text;
        }
}