package org.itmo.prog.lab3.models.actions;

import org.itmo.prog.lab3.models.actions.formatters.InfinitiveFormatter;
import org.itmo.prog.lab3.models.actions.interfaces.Action;
import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.text.Verb;
import org.itmo.prog.lab3.models.text.VerbWithTarget;

public class ActionWithTargetInfinitiveActionFromVerb extends BasicAction {
    private VerbWithTarget verb;
    private Action action;

    public ActionWithTargetInfinitiveActionFromVerb(VerbWithTarget verb, Action action) {
        this.verb = verb;
        this.action = action;
    }

    @Override
    public ActionResult execute(Actor actor) {
        return new ActionResult() {
            @Override
            public String getTextWithoutActor() {
                return verb.getForm(actor.getGender()) + " " + actor.doAction(action).getTextByFormatter(new InfinitiveFormatter());
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
