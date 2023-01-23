package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.actors.Actor;

public final class FluidActionResultActorReplacer extends FluidActionResultWithParent {
    public static FluidActionResult replace(ActionResult parent, Actor actor) {
        if (parent instanceof FluidActionResultActorReplacer) {
            ((FluidActionResultActorReplacer) parent).setActor(actor);
            return (FluidActionResultActorReplacer) parent;
        }
        return new FluidActionResultActorReplacer(parent, actor);
    }

    private Actor actor;

    private FluidActionResultActorReplacer(ActionResult parent, Actor actor) {
        super(parent);
        this.actor = actor;
    }

    private void setActor(Actor actor) {
        this.actor = actor;
    }

    @Override
    public String getTextWithoutActor() {
        return parent.getTextWithoutActor();
    }

    @Override
    public Actor getActor() {
        return actor;
    }
}
