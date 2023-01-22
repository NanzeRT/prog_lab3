package org.itmo.prog.lab3.models.text;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private final List<Frase> frases = new ArrayList<>();

    public void addFrase(Frase frase) {
        frases.add(frase.asSentence());
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        for (Frase frase : frases) {
            sb.append(frase.getFrase());
            sb.append("\n");
        }
        return sb.toString();
    }
}
