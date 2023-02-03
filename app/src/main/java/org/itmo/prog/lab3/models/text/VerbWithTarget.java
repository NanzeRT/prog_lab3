package org.itmo.prog.lab3.models.text;

public class VerbWithTarget extends Verb {
    private final Case targetCase;

    public VerbWithTarget(String firstPersonSingular, String secondPersonSingular, String thirdPersonSingular, String plural, String gerund, String infinitive, TimeForm time, Case targetCase) {
        super(firstPersonSingular, secondPersonSingular, thirdPersonSingular, plural, gerund, infinitive, time);
        this.targetCase = targetCase;
    }

    public Case getTargetCase() {
        return targetCase;
    }
}
