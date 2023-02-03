package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.text.Case;
import org.itmo.prog.lab3.models.text.interfaces.HasCases;

public class FluidActionResultUsing extends FluidActionResultWithParent {
    private HasCases thing;
    private boolean invert = false;

    public FluidActionResultUsing(ActionResult parent, HasCases thing) {
        super(parent);
        this.thing = thing;
    }

    public FluidActionResultUsing invert() {
        invert ^= true;
        return this;
    }

    @Override
    public String getTextWithoutActor() {
        if (invert) {
            return thing.getCased(Case.INSTRUMENTAL) + " " + parent.getTextWithoutActor();
        }
        return parent.getTextWithoutActor() + " " + thing.getCased(Case.INSTRUMENTAL);
    }
}
