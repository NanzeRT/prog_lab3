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
        };
    }
}
