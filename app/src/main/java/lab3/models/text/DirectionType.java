package lab3.models.text;

import javax.annotation.Nonnull;

public enum DirectionType {
    // "к" Case.ACCUSATIVE
    To("к", Case.ACCUSATIVE),
    // "из" Case.GENITIVE
    From("из", Case.GENITIVE),
    // "по" Case.ACCUSATIVE
    Along("по", Case.ACCUSATIVE);
    

    
    private final @Nonnull String preposition;
    private final @Nonnull Case caseAfter;

    DirectionType(@Nonnull String preposition, @Nonnull Case caseAfter) {
        this.preposition = preposition;
        this.caseAfter = caseAfter;
    }

    public @Nonnull String getPreposition() {
        return preposition;
    }

    public @Nonnull Case getCaseAfter() {
        return caseAfter;
    }

}
