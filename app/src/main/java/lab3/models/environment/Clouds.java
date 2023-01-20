package lab3.models.environment;



import lab3.models.common.Appearance;
import lab3.models.common.Property;
import lab3.models.text.Name;

public class Clouds extends Environment {
    public Clouds(Name name, Appearance appearance) {
        super(name, appearance);
    }

    public Clouds(Name name) {
        super(name);
    }

    @Override
    protected Appearance defaultAppearance() {
        return new Appearance(Property.Flaffy);
    }
}
