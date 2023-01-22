package lab3.dictionaries;

import lab3.models.common.Appearance;
import lab3.models.common.Property;
import lab3.models.text.SingleModifier;
import lab3.models.text.interfaces.Modifier;

public class ModifierDictionary {
    public static final Modifier RedMultiple = new SingleModifier("красные", "красных", "красным", "красных",
            "красными", "красных", new Appearance(Property.Red));
    public static final Modifier RightFemale = new SingleModifier("правая", "правой", "правой", "правую",
            "правой", "правой");
    public static final Modifier StonedMiddle = new SingleModifier("окаменевшее", "окаменевшего", "окаменевшему",
            "окаменевшее", "окаменевшим", "окаменевшем", new Appearance(Property.Rocky));
    public static final Modifier SharpenedMultiple = new SingleModifier("заострённые", "заострённых", "заострённым",
            "заострённые", "заострёнными", "заострённых", new Appearance(Property.Sharp));
    public static final Modifier VauglyOutlinedMultiple = new SingleModifier("смутно очертанные", "смутно очертанных",
            "смутно очертанным", "смутно очертанные", "смутно очертанными", "смутно очертанных",
            new Appearance(Property.Flaffy));
    public static final Modifier FluffyFemale = new SingleModifier("пушистая", "пушистой", "пушистой", "пушистую",
            "пушистой", "пушистой", new Appearance(Property.Flaffy));
}
