package com.aor.space_invaders.model.menu;

public class ModelEndScreen implements ModelMenu{

        private boolean run;
        int score;
        boolean lost;

        public ModelEndScreen(){
            run=true;
            lost=false;
        }
        @Override
        public void setRun(boolean run) {
            this.run = run;
        }

        @Override
        public boolean isRunning() {
            return run;
        }

        public void setLost(boolean lost) {
            this.lost = lost;
        }
        public boolean hasLost() {
            return lost;
        }
        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }

