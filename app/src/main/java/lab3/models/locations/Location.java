package lab3.models.locations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import lab3.models.environment.EnvinronmentObject;

public class Location {
    private final @Nonnull String name;
    private final @Nonnull Map<String, EnvinronmentObject> envinronmentObjects = new HashMap<String, EnvinronmentObject>();

    public Location(@Nonnull String name) {
        this.name = name;
    }

    public void addEnvinronmentObject(EnvinronmentObject envinronmentObject) {
        envinronmentObjects.put(envinronmentObject.getName(), envinronmentObject);
    }

    public @Nonnull List<EnvinronmentObject> getEnvinronmentObject() {
        return new ArrayList<EnvinronmentObject>(envinronmentObjects.values());
    }

    public @Nonnull String getName() {
        return name;
    }
}
