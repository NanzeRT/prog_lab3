package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.text.interfaces.HasCases;

public abstract class FluidActionResult extends ActionResult {
    public FluidActionResult in(HasCases thing) {
        return new FluidActionResultIn(this, thing);
    }
}
