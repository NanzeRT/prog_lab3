package lab3.models.actors;

import javax.annotation.Nonnull;

import lab3.models.common.interfaces.HasAppearance;
import lab3.models.text.GenderOrMultiple;
import lab3.models.text.interfaces.Named;

public interface Actor extends Named {
    @Nonnull
    GenderOrMultiple getGender();

    boolean looksAlike(@Nonnull HasAppearance item1, @Nonnull HasAppearance item2);
    boolean looksSimilar(@Nonnull HasAppearance item1, @Nonnull HasAppearance item2);
}
