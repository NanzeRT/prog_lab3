package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.text.Case;
import org.itmo.prog.lab3.models.text.interfaces.HasCases;

public class FluidActorInside extends FluidActorWithParent {
    private final HasCases thing;

    public FluidActorInside(FluidActor parent, HasCases thing) {
        super(parent);
        this.thing = thing;
    }

    @Override
    public String getName() {
        return appendInside(parent.getName());
    }

    @Override
    public String getShortCased(Case c) {
        return appendInside(parent.getShortCased(c));
    }

    @Override
    public String getCased(Case c) {
        return appendInside(parent.getCased(c));
    }

    private String appendInside(String s) {
        return s + " внутри " + thing.getCased(Case.GENITIVE);
    }
}
