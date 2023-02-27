package org.itmo.prog.lab3.models.text;

public class Frase {
    private final String frase;

    public Frase(String frase) {
        this.frase = frase;
    }

    public Frase() {
        this.frase = "";
    }

    public String getFrase() {
        return frase;
    }

    public Frase asSentence() {
        return new Frase(frase.substring(0, 1).toUpperCase() + frase.substring(1) + ".");
    }

    public Frase capitalize() {
        return new Frase(frase.substring(0, 1).toUpperCase() + frase.substring(1));
    }

    public Frase comma(String frase) {
        return new Frase(this.frase + ", " + frase);
    }

    public Frase but(String frase) {
        if (this.frase.isEmpty())
            return new Frase("но " + frase);
        return new Frase(this.frase + ", но " + frase);
    }

    public Frase asIf(String frase) {
        if (this.frase.isEmpty())
            return new Frase("как бы " + frase);
        return new Frase(this.frase + ", как бы " + frase);
    }

    public Frase a(String frase) {
        if (this.frase.isEmpty())
            return new Frase("а " + frase);
        return new Frase(this.frase + ", а " + frase);
    }

    public Frase as(String frase) {
        if (this.frase.isEmpty())
            return new Frase("как " + frase);
        return new Frase(this.frase + ", как " + frase);
    }

    public Frase and(String frase) {
        if (this.frase.isEmpty())
            return new Frase("и " + frase);
        return new Frase(this.frase + ", и " + frase);
    }
}
