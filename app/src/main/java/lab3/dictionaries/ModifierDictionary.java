package lab3.dictionaries;

import javax.annotation.Nonnull;

import lab3.models.common.Appearance;
import lab3.models.common.Property;
import lab3.models.text.SingleModifier;
import lab3.models.text.interfaces.Modifier;

public class ModifierDictionary {
    public static final @Nonnull Modifier redMultiple = new SingleModifier("красные", "красных", "красным", "красных",
            "красными", "красных", new Appearance(Property.Red));
    public static final @Nonnull Modifier rightFemale = new SingleModifier("правая", "правой", "правой", "правую",
            "правой", "правой");
    public static final @Nonnull Modifier stonedMiddle = new SingleModifier("окаменевшее", "окаменевшего", "окаменевшему",
            "окаменевшее", "окаменевшим", "окаменевшем", new Appearance(Property.Rocky));
    public static final @Nonnull Modifier sharpenedMultiple = new SingleModifier("заострённые", "заострённых", "заострённым",
            "заострённых", "заострёнными", "заострённых", new Appearance(Property.Sharp));
    public static final @Nonnull Modifier vauglyOutlinedMultiple = new SingleModifier("смутно очертанные", "смутно очертанных",
            "смутно очертанным", "смутно очертанные", "смутно очертанными", "смутно очертанных",
            new Appearance(Property.Flaffy));
    public static final @Nonnull Modifier fluffyFemale = new SingleModifier("пушистая", "пушистой", "пушистой", "пушистую",
            "пушистой", "пушистой", new Appearance(Property.Flaffy));
    
}
