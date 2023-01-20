package lab3.models.actors;

import java.util.Set;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import lab3.models.common.Property;

public class Sense {
    private float partOfSimmilarPropertiesToConsiderAlike;
    private float partOfSimmilarPropertiesToConsiderSimmilar;
    private final Set<Property> knownProperties;

    @Inject
    public Sense(@Named("partToAlike") float partOfSimmilarPropertiesToConsiderAlike,
            @Named("partToSimmilar") float partOfSimmilarPropertiesToConsiderSimmilar,
            @Named("knownProperies") Set<Property> knownProperties) {
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
