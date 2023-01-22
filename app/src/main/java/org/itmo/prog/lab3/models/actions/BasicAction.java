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
        return actor.doAction(fallbackAction());
    }

    @Override
    public ActionResult execute(AliveActor aliveActor) {
        return execute((Actor)aliveActor);
    }
    
    @Override
    public ActionResult execute(Shorty shorty) {
        return execute((AliveActor)shorty);
    }
    
    @Override
    public ActionResult execute(Group group) {
        return execute((Actor)group);
    }
    
    protected abstract Action fallbackAction();
}
