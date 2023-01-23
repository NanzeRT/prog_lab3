package org.itmo.prog.lab3.models.text;

import org.itmo.prog.lab3.models.text.interfaces.HasCases;

public abstract class CasedWord implements HasCases {
    protected final String nominative;
    protected final String genitive;
    protected final String dative;
    protected final String accusative;
    protected final String instrumental;
    protected final String prepositional;

    public CasedWord(String nominative, String genitive, String dative,
            String accusative, String instrumental, String prepositional) {
        this.nominative = nominative;
        this.genitive = genitive;
        this.dative = dative;
        this.accusative = accusative;
        this.instrumental = instrumental;
        this.prepositional = prepositional;
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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        CasedWord casedWord = (CasedWord) obj;

        if (nominative != null ? !nominative.equals(casedWord.nominative) : casedWord.nominative != null)
            return false;
        if (genitive != null ? !genitive.equals(casedWord.genitive) : casedWord.genitive != null)
            return false;
        if (dative != null ? !dative.equals(casedWord.dative) : casedWord.dative != null)
            return false;
        if (accusative != null ? !accusative.equals(casedWord.accusative) : casedWord.accusative != null)
            return false;
        if (instrumental != null ? !instrumental.equals(casedWord.instrumental) : casedWord.instrumental != null)
            return false;
        if (prepositional != null ? !prepositional.equals(casedWord.prepositional) : casedWord.prepositional != null)
            return false;
        return true;
    }
}
