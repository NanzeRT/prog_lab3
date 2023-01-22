package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.text.GenderOrMultiple;

public abstract class FluidActorWithParent extends FluidActor {
    protected Actor parent;
    
    public FluidActorWithParent(Actor parent) {
        this.parent = parent;
    }

    @Override
    public GenderOrMultiple getGender() {
        return parent.getGender();
    }
}
