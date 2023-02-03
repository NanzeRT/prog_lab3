package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.text.Case;

public class FluidActorPronoun extends FluidActorWithParent {

    public FluidActorPronoun(Actor parent) {
        super(parent);
    }

    @Override
    public String getName() {
        return parent.getPronoun(Case.NOMINATIVE);
    }

    @Override
    public String getShortCased(Case c) {
        return parent.getPronoun(c);
    }

    @Override
    public String getCased(Case c) {
        return parent.getPronoun(c);
    }
}
