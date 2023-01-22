package lab3.utils.fluid_text;

import lab3.models.text.Case;
import lab3.models.text.GenderOrMultiple;
import lab3.models.text.Label;

public class FluidActorFromLabel extends FluidActor {
    private Label label;

    public FluidActorFromLabel(Label label) {
        this.label = label;
    }

    @Override
    public GenderOrMultiple getGender() {
        return label.getGender();
    }

    @Override
    public String getName() {
        return label.getName();
    }

    @Override
    public String getShortCased(Case c) {
        return label.getCased(c);
    }

    @Override
    public String getCased(Case c) {
        return label.getCased(c);
    }
}
