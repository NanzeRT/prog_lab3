package lab3.models.environment;

import lab3.models.common.Appearance;
import lab3.models.text.Case;
import lab3.models.text.Name;

public class Clouds implements EnvinronmentObject {
    private Name name;

    public Clouds(Name name) {
        this.name = name;
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
        return name.getAppearance();
    }
    
    @Override
    public String toString() {
        return "Clouds{" +
                "name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        Clouds other = (Clouds) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
