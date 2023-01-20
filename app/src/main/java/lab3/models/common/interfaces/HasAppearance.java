package lab3.models.common.interfaces;

import javax.annotation.Nonnull;

import lab3.models.common.Appearance;

public interface HasAppearance {
    @Nonnull
    Appearance getAppearance();
}
