package org.itmo.prog.lab3.models.environment;



import org.itmo.prog.lab3.models.common.Appearance;
import org.itmo.prog.lab3.models.common.interfaces.HasAppearance;
import org.itmo.prog.lab3.models.text.Case;
import org.itmo.prog.lab3.models.text.Name;
import org.itmo.prog.lab3.models.text.interfaces.Named;

public abstract class Environment implements HasAppearance, Named {
    protected final Name name;
    protected final Appearance appearance;

    public Environment(Name name, Appearance appearance) {
        this.name = name;
        this.appearance = defaultAppearance().merge(appearance);
    }

    public Environment(Name name) {
        this.name = name;
        this.appearance = defaultAppearance();
    }

    @Override
    public String getName() {
        return name.getCased(Case.NOMINATIVE);
    }

    @Override
    public String getCased(Case c) {
        return name.getCased(c);
    }

    @Override
    public String getShortCased(Case c) {
        return name.getCased(c);
    }

    @Override
    public Appearance getAppearance() {
        return name.getAppearance().merge(appearance);
    }

    protected Appearance defaultAppearance() {
        return new Appearance();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "name=" + name +
                ", appearance=" + appearance +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        Environment other = (Environment) obj;
        return name.equals(other.name) && appearance.equals(other.appearance);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + 31 * appearance.hashCode();
    }
}
