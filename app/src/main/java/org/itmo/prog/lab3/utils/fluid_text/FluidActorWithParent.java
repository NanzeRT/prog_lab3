package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.actions.interfaces.Action;
import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.text.GenderOrPlural;

public abstract class FluidActorWithParent extends FluidActor {
    protected Actor parent;
    
    public FluidActorWithParent(Actor parent) {
        this.parent = parent;
    }

    @Override
    public GenderOrPlural getGender() {
        return parent.getGender();
    }

    @Override
    public FluidActionResult doAction(Action action) {
        return FluidActionResultActorReplacer.replace(parent.doAction(action), this);
    }
}
