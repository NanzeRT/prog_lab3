package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.text.Case;
import org.itmo.prog.lab3.models.text.GenderOrPlural;

public class FluidThisActor extends FluidActorWithParent {
    public FluidThisActor(Actor parent) {
        super(parent);
    }

    @Override
    public String getName() {
        return appendThis(parent.getName(), parent.getGender());
    }

    @Override
    public String getShortCased(Case c) {
        return appendThis(parent.getShortCased(c), parent.getGender());
    }

    @Override
    public String getCased(Case c) {
        return appendThis(parent.getCased(c), parent.getGender());
    }

    private String appendThis(String s, GenderOrPlural gender) {
        return switch (gender) {
            case Male -> "этот " + s;
            case Female -> "эта " + s;
            case Plural -> "эти " + s;
            case Neuter -> "это " + s;
            default -> throw new IllegalStateException("Unexpected value: " + gender);
        };
    }
}
