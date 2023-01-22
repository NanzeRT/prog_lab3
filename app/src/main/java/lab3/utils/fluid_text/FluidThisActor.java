package lab3.utils.fluid_text;

import lab3.models.actors.Actor;
import lab3.models.text.Case;
import lab3.models.text.GenderOrMultiple;

public class FluidThisActor extends FluidActorWithParent {
    public FluidThisActor(Actor parent) {
        super(parent);
    }

    @Override
    public String getName() {
        return appendThis(parent.getName(), parent.getGender());
    }

    @Override
    public String getShortCased(Case c) {
        return appendThis(parent.getShortCased(c), parent.getGender());
    }

    @Override
    public String getCased(Case c) {
        return appendThis(parent.getCased(c), parent.getGender());
    }

    private String appendThis(String s, GenderOrMultiple gender) {
        return switch (gender) {
            case Male -> "этот " + s;
            case Female -> "эта " + s;
            case Multiple -> "эти " + s;
            case Neuter -> "это " + s;
            default -> throw new IllegalStateException("Unexpected value: " + gender);
        };
    }
}
