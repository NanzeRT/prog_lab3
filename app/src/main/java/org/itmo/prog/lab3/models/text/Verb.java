package org.itmo.prog.lab3.models.text;

// russian verb
public class Verb {
    private final String maleForm;
    private final String femaleForm;
    private final String neuterForm;
    private final String pluralForm;
    private final String gerund;
    private final String infinitive;

    private final TimeForm timeForm;

    public static enum TimeForm {
        PAST,
        PRESENT,
        FUTURE,
        GERUND,
        INFINITIVE,
    }

    public Verb(String maleForm, String femaleForm, String neuterForm, String pluralForm, String gerund, String infinitive, TimeForm timeForm) {
        this.maleForm = maleForm;
        this.femaleForm = femaleForm;
        this.neuterForm = neuterForm;
        this.pluralForm = pluralForm;
        this.gerund = gerund;
        this.infinitive = infinitive;
        this.timeForm = timeForm;
    }

    public String getForm(GenderOrPlural gender) {
        return switch(gender) {
            case Male -> maleForm;
            case Female -> femaleForm;
            case Neuter -> neuterForm;
            case Plural -> pluralForm;
        };
    }

    public String getGerund() {
        return gerund;
    }

    public String getInfinitive() {
        return infinitive;
    }

    public TimeForm getTime() {
        return timeForm;
    }
}
