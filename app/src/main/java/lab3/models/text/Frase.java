package lab3.models.text;

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
}
