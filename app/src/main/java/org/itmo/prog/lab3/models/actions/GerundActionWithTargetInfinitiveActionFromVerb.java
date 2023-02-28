package org.itmo.prog.lab3.models.actions;

import org.itmo.prog.lab3.models.actions.formatters.InfinitiveFormatter;
import org.itmo.prog.lab3.models.actions.interfaces.Action;
import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.text.Verb;
import org.itmo.prog.lab3.models.text.VerbWithTarget;
import org.itmo.prog.lab3.models.text.Verb.TimeForm;

public class GerundActionWithTargetInfinitiveActionFromVerb extends BasicAction {
    private VerbWithTarget verb;
    private Action action;

    public GerundActionWithTargetInfinitiveActionFromVerb(VerbWithTarget verb, Action action) {
        this.verb = verb;
        this.action = action;
    }

    @Override
    public ActionResult execute(Actor actor) {
        return new ActionResult() {
            @Override
            public String getTextWithoutActor() {
                return verb.getGerund() + " " + actor.doAction(action).getTextByFormatter(new InfinitiveFormatter());
            }

            @Override
            public Actor getActor() {
                return actor;
            }

            @Override
            public Verb.TimeForm getTime() {
                return TimeForm.GERUND;
            }

            @Override
            public String toString() {
                return getClass().getSimpleName() + '{' +
                        "actor=" + getActor() +
                        ", text='" + getTextWithoutActor() + '\'' +
                        ", time=" + getTime() +
                        ", verb=" + verb +
                        ", action=" + action +
                        '}';
            }
        };
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + '{' +
                "verb=" + verb +
                ", action=" + action +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != getClass())
            return false;
        GerundActionWithTargetInfinitiveActionFromVerb other = (GerundActionWithTargetInfinitiveActionFromVerb) obj;
        return verb.equals(other.verb) && action.equals(other.action);
    }

    @Override
    public int hashCode() {
        return verb.hashCode() + action.hashCode();
    }
}
