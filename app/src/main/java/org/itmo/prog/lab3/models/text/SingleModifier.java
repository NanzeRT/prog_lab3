package org.itmo.prog.lab3.models.text;



import org.itmo.prog.lab3.models.common.Appearance;
import org.itmo.prog.lab3.models.text.interfaces.Modifier;

public class SingleModifier implements Modifier {
    private final String nominative;
    private final String genitive;
    private final String dative;
    private final String accusative;
    private final String instrumental;
    private final String prepositional;
    private final Appearance appearance;

    public SingleModifier(String nominative, String genitive, String dative,
            String accusative, String instrumental, String prepositional,
            Appearance appearance) {
        this.nominative = nominative;
        this.genitive = genitive;
        this.dative = dative;
        this.accusative = accusative;
        this.instrumental = instrumental;
        this.prepositional = prepositional;
        this.appearance = appearance;
    }

    public SingleModifier(String modifier, String genitive, String dative,
            String accusative, String instrumental, String prepositional) {
        this.nominative = modifier;
        this.genitive = genitive;
        this.dative = dative;
        this.accusative = accusative;
        this.instrumental = instrumental;
        this.prepositional = prepositional;
        appearance = new Appearance();
    }

    @Override
    public String getCased(Case c) {
        return switch (c) {
            case NOMINATIVE -> nominative;
            case GENITIVE -> genitive;
            case DATIVE -> dative;
            case ACCUSATIVE -> accusative;
            case INSTRUMENTAL -> instrumental;
            case PREPOSITIONAL -> prepositional;
            default -> throw new IllegalArgumentException("Unknown case: " + c);
        };
    }

    @Override
    public Appearance getAppearance() {
        return appearance;
    }

    @Override
    public String toString() {
        return "Modifier{" +
                "nominative='" + nominative + '\'' +
                ", genitive='" + genitive + '\'' +
                ", dative='" + dative + '\'' +
                ", accusative='" + accusative + '\'' +
                ", instrumental='" + instrumental + '\'' +
                ", prepositional='" + prepositional + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        SingleModifier modifier1 = (SingleModifier) o;

        if (nominative != null ? !nominative.equals(modifier1.nominative) : modifier1.nominative != null)
            return false;
        if (genitive != null ? !genitive.equals(modifier1.genitive) : modifier1.genitive != null)
            return false;
        if (dative != null ? !dative.equals(modifier1.dative) : modifier1.dative != null)
            return false;
        if (accusative != null ? !accusative.equals(modifier1.accusative) : modifier1.accusative != null)
            return false;
        if (instrumental != null ? !instrumental.equals(modifier1.instrumental) : modifier1.instrumental != null)
            return false;
        return prepositional != null ? prepositional.equals(modifier1.prepositional) : modifier1.prepositional == null;
    }

    @Override
    public int hashCode() {
        int result = nominative != null ? nominative.hashCode() : 0;
        result = 31 * result + (genitive != null ? genitive.hashCode() : 0);
        result = 31 * result + (dative != null ? dative.hashCode() : 0);
        result = 31 * result + (accusative != null ? accusative.hashCode() : 0);
        result = 31 * result + (instrumental != null ? instrumental.hashCode() : 0);
        result = 31 * result + (prepositional != null ? prepositional.hashCode() : 0);
        return result;
    }
}
