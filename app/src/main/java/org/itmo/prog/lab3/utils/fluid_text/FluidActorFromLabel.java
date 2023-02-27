package org.itmo.prog.lab3.utils.fluid_text;

import org.itmo.prog.lab3.models.common.Appearance;
import org.itmo.prog.lab3.models.text.Case;
import org.itmo.prog.lab3.models.text.GenderOrPlural;
import org.itmo.prog.lab3.models.text.Label;

public class FluidActorFromLabel extends FluidActor {
    private Label label;
    private Appearance appearance;

    public FluidActorFromLabel(Label label) {
        this.label = label;
        this.appearance = new Appearance();
    }

    public FluidActorFromLabel(Label label, Appearance appearance) {
        this.label = label;
        this.appearance = appearance;
    }

    @Override
    public GenderOrPlural getGender() {
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

    @Override
    public Appearance getAppearance() {
        return appearance;
    }
}
