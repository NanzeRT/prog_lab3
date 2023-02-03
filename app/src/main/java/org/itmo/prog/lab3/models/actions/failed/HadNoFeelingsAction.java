package org.itmo.prog.lab3.models.actions.failed;

import org.itmo.prog.lab3.models.actions.BasicAction;
import org.itmo.prog.lab3.models.actions.interfaces.Action;
import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.text.Verb;

public class HadNoFeelingsAction extends BasicAction {

    @Override
    public ActionResult execute(Actor actor) {
        return new ActionResult() {
            @Override
            public String getTextWithoutActor() {
                return "не имел чувств";
            }

            @Override
            public Actor getActor() {
                return actor;
            }

            @Override
            public Verb.TimeForm getTime() {
                return Verb.TimeForm.PAST;
            }
        };
    }

    @Override
    protected Action fallbackAction() {
        throw new AssertionError();
    }
}
