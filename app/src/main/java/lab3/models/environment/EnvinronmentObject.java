package lab3.models.environment;

import javax.annotation.Nonnull;

import lab3.models.common.Appearance;
import lab3.models.common.interfaces.HasAppearance;
import lab3.models.text.Case;
import lab3.models.text.Name;
import lab3.models.text.interfaces.Named;

public abstract class EnvinronmentObject implements HasAppearance, Named {
    protected final @Nonnull Name name;
    protected final @Nonnull Appearance appearance;

    public EnvinronmentObject(@Nonnull Name name, @Nonnull Appearance appearance) {
        this.name = name;
        this.appearance = defaultAppearance().merge(appearance);
    }

    public EnvinronmentObject(@Nonnull Name name) {
        this.name = name;
        this.appearance = defaultAppearance();
    }

    @Override
    public @Nonnull String getName() {
        return name.getCased(Case.NOMINATIVE);
    }

    @Override
    public @Nonnull String getCased(@Nonnull Case c) {
        return name.getCased(c);
    }

    @Override
    public @Nonnull String getShortCased(@Nonnull Case c) {
        return name.getCased(c);
    }

    @Override
    public @Nonnull Appearance getAppearance() {
        return name.getAppearance().merge(appearance);
    }

    protected @Nonnull Appearance defaultAppearance() {
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
        EnvinronmentObject other = (EnvinronmentObject) obj;
        return name.equals(other.name) && appearance.equals(other.appearance);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + 31 * appearance.hashCode();
    }
}
