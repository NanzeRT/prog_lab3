package lab3.models.text;

import javax.annotation.Nonnull;

import lab3.models.common.Appearance;
import lab3.models.text.interfaces.Modifier;

public class SingleModifier implements Modifier {
    private final @Nonnull String modifier;
    private final @Nonnull String genitive;
    private final @Nonnull String dative;
    private final @Nonnull String accusative;
    private final @Nonnull String instrumental;
    private final @Nonnull String prepositional;
    private final @Nonnull Appearance appearance;

    public SingleModifier(@Nonnull String modifier, @Nonnull String genitive, @Nonnull String dative,
            @Nonnull String accusative, @Nonnull String instrumental, @Nonnull String prepositional,
            @Nonnull Appearance appearance) {
        this.modifier = modifier;
        this.genitive = genitive;
        this.dative = dative;
        this.accusative = accusative;
        this.instrumental = instrumental;
        this.prepositional = prepositional;
        this.appearance = appearance;
    }

    public SingleModifier(@Nonnull String modifier, @Nonnull String genitive, @Nonnull String dative,
            @Nonnull String accusative, @Nonnull String instrumental, @Nonnull String prepositional) {
        this.modifier = modifier;
        this.genitive = genitive;
        this.dative = dative;
        this.accusative = accusative;
        this.instrumental = instrumental;
        this.prepositional = prepositional;
        appearance = new Appearance();
    }

    @Override
    public @Nonnull String getCased(@Nonnull Case c) {
        return switch (c) {
            case NOMINATIVE -> modifier;
            case GENITIVE -> genitive;
            case DATIVE -> dative;
            case ACCUSATIVE -> accusative;
            case INSTRUMENTAL -> instrumental;
            case PREPOSITIONAL -> prepositional;
            default -> throw new IllegalArgumentException("Unknown case: " + c);
        };
    }

    @Override
    public @Nonnull Appearance getAppearance() {
        return appearance;
    }

    @Override
    public String toString() {
        return "Modifier{" +
                "modifier='" + modifier + '\'' +
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

        if (modifier != null ? !modifier.equals(modifier1.modifier) : modifier1.modifier != null)
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
        int result = modifier != null ? modifier.hashCode() : 0;
        result = 31 * result + (genitive != null ? genitive.hashCode() : 0);
        result = 31 * result + (dative != null ? dative.hashCode() : 0);
        result = 31 * result + (accusative != null ? accusative.hashCode() : 0);
        result = 31 * result + (instrumental != null ? instrumental.hashCode() : 0);
        result = 31 * result + (prepositional != null ? prepositional.hashCode() : 0);
        return result;
    }
}
