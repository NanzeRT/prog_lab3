package lab3.models.text.interfaces;

import javax.annotation.Nonnull;

import lab3.models.text.Case;

public interface HasCases {
    @Nonnull
    String getCased(@Nonnull Case c);
}
