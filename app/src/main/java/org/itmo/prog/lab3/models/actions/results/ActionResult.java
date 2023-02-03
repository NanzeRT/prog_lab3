package org.itmo.prog.lab3.models.actions.results;

import org.itmo.prog.lab3.models.actions.formatters.ActionResultFormatter;
import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.text.Verb;

public abstract class ActionResult {
    public abstract String getTextWithoutActor();

    public abstract Actor getActor();

    public abstract Verb.TimeForm getTime();

    public String getTextByFormatter(ActionResultFormatter formatter) {
        return formatter.format(this);
    }
}
