package lab3.models.environment;

import lab3.models.common.Appearance;
import lab3.models.common.Property;
import lab3.models.text.Name;

public class MountainTops extends Environment {
    public MountainTops(Name name, Appearance appearance) {
        super(name, appearance);
    }

    public MountainTops(Name name) {
        super(name);
    }

    @Override
    protected Appearance defaultAppearance() {
        return new Appearance(Property.Static, Property.Rocky);
    }
}