package lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lab3.dictionaries.LabelDicrionary;
import lab3.models.actors.Group;
import lab3.models.actors.Sense;
import lab3.models.actors.Shorty;
import lab3.models.actors.Group.GroupTooSmallException;
import lab3.models.common.Property;
import lab3.models.environment.Mountains;
import lab3.models.locations.Location;
import lab3.models.scene.Scene;
import lab3.models.text.GenderOrMultiple;
import lab3.models.text.Name;

public class App {
    public static void main(String[] args) {
        var scene = new Scene();
        scene.setMainActor(new Shorty(new Name(LabelDicrionary.NameDunno), GenderOrMultiple.Male,
                new Sense(0.3f, 0.8f, Set.of(Property.values()))));

        scene.addActor(new Shorty(new Name(LabelDicrionary.NameDonut), GenderOrMultiple.Male,
                new Sense(0.3f, 0.8f, Set.of(Property.values()))));

        try {
            scene.addGroup(new Group(
                    scene.getActor(LabelDicrionary.NameDunno),
                    scene.getActor(LabelDicrionary.NameDonut)));
        } catch (Scene.ActorNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (GroupTooSmallException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        var location = new Location("Луна");
        // location.addEnvinronmentObject(new Mountains());

    }
}
