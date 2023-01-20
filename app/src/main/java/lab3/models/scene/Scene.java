package lab3.models.scene;

import java.util.HashMap;
import java.util.Map;

import lab3.models.actors.Actor;
import lab3.models.actors.Group;
import lab3.models.environment.Environment;
import lab3.models.text.Label;

public class Scene {
    private final Map<String, Actor> actors = new HashMap<>();
    private final Map<String, Group> groups = new HashMap<>();
    private Actor mainActor;
    private final Map<String, Environment> envinronments = new HashMap<>();

    public void addActor(Actor actor) {
        actors.put(actor.getName(), actor);
    }

    public void addEnvinronment(Environment envinronment) {
        envinronments.put(envinronment.getName(), envinronment);
    }

    public class ActorNotFoundException extends Exception {
        public ActorNotFoundException() {
            super("Actor not found");
        }
    }

    public Actor getMainActor() throws ActorNotFoundException {
        var mainActor = this.mainActor;
        if (mainActor == null)
            throw new ActorNotFoundException();
        return mainActor;
    }

    public void setMainActor(Actor mainActor) {
        this.mainActor = mainActor;
        addActor(mainActor);
    }

    public void addGroup(Group group) {
        groups.put(group.getName(), group);
    }

    public Actor getActor(Label name) throws ActorNotFoundException {
        return getActor(name.getName());
    }

    public Actor getActor(String name) throws ActorNotFoundException {
        var actor = actors.get(name);
        if (actor == null)
            throw new ActorNotFoundException();
        return actor;
    }

    public Group getGroup(Label name) throws ActorNotFoundException {
        return getGroup(name.getName());
    }

    public Group getGroup(String name) throws ActorNotFoundException {
        var group = groups.get(name);
        if (group == null)
            throw new ActorNotFoundException();
        return group;
    }

    public Environment getEnvinronment(Label name) throws ActorNotFoundException {
        return getEnvinronment(name.getName());
    }

    public Environment getEnvinronment(String name) throws ActorNotFoundException {
        var location = envinronments.get(name);
        if (location == null)
            throw new ActorNotFoundException();
        return location;
    }

    @Override
    public String toString() {
        return "Scene{" +
                "actors=" + actors +
                ", groups=" + groups +
                ", mainActor=" + mainActor +
                ", envinronments=" + envinronments +
                '}';
    }
}
