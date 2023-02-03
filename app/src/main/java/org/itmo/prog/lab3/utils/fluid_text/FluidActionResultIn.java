package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.text.Case;
import org.itmo.prog.lab3.models.text.interfaces.HasCases;

public class FluidActionResultIn extends FluidActionResultWithParent {
    private final HasCases thing;

    public FluidActionResultIn(ActionResult parent, HasCases thing) {
        super(parent);
        this.thing = thing;
    }

    @Override
    public String getTextWithoutActor() {
        return parent.getTextWithoutActor() + " в " + thing.getCased(Case.PREPOSITIONAL);
    }
}
