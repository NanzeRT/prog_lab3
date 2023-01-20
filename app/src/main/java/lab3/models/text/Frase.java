package lab3.models.text;

public class Frase {
    private String frase;

    public Frase(String frase) {
        this.frase = frase;
    }

    public String getFrase() {
        return frase;
    }

    public Frase comma(String frase) {
        return new Frase(this.frase + ", " + frase);
    }
}
