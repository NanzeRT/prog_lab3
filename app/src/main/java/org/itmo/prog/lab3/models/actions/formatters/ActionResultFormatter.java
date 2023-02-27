package org.itmo.prog.lab3.models.actions.formatters;

import org.itmo.prog.lab3.models.actions.results.ActionResult;

public abstract class ActionResultFormatter {
    public abstract String format(ActionResult result) throws FormatterTimeException;

    public static class FormatterTimeException extends RuntimeException {
        public FormatterTimeException(String message) {
            super(message);
        }
    }
}
