package org.itmo.prog.lab3.models.actions;

import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.text.Case;
import org.itmo.prog.lab3.models.text.Verb;
import org.itmo.prog.lab3.models.text.interfaces.HasCases;

public class InfinitiveActionWithTargetFromVerb extends BasicAction {
    private Verb verb;
    private HasCases target;

    public InfinitiveActionWithTargetFromVerb(Verb verb, HasCases target) {
        this.verb = verb;
        this.target = target;
    }

    @Override
    public ActionResult execute(Actor actor) {
        return new ActionResult() {
            @Override
            public String getTextWithoutActor() {
                return verb.getInfinitive() + " " + target.getCased(Case.ACCUSATIVE);
            }

            @Override
            public Actor getActor() {
                return actor;
            }

            @Override
            public Verb.TimeForm getTime() {
                return Verb.TimeForm.INFINITIVE;
            }

            @Override
            public String toString() {
                return getClass().getSimpleName() + '{' +
                        "actor=" + getActor() +
                        ", text='" + getTextWithoutActor() + '\'' +
                        ", time=" + getTime() +
                        ", verb=" + verb +
                        ", target=" + target +
                        '}';
            }
        };
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + '{' +
                "verb=" + verb +
                ", target=" + target +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != getClass())
            return false;
        InfinitiveActionWithTargetFromVerb other = (InfinitiveActionWithTargetFromVerb) obj;
        return verb.equals(other.verb) && target.equals(other.target);
    }

    @Override
    public int hashCode() {
        return verb.hashCode() + target.hashCode();
    }
}
