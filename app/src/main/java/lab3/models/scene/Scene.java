package lab3.models.scene;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import lab3.models.actors.Actor;
import lab3.models.actors.Group;
import lab3.models.locations.Location;
import lab3.models.text.Label;

public class Scene {
    private final @Nonnull Map<String, Actor> actors = new HashMap<>();
    private final @Nonnull Map<String, Group> groups = new HashMap<>();
    private Actor mainActor;
    private final @Nonnull Map<String, Location> locations = new HashMap<>();

    public void addActor(@Nonnull Actor actor) {
        actors.put(actor.getName(), actor);
    }

    public void addLocation(@Nonnull Location location) {
        locations.put(location.getName(), location);
    }

    public class ActorNotFoundException extends Exception {
        public ActorNotFoundException() {
            super("Actor not found");
        }
    }

    public @Nonnull Actor getMainActor() throws ActorNotFoundException {
        var mainActor = this.mainActor;
        if (mainActor == null)
            throw new ActorNotFoundException();
        return mainActor;
    }

    public void setMainActor(@Nonnull Actor mainActor) {
        this.mainActor = mainActor;
        addActor(mainActor);
    }

    public void addGroup(@Nonnull Group group) {
        groups.put(group.getName(), group);
    }

    public @Nonnull Actor getActor(@Nonnull Label name) throws ActorNotFoundException {
        return getActor(name.getName());
    }

    public @Nonnull Actor getActor(@Nonnull String name) throws ActorNotFoundException {
        var actor = actors.get(name);
        if (actor == null)
            throw new ActorNotFoundException();
        return actor;
    }

    public @Nonnull Group getGroup(@Nonnull Label name) throws ActorNotFoundException {
        return getGroup(name.getName());
    }

    public @Nonnull Group getGroup(@Nonnull String name) throws ActorNotFoundException {
        var group = groups.get(name);
        if (group == null)
            throw new ActorNotFoundException();
        return group;
    }

    public @Nonnull Location getLocation(@Nonnull Label name) throws ActorNotFoundException {
        return getLocation(name.getName());
    }

    public @Nonnull Location getLocation(@Nonnull String name) throws ActorNotFoundException {
        var location = locations.get(name);
        if (location == null)
            throw new ActorNotFoundException();
        return location;
    }
}
