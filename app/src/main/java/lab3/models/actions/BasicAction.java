package lab3.models.actions;

import lab3.models.actions.interfaces.Action;
import lab3.models.actions.results.ActionResult;
import lab3.models.actors.Actor;
import lab3.models.actors.AliveActor;
import lab3.models.actors.Group;
import lab3.models.actors.Shorty;

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
