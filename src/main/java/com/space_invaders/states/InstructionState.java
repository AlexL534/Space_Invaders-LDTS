package com.space_invaders.states;

import com.space_invaders.controls.Controller;
import com.space_invaders.controls.menu.InstructionMenuController;
import com.space_invaders.model.menu.ModelInstructionMenu;
import com.space_invaders.viewer.Viewer;
import com.space_invaders.viewer.menu.InstructionMenuViewer;

public class InstructionState extends State<ModelInstructionMenu>{

    public InstructionState(ModelInstructionMenu model) {
        super(model);
    }

    @Override
    public Viewer<ModelInstructionMenu> getViewer() {
        return new InstructionMenuViewer(getModel());
    }

    @Override
    public Controller<ModelInstructionMenu> getController() {
        return new InstructionMenuController(getModel());
    }
}