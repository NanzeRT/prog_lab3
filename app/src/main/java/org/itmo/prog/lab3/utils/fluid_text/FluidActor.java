package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.actions.interfaces.Action;
import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.text.Case;
import org.itmo.prog.lab3.models.text.interfaces.HasCases;

public abstract class FluidActor implements Actor {
    @Override
    public FluidActionResult doAction(Action action) {
        return new FluidActionResultWrapper(action.execute(this));
    }

    @Override
    public String getPronoun(Case c) {
        return getGender().getPronoun().getCased(c);
    }

    public FluidActor with(HasCases thing) {
        return new FluidActorWith(this, thing);
    }

    public FluidActor of(HasCases thing) {
        return new FluidActorOf(this, thing);
    }

    public FluidActor inU(HasCases thing) {
        return new FluidActorInU(this, thing);
    }

    public FluidActor pronoun() {
        return new FluidActorPronoun(this);
    }

    public FluidActor inside(HasCases thing) {
        return new FluidActorInside(this, thing);
    }

    public FluidActor alike(HasCases thing) {
        return new FluidActorAlike(this, thing);
    }
}
