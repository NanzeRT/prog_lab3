package org.itmo.prog.lab3.models.text;

import java.util.ArrayList;
import java.util.List;

import org.itmo.prog.lab3.models.common.Appearance;
import org.itmo.prog.lab3.models.common.interfaces.HasAppearance;
import org.itmo.prog.lab3.models.text.interfaces.HasCases;
import org.itmo.prog.lab3.models.text.interfaces.Modifier;

public class Name implements HasCases, HasAppearance {
    private List<Modifier> modifiers = new ArrayList<>();
    private Label name;

    public Name(Label name) {
        this.name = name;
    }

    public Name addModifier(Modifier modifier) {
        modifiers.add(modifier);
        return this;
    }

    @Override
    public Appearance getAppearance() {
        Appearance appearance = new Appearance();
        for (Modifier m : modifiers)
            appearance = appearance.merge(m.getAppearance());
        return appearance;
    }

    @Override
    public String getCased(Case c) {
        StringBuilder sb = new StringBuilder();
        for (Modifier m : modifiers) {
            sb.append(m.getCased(c));
            sb.append(" ");
        }
        sb.append(name.getCased(c));
        var result = sb.toString();
        if (result == null)
            throw new AssertionError();
        return result;
    }

    public String getShortCased(Case c) {
        return name.getCased(c);
    }

    @Override
    public String toString() {
        return "Name{" +
                "modifiers=" + modifiers +
                ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        Name other = (Name) obj;
        return modifiers.equals(other.modifiers) && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (Modifier m : modifiers)
            hash += m.hashCode();
        return hash + name.hashCode();
    }

}
