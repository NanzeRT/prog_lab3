package lab3.models.text;

import java.util.ArrayList;
import java.util.List;



public class Text {
    private final List<Frase> text = new ArrayList<>();

    public void addFrase(Frase frase) {
        text.add(frase);
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        for (Frase frase : text) {
            sb.append(frase.getFrase());
            sb.append("\n");
        }
        var result = sb.toString();
        if (result == null)
            throw new AssertionError();
        return result;
    }
}
