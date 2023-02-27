package org.itmo.prog.lab3.models.actions;

import org.itmo.prog.lab3.models.actions.interfaces.Action;
import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.actors.AliveActor;
import org.itmo.prog.lab3.models.actors.Group;
import org.itmo.prog.lab3.models.actors.Shorty;

public abstract class BasicAction implements Action {
    @Override
    public ActionResult execute(Actor actor) {
        return actor.doAction(getFallbackAction());
    }

    @Override
    public ActionResult execute(AliveActor aliveActor) {
        return execute((Actor) aliveActor);
    }

    @Override
    public ActionResult execute(Shorty shorty) {
        return execute((AliveActor) shorty);
    }

    @Override
    public ActionResult execute(Group group) {
        return execute((Actor) group);
    }

    public static class CanNotBeFailedException extends AssertionError {
        public CanNotBeFailedException() {
            super("Action can not be failed");
        }
    }

    /**
     * This method should be overriden if execute(Actor) method is not
     */
    protected Action getFallbackAction() {
        throw new CanNotBeFailedException();
    }
}
