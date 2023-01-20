package lab3.models.locations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lab3.models.environment.EnvinronmentObject;

public abstract class Location {
    private Map<String, EnvinronmentObject> envinronmentObjects = new HashMap<String, EnvinronmentObject>();

    public void addEnvinronmentObject(EnvinronmentObject envinronmentObject) {
        envinronmentObjects.put(envinronmentObject.getName(), envinronmentObject);
    }

    public List<EnvinronmentObject> getEnvinronmentObject() {
        return new ArrayList<EnvinronmentObject>(envinronmentObjects.values());
    }

}
