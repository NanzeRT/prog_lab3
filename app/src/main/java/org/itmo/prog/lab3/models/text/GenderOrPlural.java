package org.itmo.prog.lab3.models.text;

public enum GenderOrPlural {
    Male,
    Female,
    Neuter,
    Plural;

    public Label getPronoun() {
        return switch (this) {
            case Male -> new Label("он", "его", "ему", "его", "ним", "нём", this);
            case Female -> new Label("она", "ее", "ей", "ее", "ней", "нёй", this);
            case Neuter -> new Label("оно", "его", "ему", "его", "ним", "нём", this);
            case Plural -> new Label("они", "их", "им", "их", "ними", "нём", this);
            default -> throw new IllegalStateException("Unexpected value: " + this);
        };
    }
}
