package lab3.models.text;

public enum DirectionType {
    // "к" Case.ACCUSATIVE
    To("к", Case.ACCUSATIVE),
    // "из" Case.GENITIVE
    From("из", Case.GENITIVE),
    // "по" Case.ACCUSATIVE
    Along("по", Case.ACCUSATIVE);

    private final String preposition;
    private final Case caseAfter;

    DirectionType(String preposition, Case caseAfter) {
        this.preposition = preposition;
        this.caseAfter = caseAfter;
    }

    public String getPreposition() {
        return preposition;
    }

    public Case getCaseAfter() {
        return caseAfter;
    }

}
