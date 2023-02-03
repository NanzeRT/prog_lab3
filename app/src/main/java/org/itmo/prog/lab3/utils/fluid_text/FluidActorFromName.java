package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.text.Case;
import org.itmo.prog.lab3.models.text.GenderOrPlural;
import org.itmo.prog.lab3.models.text.Name;

public class FluidActorFromName extends FluidActor {
    private Name name;

    public FluidActorFromName(Name name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name.getCased(Case.NOMINATIVE);
    }

    @Override
    public String getShortCased(Case c) {
        return name.getShortCased(c);
    }

    @Override
    public String getCased(Case c) {
        return name.getCased(c);
    }

    @Override
    public GenderOrPlural getGender() {
        return name.getGender();
    }
}
