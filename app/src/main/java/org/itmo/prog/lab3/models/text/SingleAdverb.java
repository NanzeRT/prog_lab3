package org.itmo.prog.lab3.models.text;



import org.itmo.prog.lab3.models.common.Appearance;
import org.itmo.prog.lab3.models.text.interfaces.Adverb;

public class SingleAdverb implements Adverb {
    private final String adverb;
    private final Appearance appearance;

    public SingleAdverb(String adverb) {
        this.adverb = adverb;
        this.appearance = new Appearance();
    }

    public SingleAdverb(String adverb, Appearance appearance) {
        this.adverb = adverb;
        this.appearance = appearance;
    }

    @Override
    public String getAdverb() {
        return adverb;
    }

    @Override
    public Appearance getAppearance() {
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
