package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.actions.formatters.ActionResultFormatter;
import org.itmo.prog.lab3.models.text.Case;
import org.itmo.prog.lab3.models.text.interfaces.HasCases;

public class FluidActionResultBehindReversed extends FluidActionResultWithParent {
    private HasCases thing;

    public FluidActionResultBehindReversed(FluidActionResult parent, HasCases thing) {
        super(parent);
        this.thing = thing;
    }

    @Override
    public String getTextWithoutActor() {
        return parent.getTextWithoutActor();
    }

    @Override
    public String getTextByFormatter(ActionResultFormatter formatter) {
        return "за " + thing.getCased(Case.INSTRUMENTAL) + " " + formatter.format(this);
    }
}
