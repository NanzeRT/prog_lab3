package lab3.models.environment;

import lab3.models.common.Appearance;
import lab3.models.common.interfaces.HasAppearance;
import lab3.models.text.Case;
import lab3.models.text.Name;
import lab3.models.text.interfaces.HasCases;

public class Mountains implements EnvinronmentObject {
    private Name name;
    private Tops tops;
    private Slopes slopes;
    private Appearance appearance;

    public class Tops implements HasCases, HasAppearance {
        private Name name;

        public Tops(Name name) {
            this.name = name;
        }

        public String getCased(Case c) {
            return name.getCased(c);
        }

        public String getName() {
            return name.getCased(Case.NOMINATIVE);
        }

        @Override
        public Appearance getAppearance() {
            return name.getAppearance();
        }

        @Override
        public String toString() {
            return "Tops{" +
                    "name=" + name +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (getClass() != obj.getClass())
                return false;
            Tops other = (Tops) obj;
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

    public class Slopes implements HasCases, HasAppearance {
        private Name name;

        public Slopes(Name name) {
            this.name = name;
        }

        @Override
        public String getCased(Case c) {
            return name.getCased(c);
        }

        public String getName() {
            return name.getCased(Case.NOMINATIVE);
        }

        @Override
        public Appearance getAppearance() {
            return name.getAppearance();
        }
    }

    public Mountains(Name name, Tops tops, Slopes slopes) {
        this.name = name;
        this.tops = tops;
        this.slopes = slopes;
    }

    public Mountains addTops(Name name) {
        tops = new Tops(name);
        return this;
    }

    public Mountains addSlopes(Name name) {
        slopes = new Slopes(name);
        return this;
    }

    public Tops getTops() {
        return tops;
    }

    public Slopes getSlopes() {
        return slopes;
    }

    @Override
    public String getCased(Case c) {
        return name.getCased(c);
    }

    @Override
    public String getShortCased(Case c) {
        return name.getShortCased(c);
    }

    @Override
    public String getName() {
        return name.getCased(Case.NOMINATIVE);
    }

    @Override
    public Appearance getAppearance() {
        return appearance.merge(name.getAppearance()).merge(tops.getAppearance()).merge(slopes.getAppearance());
    }
}
