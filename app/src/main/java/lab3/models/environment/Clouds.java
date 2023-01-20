package lab3.models.environment;

import javax.annotation.Nonnull;

import lab3.models.common.Appearance;
import lab3.models.common.Property;
import lab3.models.text.Name;

public class Clouds extends EnvinronmentObject {
    public Clouds(@Nonnull Name name, @Nonnull Appearance appearance) {
        super(name, appearance);
    }

    public Clouds(@Nonnull Name name) {
        super(name);
    }

    @Override
    protected @Nonnull Appearance defaultAppearance() {
        return new Appearance(Property.Flaffy);
    }
}
