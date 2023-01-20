package lab3.models.common;

import java.util.Set;

import lab3.models.actors.Sense;

public class Appearance {
    private final Set<Property> properties;

    public Appearance(Property... properties) {
        this.properties = Set.of(properties);
    }

    public Appearance(Set<Property> properties) {
        this.properties = properties;
    }

    public Appearance merge(Appearance other) {
        Set<Property> newProperties = Set.copyOf(properties);
        newProperties.addAll(other.properties);
        return new Appearance(newProperties);
    }

    public boolean hasProperty(Property property) {
        return properties.contains(property);
    }

    public boolean like(Appearance other, Sense judgingSense) {
        return countSimmilarPropertiesPart(other, judgingSense) >= judgingSense.getPartOfSimmilarPropertiesToConsiderAlike();
    }

    public boolean simmilar(Appearance other, Sense judgingSense) {
        return countSimmilarPropertiesPart(other, judgingSense) >= judgingSense.getPartOfSimmilarPropertiesToConsiderSimmilar();
    }

    private float countSimmilarPropertiesPart(Appearance other, Sense judgingSense) {
        var knownProperties = judgingSense.getKnownProperties();

        knownProperties.retainAll(properties);
        knownProperties.retainAll(other.properties);

        var simmilarKnownPropertiesCount = knownProperties.stream()
                .filter(properties::contains)
                .filter(other.properties::contains)
                .count();
        
        var knownPropertiesCount = knownProperties.size();

        return (float) simmilarKnownPropertiesCount / knownPropertiesCount;
    }
}
