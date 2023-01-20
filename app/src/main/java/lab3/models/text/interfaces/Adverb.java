package lab3.models.text.interfaces;

import javax.annotation.Nonnull;

import lab3.models.common.interfaces.HasAppearance;

public interface Adverb extends HasAppearance {
    @Nonnull
    String getAdverb();
}
