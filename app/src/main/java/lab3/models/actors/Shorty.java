package lab3.models.actors;

import javax.annotation.Nonnull;

import lab3.models.common.interfaces.HasAppearance;
import lab3.models.text.Case;
import lab3.models.text.GenderOrMultiple;
import lab3.models.text.Name;

public class Shorty implements Actor {
    private final @Nonnull Name name;
    private final @Nonnull Sense sense;
    private final @Nonnull GenderOrMultiple gender;

    public Shorty(@Nonnull Name name, @Nonnull GenderOrMultiple gender, @Nonnull Sense sence) {
        this.name = name;
        this.sense = sence;
        this.gender = gender;
    }

    @Override
    public @Nonnull String getName() {
        return name.getCased(Case.NOMINATIVE);
    }

    @Override
    public @Nonnull String getShortCased(@Nonnull Case c) {
        return name.getShortCased(c);
    }

    @Override
    public @Nonnull String getCased(@Nonnull Case c) {
        return name.getCased(c);
    }

    @Override
    public @Nonnull GenderOrMultiple getGender() {
        return gender;
    }

    @Override
    public boolean looksAlike(@Nonnull HasAppearance item1, @Nonnull HasAppearance item2) {
        return item1.getAppearance().like(item2.getAppearance(), sense);
    }

    @Override
    public boolean looksSimilar(@Nonnull HasAppearance item1, @Nonnull HasAppearance item2) {
        return item1.getAppearance().similar(item2.getAppearance(), sense);
    }
}
