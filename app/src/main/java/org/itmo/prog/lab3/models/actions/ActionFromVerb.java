package org.itmo.prog.lab3.models.actions;

import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.text.Verb;

public class ActionFromVerb extends BasicAction {
    protected Verb verb;

    public ActionFromVerb(Verb verb) {
        this.verb = verb;
    }

    @Override
    public ActionResult execute(Actor actor) {
        return new ActionResult() {
            @Override
            public String getTextWithoutActor() {
                return verb.getForm(actor.getGender());
            }

            @Override
            public Actor getActor() {
                return actor;
            }

            @Override
            public Verb.TimeForm getTime() {
                return verb.getTime();
            }

            @Override
            public String toString() {
                return getClass().getSimpleName() + '{' +
                        "actor=" + getActor() +
                        ", text='" + getTextWithoutActor() + '\'' +
                        ", time=" + getTime() +
                        ", verb=" + verb +
                        '}';
            }
        };
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + '{' +
                "verb=" + verb +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != getClass())
            return false;
        ActionFromVerb other = (ActionFromVerb) obj;
        return verb.equals(other.verb);
    }

    @Override
    public int hashCode() {
        return verb.hashCode();
    }
}
