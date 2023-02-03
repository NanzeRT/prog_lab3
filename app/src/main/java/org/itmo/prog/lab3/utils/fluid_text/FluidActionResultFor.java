package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.text.Case;
import org.itmo.prog.lab3.models.text.interfaces.HasCases;

public class FluidActionResultFor extends FluidActionResultWithParent {
    private HasCases thing;

    public FluidActionResultFor(FluidActionResult parent, HasCases thing) {
        super(parent);
        this.thing = thing;
    }

    @Override
    public String getTextWithoutActor() {
        return parent.getTextWithoutActor() + " за " + thing.getCased(Case.ACCUSATIVE);
    }
}
