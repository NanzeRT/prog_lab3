package lab3.models.actions.interfaces;

import lab3.models.actions.results.ActionResult;
import lab3.models.actors.Actor;
import lab3.models.actors.AliveActor;
import lab3.models.actors.Group;
import lab3.models.actors.Shorty;

public interface Action {
    ActionResult execute(Actor actor);
    ActionResult execute(AliveActor aliveActor);
    ActionResult execute(Shorty shorty);
    ActionResult execute(Group group);
}
