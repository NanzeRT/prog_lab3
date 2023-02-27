package org.itmo.prog.lab3.models.text;

public class VerbWithTarget extends Verb {
    private final Case targetCase;
    
    public VerbWithTarget(String maleForm, String femaleForm, String neuterForm, String pluralForm, String gerund,
            String infinitive, TimeForm timeForm, Case targetCase) {
        super(maleForm, femaleForm, neuterForm, pluralForm, gerund, infinitive, timeForm);
        this.targetCase = targetCase;
    }

    public Case getTargetCase() {
        return targetCase;
    }
}
