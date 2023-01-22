package lab3.utils.fluid_text;

import lab3.models.actors.Actor;
import lab3.models.text.Case;
import lab3.models.text.interfaces.HasCases;

public class FluidActorInU extends FluidActorWithParent {
    private HasCases thing;

    public FluidActorInU(Actor parent, HasCases thing) {
        super(parent);
        this.thing = thing;
    }

    @Override
    public String getName() {
        return appendInU(parent.getName());
    }

    @Override
    public String getShortCased(Case c) {
        return appendInU(parent.getShortCased(c));
    }

    @Override
    public String getCased(Case c) {
        return appendInU(parent.getCased(c));
    }

    private String appendInU(String s) {
        return s + " у " + thing.getCased(Case.GENITIVE);
    }
}
