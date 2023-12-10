package com.aor.space_invaders.states;

import com.aor.space_invaders.controls.Controller;
import com.aor.space_invaders.controls.menu.InstructionMenuController;
import com.aor.space_invaders.model.menu.ModelInstructionMenu;
import com.aor.space_invaders.viewer.Viewer;
import com.aor.space_invaders.viewer.menu.InstructionMenuViewer;

public class InstructionState extends State<ModelInstructionMenu>{

    public InstructionState(ModelInstructionMenu model) {
        super(model);
    }

    @Override
    protected Viewer<ModelInstructionMenu> getViewer() {
        return new InstructionMenuViewer(getModel());
    }

    @Override
    protected Controller<ModelInstructionMenu> getController() {
        return new InstructionMenuController(getModel());
    }
}
