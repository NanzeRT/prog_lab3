package lab3.models.text;

import lab3.models.common.Appearance;
import lab3.models.text.interfaces.Adverb;
import lab3.models.text.interfaces.Modifier;

public class CompoundMidifier implements Modifier {
    private Modifier modifier;
    private Adverb preModifier;

    public CompoundMidifier(Adverb preModifier, Modifier modifier) {
        this.preModifier = preModifier;
        this.modifier = modifier;
    }

    @Override
    public String getCased(Case c) {
        return preModifier.getAdverb() + " " + modifier.getCased(c);
    }

    @Override
    public Appearance getAppearance() {
        return modifier.getAppearance().merge(preModifier.getAppearance());
    }

    @Override
    public String toString() {
        return "CompoundMidifier{" +
                "modifier=" + modifier +
                ", preModifier=" + preModifier +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        CompoundMidifier other = (CompoundMidifier) obj;
        return preModifier.equals(other.preModifier) && modifier.equals(other.modifier);
    }

    @Override
    public int hashCode() {
        return preModifier.hashCode() + modifier.hashCode();
    }

    public static CompoundMidifier of(Adverb preModifier, Modifier modifier) {
        return new CompoundMidifier(preModifier, modifier);
    }
}
