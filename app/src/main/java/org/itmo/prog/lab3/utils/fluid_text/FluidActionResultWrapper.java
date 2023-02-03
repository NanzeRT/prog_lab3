package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.actions.results.ActionResult;

public class FluidActionResultWrapper extends FluidActionResultWithParent {
    public FluidActionResultWrapper(ActionResult parent) {
        super(parent);
    }

    @Override
    public String getTextWithoutActor() {
        return parent.getTextWithoutActor();
    }
}
