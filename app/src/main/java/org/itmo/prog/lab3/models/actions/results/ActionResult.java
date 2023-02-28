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

    public boolean isSucceded () {
        return true;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + '{' +
                "actor=" + getActor() +
                ", text='" + getTextWithoutActor() + '\'' +
                ", time=" + getTime() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != getClass())
            return false;
        ActionResult other = (ActionResult) obj;
        return getActor().equals(other.getActor()) &&
                getTextWithoutActor().equals(other.getTextWithoutActor()) &&
                getTime() == other.getTime();
    }

    @Override
    public int hashCode() {
        return getActor().hashCode() + getTextWithoutActor().hashCode() + getTime().hashCode();
    }
}
