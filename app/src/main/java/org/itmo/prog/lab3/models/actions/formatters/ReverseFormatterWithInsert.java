package org.itmo.prog.lab3.models.actions.formatters;

import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.text.Case;

public class ReverseFormatterWithInsert extends ActionResultFormatter {
    private String insert;

    public ReverseFormatterWithInsert(String insert) {
        this.insert = insert;
    }

    @Override
    public String format(ActionResult result) {
        if (insert.charAt(0) != ',' && insert.charAt(0) != ' ')
            insert = " " + insert;
        switch (result.getTime()) {
            case PAST:
            case PRESENT:
            case FUTURE:
                return result.getTextWithoutActor() + insert + " " + result.getActor().getCased(Case.NOMINATIVE);
            default:
                throw new FormatterTimeException("Unknown time: " + result.getTime());
        }
    }
}
