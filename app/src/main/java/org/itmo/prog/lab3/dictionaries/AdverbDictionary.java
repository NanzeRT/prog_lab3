package org.itmo.prog.lab3.dictionaries;



import org.itmo.prog.lab3.models.common.Appearance;
import org.itmo.prog.lab3.models.common.Property;
import org.itmo.prog.lab3.models.text.SingleAdverb;
import org.itmo.prog.lab3.models.text.interfaces.Adverb;

public class AdverbDictionary {
    public static final Adverb Flamely = new SingleAdverb("огненно", new Appearance(Property.Bright));
    public static final Adverb Brightly = new SingleAdverb("ярко", new Appearance(Property.Bright));
}
