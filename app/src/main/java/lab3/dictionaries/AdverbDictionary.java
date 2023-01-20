package lab3.dictionaries;

import javax.annotation.Nonnull;

import lab3.models.common.Appearance;
import lab3.models.common.Property;
import lab3.models.text.SingleAdverb;
import lab3.models.text.interfaces.Adverb;

public class AdverbDictionary {
    public static final @Nonnull Adverb flamely = new SingleAdverb("огненно", new Appearance(Property.Bright));
    public static final @Nonnull Adverb brightly = new SingleAdverb("ярко", new Appearance(Property.Bright));
}
