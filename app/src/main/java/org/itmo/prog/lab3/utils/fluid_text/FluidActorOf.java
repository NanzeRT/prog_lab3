package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.common.Appearance;
import org.itmo.prog.lab3.models.common.interfaces.HasAppearance;
import org.itmo.prog.lab3.models.text.Case;
import org.itmo.prog.lab3.models.text.interfaces.HasCases;

public class FluidActorOf extends FluidActorWithParent {
    private HasCases thing;

    public FluidActorOf(Actor parent, HasCases thing) {
        super(parent);
        this.thing = thing;
    }

    @Override
    public String getName() {
        return appendOf(parent.getName());
    }

    @Override
    public String getShortCased(Case c) {
        return appendOf(parent.getShortCased(c));
    }

    @Override
    public String getCased(Case c) {
        return appendOf(parent.getCased(c));
    }

    @Override
    public Appearance getAppearance() {
        if (thing instanceof HasAppearance)
            return parent.getAppearance().merge(((HasAppearance) thing).getAppearance());
        return parent.getAppearance();
    }

    private String appendOf(String s) {
        return s + " " + thing.getCased(Case.GENITIVE);
    }
}
