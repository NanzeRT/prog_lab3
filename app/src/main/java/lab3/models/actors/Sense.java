package lab3.models.actors;

import java.util.Set;

import lab3.models.common.Property;

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
}
