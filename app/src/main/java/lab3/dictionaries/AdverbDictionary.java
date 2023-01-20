package lab3.dictionaries;



import lab3.models.common.Appearance;
import lab3.models.common.Property;
import lab3.models.text.SingleAdverb;
import lab3.models.text.interfaces.Adverb;

public class AdverbDictionary {
    public static final Adverb Flamely = new SingleAdverb("огненно", new Appearance(Property.Bright));
    public static final Adverb Brightly = new SingleAdverb("ярко", new Appearance(Property.Bright));
}
