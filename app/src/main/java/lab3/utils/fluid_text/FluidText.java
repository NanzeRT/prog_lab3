package lab3.utils.fluid_text;

import lab3.models.actors.Actor;
import lab3.models.text.Label;

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

    public static FluidActor fluid(Label parent) {
        return new FluidActorFromLabel(parent);
    }
}
