package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.text.Label;
import org.itmo.prog.lab3.models.text.Name;
import org.itmo.prog.lab3.models.text.interfaces.HasCases;

public class FluidText {
    public static FluidActor these(Actor parent) {
        return new FluidThisActor(parent);
    }

    public static FluidActor these(Label parent) {
        var actor = fluid(parent);
        return new FluidThisActor(actor);
    }

    public static FluidActor fluid(Actor parent) {
        return new FluidActorFromActor(parent);
    }

    public static FluidActor fluid(Name parent) {
        return new FluidActorFromName(parent);
    }

    public static FluidActor fluid(Label parent) {
        return new FluidActorFromLabel(parent);
    }

    public static FluidActor pronoun(Actor parent) {
        return new FluidActorPronoun(parent);
    }

    public static FluidActionResult using(ActionResult parent, HasCases thing) {
        return new FluidActionResultUsing(parent, thing);
    }

    public static FluidActionResult using(HasCases thing, ActionResult parent) {
        return new FluidActionResultUsing(parent, thing).invert();
    }
}
