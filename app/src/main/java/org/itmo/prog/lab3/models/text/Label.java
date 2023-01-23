package org.itmo.prog.lab3.models.text;

public class Label extends CasedWord {
    private final GenderOrPlural genderOrMultiple;

    public Label(String nominative, String genitive, String dative,
            String accusative, String instrumental, String prepositional, GenderOrPlural genderOrMultiple) {
        super(nominative, genitive, dative, accusative, instrumental, prepositional);
        this.genderOrMultiple = genderOrMultiple;
    }

    public String getName() {
        return nominative;
    }

    public GenderOrPlural getGender() {
        return genderOrMultiple;
    }

    @Override
    public String toString() {
        return "Label{" +
                "niminative='" + nominative + '\'' +
                ", genitive='" + genitive + '\'' +
                ", dative='" + dative + '\'' +
                ", accusative='" + accusative + '\'' +
                ", instrumental='" + instrumental + '\'' +
                ", prepositional='" + prepositional + '\'' +
                ", genderOrMultiple=" + genderOrMultiple +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        
        if (!super.equals(o))
            return false;

        Label that = (Label) o;

        if (genderOrMultiple != that.genderOrMultiple)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = nominative != null ? nominative.hashCode() : 0;
        result = 31 * result + (genitive != null ? genitive.hashCode() : 0);
        result = 31 * result + (dative != null ? dative.hashCode() : 0);
        result = 31 * result + (accusative != null ? accusative.hashCode() : 0);
        result = 31 * result + (instrumental != null ? instrumental.hashCode() : 0);
        result = 31 * result + (prepositional != null ? prepositional.hashCode() : 0);
        result = 31 * result + (genderOrMultiple != null ? genderOrMultiple.hashCode() : 0);
        return result;
    }
}
