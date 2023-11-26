package space_invaders.model.menu;

public enum MenuOptions {
        START("START"), INSTRUCTIONS("INSTRUCTIONS"), EXIT("EXIT");
        private final String text;
        MenuOptions(String text) {
            this.text=text;
        }
        public String getText() { return text;}

}
