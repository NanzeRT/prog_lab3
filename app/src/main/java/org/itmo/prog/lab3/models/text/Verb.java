package org.itmo.prog.lab3.models.text;

// russian verb
public class Verb {
    private final String maleForm;
    private final String femaleForm;
    private final String neuterForm;
    private final String pluralForm;

    private final TimeForm timeForm;

    public static enum TimeForm {
        Past,
        Present,
        Future
    }

    public Verb(String maleForm, String femaleForm, String neuterForm, String pluralForm, TimeForm timeForm) {
        this.maleForm = maleForm;
        this.femaleForm = femaleForm;
        this.neuterForm = neuterForm;
        this.pluralForm = pluralForm;
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

    public TimeForm getTime() {
        return timeForm;
    }
}
