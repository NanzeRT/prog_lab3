package org.itmo.prog.lab3.models.common;

import java.util.HashSet;
import java.util.Set;

import org.itmo.prog.lab3.models.actors.Sense;

public class Appearance {
    private final Set<Property> properties;

    public Appearance(Property... properties) {
        this.properties = Set.of(properties);
    }

    public Appearance(Set<Property> properties) {
        this.properties = properties;
    }

    public Appearance merge(Appearance other) {
        Set<Property> newProperties = new HashSet<>(properties);
        newProperties.addAll(other.properties);
        return new Appearance(newProperties);
    }

    public boolean hasProperty(Property property) {
        return properties.contains(property);
    }

    public boolean like(Appearance other, Sense judgingSense) {
        return countSimmilarPropertiesPart(other, judgingSense) >= judgingSense.getPartOfSimmilarPropertiesToConsiderAlike();
    }

    public boolean similar(Appearance other, Sense judgingSense) {
        return countSimmilarPropertiesPart(other, judgingSense) >= judgingSense.getPartOfSimmilarPropertiesToConsiderSimmilar();
    }

    private float countSimmilarPropertiesPart(Appearance other, Sense judgingSense) {
        var knownProperties = new HashSet<>(judgingSense.getKnownProperties());

        knownProperties.retainAll(merge(other).properties);

        var simmilarKnownPropertiesCount = knownProperties.stream()
                .filter(properties::contains)
                .filter(other.properties::contains)
                .count();
        
        var knownPropertiesCount = knownProperties.size();

        return (float) simmilarKnownPropertiesCount / knownPropertiesCount;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + '{' +
                "properties=" + properties +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != getClass())
            return false;
        Appearance other = (Appearance) obj;
        return properties.equals(other.properties);
    }

    @Override
    public int hashCode() {
        return properties.hashCode();
    }
}
