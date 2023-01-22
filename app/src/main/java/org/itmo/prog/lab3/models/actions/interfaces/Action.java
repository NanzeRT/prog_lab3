package org.itmo.prog.lab3.models.actions.interfaces;

import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.actors.AliveActor;
import org.itmo.prog.lab3.models.actors.Group;
import org.itmo.prog.lab3.models.actors.Shorty;

public interface Action {
    ActionResult execute(Actor actor);
    ActionResult execute(AliveActor aliveActor);
    ActionResult execute(Shorty shorty);
    ActionResult execute(Group group);
}
