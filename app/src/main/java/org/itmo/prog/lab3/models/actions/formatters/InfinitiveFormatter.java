package org.itmo.prog.lab3.models.actions.formatters;

import org.itmo.prog.lab3.models.actions.results.ActionResult;

public class InfinitiveFormatter extends ActionResultFormatter {
    @Override
    public String format(ActionResult result) {
        switch (result.getTime()) {
            case INFINITIVE:
                return result.getTextWithoutActor();
            default:
                throw new IllegalArgumentException("Unknown time form");
        }
    }
}
