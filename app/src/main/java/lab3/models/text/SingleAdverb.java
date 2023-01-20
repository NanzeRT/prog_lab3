package lab3.models.text;

import javax.annotation.Nonnull;

import lab3.models.common.Appearance;
import lab3.models.text.interfaces.Adverb;

public class SingleAdverb implements Adverb {
    private final @Nonnull String adverb;
    private final @Nonnull Appearance appearance;

    public SingleAdverb(@Nonnull String adverb) {
        this.adverb = adverb;
        this.appearance = new Appearance();
    }

    public SingleAdverb(@Nonnull String adverb, @Nonnull Appearance appearance) {
        this.adverb = adverb;
        this.appearance = appearance;
    }

    @Override
    public @Nonnull String getAdverb() {
        return adverb;
    }

    @Override
    public @Nonnull Appearance getAppearance() {
        return appearance;
    }

    @Override
    public String toString() {
        return "StandaloneAdverb{" +
                "adverb='" + adverb + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        SingleAdverb other = (SingleAdverb) obj;
        return adverb.equals(other.adverb);
    }

    @Override
    public int hashCode() {
        return adverb.hashCode();
    }
}
