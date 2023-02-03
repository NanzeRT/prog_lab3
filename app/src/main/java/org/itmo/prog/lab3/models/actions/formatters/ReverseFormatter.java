package org.itmo.prog.lab3.models.actions.formatters;

import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.text.Case;

public class ReverseFormatter extends ActionResultFormatter {
    @Override
    public String format(ActionResult result) {
        switch (result.getTime()) {
            case PAST:
            case PRESENT:
            case FUTURE:
                return result.getTextWithoutActor() + " " + result.getActor().getCased(Case.NOMINATIVE);
            default:
                throw new IllegalArgumentException("Unknown time form");
        }
    }
}
