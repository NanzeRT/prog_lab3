package lab3.models.actions.results;

import lab3.models.actions.formatters.ActionResultFormatter;
import lab3.models.actors.Actor;

public abstract class ActionResult {
    public abstract String getTextWithoutActor();

    public abstract Actor getActor();

    public String getTextByFormatter(ActionResultFormatter formatter) {
        return formatter.format(this);
    }
}
