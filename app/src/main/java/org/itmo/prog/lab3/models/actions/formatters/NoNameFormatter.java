package org.itmo.prog.lab3.models.actions.formatters;

import org.itmo.prog.lab3.models.actions.results.ActionResult;

public class NoNameFormatter extends ActionResultFormatter {
    @Override
    public String format(ActionResult result) {
        return result.getTextWithoutActor();
    }
}
