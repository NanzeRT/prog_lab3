package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.common.Appearance;
import org.itmo.prog.lab3.models.text.Case;
import org.itmo.prog.lab3.models.text.GenderOrPlural;
import org.itmo.prog.lab3.models.text.Name;

public class FluidActorFromName extends FluidActor {
    private Name name;
    private Appearance appearance;

    public FluidActorFromName(Name name) {
        this.name = name;
        this.appearance = new Appearance();
    }

    public FluidActorFromName(Name name, Appearance appearance) {
        this.name = name;
        this.appearance = appearance;
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

    @Override
    public Appearance getAppearance() {
        return name.getAppearance().merge(appearance);
    }
}
