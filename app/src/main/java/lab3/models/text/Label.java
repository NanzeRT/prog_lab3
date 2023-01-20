package lab3.models.text;

import lab3.models.common.Appearance;
import lab3.models.common.interfaces.HasAppearance;
import lab3.models.text.interfaces.HasCases;

public class Label implements HasCases, HasAppearance {
    private final String name;
    private final String genitive;
    private final String dative;
    private final String accusative;
    private final String instrumental;
    private final String prepositional;
    private final Appearance appearance;

    public Label(String name, String genitive, String dative,
            String accusative, String instrumental, String prepositional, Appearance appearance) {
        this.name = name;
        this.genitive = genitive;
        this.dative = dative;
        this.accusative = accusative;
        this.instrumental = instrumental;
        this.prepositional = prepositional;
        this.appearance = appearance;
    }

    public Label(String name, String genitive, String dative,
            String accusative, String instrumental, String prepositional) {
        this.name = name;
        this.genitive = genitive;
        this.dative = dative;
        this.accusative = accusative;
        this.instrumental = instrumental;
        this.prepositional = prepositional;
        this.appearance = new Appearance();
    }

    @Override
    public String getCased(Case c) {
        switch (c) {
            case NOMINATIVE:
                return name;
            case GENITIVE:
                return genitive;
            case DATIVE:
                return dative;
            case ACCUSATIVE:
                return accusative;
            case INSTRUMENTAL:
                return instrumental;
            case PREPOSITIONAL:
                return prepositional;
            default:
                return null;
        }
    }

    @Override
    public Appearance getAppearance() {
        return appearance;
    }

    @Override
    public String toString() {
        return "RussianName{" +
                "name='" + name + '\'' +
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

        Label that = (Label) o;

        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;
        if (genitive != null ? !genitive.equals(that.genitive) : that.genitive != null)
            return false;
        if (dative != null ? !dative.equals(that.dative) : that.dative != null)
            return false;
        if (accusative != null ? !accusative.equals(that.accusative) : that.accusative != null)
            return false;
        if (instrumental != null ? !instrumental.equals(that.instrumental) : that.instrumental != null)
            return false;
        return prepositional != null ? prepositional.equals(that.prepositional) : that.prepositional == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (genitive != null ? genitive.hashCode() : 0);
        result = 31 * result + (dative != null ? dative.hashCode() : 0);
        result = 31 * result + (accusative != null ? accusative.hashCode() : 0);
        result = 31 * result + (instrumental != null ? instrumental.hashCode() : 0);
        result = 31 * result + (prepositional != null ? prepositional.hashCode() : 0);
        return result;
    }
}
