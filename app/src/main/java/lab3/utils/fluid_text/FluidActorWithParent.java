package lab3.utils.fluid_text;

import lab3.models.actors.Actor;
import lab3.models.text.GenderOrMultiple;

public abstract class FluidActorWithParent extends FluidActor {
    protected Actor parent;
    
    public FluidActorWithParent(Actor parent) {
        this.parent = parent;
    }

    @Override
    public GenderOrMultiple getGender() {
        return parent.getGender();
    }
}
