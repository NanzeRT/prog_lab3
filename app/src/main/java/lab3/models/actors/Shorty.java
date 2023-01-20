package lab3.models.actors;

import lab3.models.common.interfaces.HasAppearance;
import lab3.models.text.Case;
import lab3.models.text.GenderOrMultiple;
import lab3.models.text.Name;

public class Shorty implements Actor {
    private final Name name;
    private final Sense sense;
    private final GenderOrMultiple gender;

    public Shorty(Name name, GenderOrMultiple gender, Sense sence) {
        this.name = name;
        this.sense = sence;
        this.gender = gender;
    }

    @Override
    public String getName() {
        return name.getCased(Case.NOMINATIVE);
    }

    @Override
    public String getShortCased(Case c) {
        return name.getShortCased(c);
    }

    @Override
    public String getCased(Case c) {
        return name.getCased(c);
    }

    @Override
    public GenderOrMultiple getGender() {
        return gender;
    }

    @Override
    public boolean looksAlike(HasAppearance item1, HasAppearance item2) {
        return item1.getAppearance().like(item2.getAppearance(), sense);
    }

    @Override
    public boolean looksSimilar(HasAppearance item1, HasAppearance item2) {
        return item1.getAppearance().similar(item2.getAppearance(), sense);
    }
}
