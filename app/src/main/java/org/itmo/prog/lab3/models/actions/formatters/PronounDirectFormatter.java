package org.itmo.prog.lab3.models.actions.formatters;

import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.text.Case;

public class PronounDirectFormatter extends ActionResultFormatter {
    @Override
    public String format(ActionResult result) {
        switch (result.getTime()) {
            case PAST:
            case PRESENT:
            case FUTURE:
                return result.getActor().getPronoun(Case.NOMINATIVE) + " " + result.getTextWithoutActor();
            default:
                throw new FormatterTimeException("Unknown time: " + result.getTime());
        }
    }
}
