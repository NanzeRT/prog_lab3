package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.text.Case;
import org.itmo.prog.lab3.models.text.interfaces.HasCases;

public class FluidActorWith extends FluidActorWithParent {
    private HasCases thing;

    public FluidActorWith(Actor parent, HasCases thing) {
        super(parent);
        this.thing = thing;
    }

    @Override
    public String getName() {
        return appendWith(parent.getName());
    }

    @Override
    public String getShortCased(Case c) {
        return appendWith(parent.getShortCased(c));
    }

    @Override
    public String getCased(Case c) {
        return appendWith(parent.getCased(c));
    }

    private String appendWith(String s) {
        return s + " с " + thing.getCased(Case.INSTRUMENTAL);
    }
}
