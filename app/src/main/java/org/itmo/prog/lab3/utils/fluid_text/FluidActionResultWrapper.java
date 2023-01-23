package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.actors.Actor;

public class FluidActionResultWrapper extends FluidActionResultWithParent {
    public FluidActionResultWrapper(ActionResult parent) {
        super(parent);
    }

    @Override
    public String getTextWithoutActor() {
        return parent.getTextWithoutActor();
    }

    @Override
    public Actor getActor() {
        return parent.getActor();
    }
}
