package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.text.Verb;

public abstract class FluidActionResultWithParent extends FluidActionResult {
    protected ActionResult parent;

    public FluidActionResultWithParent(ActionResult parent) {
        this.parent = parent;
    }

    @Override
    public Actor getActor() {
        return parent.getActor();
    }

    @Override
    public Verb.TimeForm getTime() {
        return parent.getTime();
    }
}
