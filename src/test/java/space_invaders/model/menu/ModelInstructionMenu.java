package space_invaders.model.menu;

public class ModelInstructionMenu implements ModelMenu {
    private boolean run;

    public ModelInstructionMenu(){
        run = true;
    }


    @Override
    public void setRun(boolean run) {
        this.run = run;
    }
    @Override
    public boolean isRunning() {
        return run;
    }
}
