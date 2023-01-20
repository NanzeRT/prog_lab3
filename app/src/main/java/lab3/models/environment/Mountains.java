package lab3.models.environment;

import javax.annotation.Nonnull;

import lab3.models.common.Appearance;
import lab3.models.common.Property;
import lab3.models.text.Name;

public class Mountains extends EnvinronmentObject {
    private final @Nonnull Tops tops;
    private final @Nonnull Slopes slopes;

    public class Tops extends EnvinronmentObject {
        public Tops(@Nonnull Name name, @Nonnull Appearance appearance) {
            super(name, appearance);
        }

        public Tops(@Nonnull Name name) {
            super(name);
        }
    }

    public class Slopes extends EnvinronmentObject {
        public Slopes(@Nonnull Name name, @Nonnull Appearance appearance) {
            super(name, appearance);
        }

        public Slopes(@Nonnull Name name) {
            super(name);
        }
    }

    public Mountains(@Nonnull Name name, @Nonnull Tops tops, @Nonnull Slopes slopes) {
        super(name);
        this.tops = tops;
        this.slopes = slopes;
    }

    public Mountains(@Nonnull Name name, @Nonnull Tops tops, @Nonnull Slopes slopes, @Nonnull Appearance appearance) {
        super(name, appearance);
        this.tops = tops;
        this.slopes = slopes;
    }

    public @Nonnull Tops getTops() {
        return tops;
    }

    public @Nonnull Slopes getSlopes() {
        return slopes;
    }

    @Override
    public @Nonnull Appearance getAppearance() {
        return super.getAppearance().merge(tops.getAppearance()).merge(slopes.getAppearance());
    }

    @Override
    protected @Nonnull Appearance defaultAppearance() {
        return new Appearance(Property.Giant, Property.Rocky, Property.Static);
    }

    @Override
    public String toString() {
        return "Mountains{" +
                "name=" + name +
                ", tops=" + tops +
                ", slopes=" + slopes +
                ", appearance=" + appearance +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        Mountains mountains = (Mountains) obj;
        return tops.equals(mountains.tops) && slopes.equals(mountains.slopes);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + tops.hashCode();
        result = 31 * result + slopes.hashCode();
        return result;
    }

}
