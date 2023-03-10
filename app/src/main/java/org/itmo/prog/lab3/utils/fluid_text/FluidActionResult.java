package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.text.interfaces.HasCases;

public abstract class FluidActionResult extends ActionResult {
    public FluidActionResult in(HasCases thing) {
        return new FluidActionResultIn(this, thing);
    }

    public FluidActionResult inU(HasCases thing) {
        return new FluidActionResultInU(this, thing);
    }

    public FluidActionResult using(HasCases thing) {
        return new FluidActionResultUsing(this, thing);
    }

    public FluidActionResult forr(HasCases thing) {
        return new FluidActionResultFor(this, thing);
    }

    public FluidActionResult behindReversed(HasCases thing) {
        return new FluidActionResultBehindReversed(this, thing);
    }
}
