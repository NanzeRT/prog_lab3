package lab3.utils.fluid_text;

import lab3.models.actions.interfaces.Action;
import lab3.models.actions.results.ActionResult;
import lab3.models.actors.Actor;
import lab3.models.text.Case;
import lab3.models.text.interfaces.HasCases;

public abstract class FluidActor implements Actor {
    @Override
    public ActionResult doAction(Action action) {
        return action.execute(this);
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
}
