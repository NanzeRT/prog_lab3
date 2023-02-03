package org.itmo.prog.lab3.models.actions;

import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.text.Verb;
import org.itmo.prog.lab3.models.text.VerbWithTarget;
import org.itmo.prog.lab3.models.text.interfaces.HasCases;

public class ActionWithTargetFromVerb extends BasicAction {
    private VerbWithTarget verb;
    private HasCases target;

    public ActionWithTargetFromVerb(VerbWithTarget verb, HasCases target) {
        this.verb = verb;
        this.target = target;
    }

    @Override
    public ActionResult execute(Actor actor) {
        return new ActionResult() {
            @Override
            public String getTextWithoutActor() {
                return verb.getForm(actor.getGender()) + " " + target.getCased(verb.getTargetCase());
            }

            @Override
            public Actor getActor() {
                return actor;
            }

            @Override
            public Verb.TimeForm getTime() {
                return verb.getTime();
            }
        };
    }
}
