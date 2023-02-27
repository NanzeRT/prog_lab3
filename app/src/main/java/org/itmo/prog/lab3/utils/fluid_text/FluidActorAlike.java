package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.text.Case;
import org.itmo.prog.lab3.models.text.interfaces.HasCases;

public class FluidActorAlike extends FluidActorWithParent {
    private HasCases thing;

    public FluidActorAlike(FluidActor parent, HasCases thing) {
        super(parent);
        this.thing = thing;
    }

    @Override
    public String getPronoun(Case c) {
        return appendAlike(parent.getPronoun(c));
    }

    @Override
    public String getName() {
        return appendAlike(parent.getName());
    }

    @Override
    public String getShortCased(Case c) {
        return appendAlike(parent.getShortCased(c));
    }

    @Override
    public String getCased(Case c) {
        return appendAlike(parent.getCased(c));
    }

    private String appendAlike(String s) {
        return s + ", словно " + thing.getCased(Case.NOMINATIVE) + ",";
    }
}
