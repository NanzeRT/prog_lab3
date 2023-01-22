package lab3.utils.fluid_text;

import lab3.models.actors.Actor;
import lab3.models.text.Case;

public class FluidActorFromActor extends FluidActorWithParent {

    public FluidActorFromActor(Actor parent) {
        super(parent);
    }

    @Override
    public String getName() {
        return parent.getName();
    }

    @Override
    public String getShortCased(Case c) {
        return parent.getShortCased(c);
    }

    @Override
    public String getCased(Case c) {
        return parent.getCased(c);
    }
}
