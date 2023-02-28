package org.itmo.prog.lab3.models.actions.formatters;

import org.itmo.prog.lab3.models.actions.results.ActionResult;

public abstract class ActionResultFormatter {
    public abstract String format(ActionResult result) throws FormatterTimeException;

    public static class FormatterTimeException extends RuntimeException {
        public FormatterTimeException(String message) {
            super(message);
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        return obj.getClass() == getClass();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
