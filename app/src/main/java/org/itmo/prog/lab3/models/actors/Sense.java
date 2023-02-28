package org.itmo.prog.lab3.models.actors;

import java.util.Set;

import org.itmo.prog.lab3.models.common.Property;

public class Sense {
    private float partOfSimmilarPropertiesToConsiderAlike;
    private float partOfSimmilarPropertiesToConsiderSimmilar;
    private final Set<Property> knownProperties;

    public Sense() {
        this.partOfSimmilarPropertiesToConsiderAlike = 0.4f;
        this.partOfSimmilarPropertiesToConsiderSimmilar = 0.8f;
        this.knownProperties = Set.of(Property.values());
    }

    public Sense(float partOfSimmilarPropertiesToConsiderAlike, float partOfSimmilarPropertiesToConsiderSimmilar,
            Set<Property> knownProperties) {
        this.partOfSimmilarPropertiesToConsiderAlike = partOfSimmilarPropertiesToConsiderAlike;
        this.partOfSimmilarPropertiesToConsiderSimmilar = partOfSimmilarPropertiesToConsiderSimmilar;
        this.knownProperties = knownProperties;
    }

    public float getPartOfSimmilarPropertiesToConsiderAlike() {
        return partOfSimmilarPropertiesToConsiderAlike;
    }

    public float getPartOfSimmilarPropertiesToConsiderSimmilar() {
        return partOfSimmilarPropertiesToConsiderSimmilar;
    }

    public Set<Property> getKnownProperties() {
        return knownProperties;
    }

    public void addKnownProperty(Property property) {
        knownProperties.add(property);
    }

    public void removeKnownProperty(Property property) {
        knownProperties.remove(property);
    }

    public boolean isKnownProperty(Property property) {
        return knownProperties.contains(property);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + '{' +
                "partOfSimmilarPropertiesToConsiderAlike=" + partOfSimmilarPropertiesToConsiderAlike +
                ", partOfSimmilarPropertiesToConsiderSimmilar=" + partOfSimmilarPropertiesToConsiderSimmilar +
                ", knownProperties=" + knownProperties +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != getClass())
            return false;
        Sense sense = (Sense) obj;
        return partOfSimmilarPropertiesToConsiderAlike == sense.partOfSimmilarPropertiesToConsiderAlike &&
                partOfSimmilarPropertiesToConsiderSimmilar == sense.partOfSimmilarPropertiesToConsiderSimmilar &&
                knownProperties.equals(sense.knownProperties);
    }

    @Override
    public int hashCode() {
        return Float.hashCode(partOfSimmilarPropertiesToConsiderAlike) +
                Float.hashCode(partOfSimmilarPropertiesToConsiderSimmilar) +
                knownProperties.hashCode();
    }
}
