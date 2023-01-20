package lab3.models.environment;



import lab3.models.common.Appearance;
import lab3.models.common.Property;
import lab3.models.text.Name;

public class Mountains extends Environment {
    private final MountainTops tops;
    private final MountainSlopes slopes;

    public Mountains(Name name, MountainTops tops, MountainSlopes slopes) {
        super(name);
        this.tops = tops;
        this.slopes = slopes;
    }

    public Mountains(Name name, MountainTops tops, MountainSlopes slopes, Appearance appearance) {
        super(name, appearance);
        this.tops = tops;
        this.slopes = slopes;
    }

    public MountainTops getTops() {
        return tops;
    }

    public MountainSlopes getSlopes() {
        return slopes;
    }

    @Override
    public Appearance getAppearance() {
        return super.getAppearance().merge(tops.getAppearance()).merge(slopes.getAppearance());
    }

    @Override
    protected Appearance defaultAppearance() {
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
