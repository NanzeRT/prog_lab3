package lab3.models.text.interfaces;

import javax.annotation.Nonnull;

import lab3.models.text.Case;

public interface Named extends HasCases {
    @Nonnull
    String getName();

    @Nonnull
    String getShortCased(@Nonnull Case c);
}
