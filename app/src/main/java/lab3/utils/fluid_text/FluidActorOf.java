package lab3.utils.fluid_text;

import lab3.models.actors.Actor;
import lab3.models.text.Case;
import lab3.models.text.interfaces.HasCases;

public class FluidActorOf extends FluidActorWithParent {
    private HasCases thing;

    public FluidActorOf(Actor parent, HasCases thing) {
        super(parent);
        this.thing = thing;
    }

    @Override
    public String getName() {
        return appendOf(parent.getName());
    }

    @Override
    public String getShortCased(Case c) {
        return appendOf(parent.getShortCased(c));
    }

    @Override
    public String getCased(Case c) {
        return appendOf(parent.getCased(c));
    }
    
    private String appendOf(String s) {
        return s + " " + thing.getCased(Case.PREPOSITIONAL);
    }
}
