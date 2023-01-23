package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.actions.results.ActionResult;

public abstract class FluidActionResultWithParent extends FluidActionResult {
    protected ActionResult parent;

    public FluidActionResultWithParent(ActionResult parent) {
        this.parent = parent;
    }
}
