package lab3.models.scene;

import java.util.HashMap;
import java.util.Map;

import lab3.models.actors.Actor;
import lab3.models.environment.Environment;
import lab3.models.text.Label;

public class Scene {
    private final Map<String, Actor> actors = new HashMap<>();
    private Actor mainActor;
    private final Map<String, Environment> envinronments = new HashMap<>();

    public void addActor(Actor actor) {
        actors.put(actor.getName(), actor);
    }

    public void addActor(Actor actor, String nickname) {
        actors.put(nickname, actor);
    }

    public void addEnvinronment(Environment envinronment) {
        envinronments.put(envinronment.getName(), envinronment);
    }

    public void addEnvinronment(Environment envinronment, String nickname) {
        envinronments.put(nickname, envinronment);
    }

    public class SceneElementNotFoundException extends Exception {
        public SceneElementNotFoundException() {
            super("Something is missing");
        }

        public SceneElementNotFoundException(String name, String type) {
            super(String.format("%s %s is missing", type, name));
        }

        public SceneElementNotFoundException(String name) {
            super(String.format("%s is missing", name));
        }
    }

    public Actor getMainActor() throws SceneElementNotFoundException {
        var mainActor = this.mainActor;
        if (mainActor == null)
            throw new SceneElementNotFoundException("Main actor");
        return mainActor;
    }

    public void setMainActor(String name) throws SceneElementNotFoundException {
        this.mainActor = getActor(name);
    }

    public Actor getActor(Label name) throws SceneElementNotFoundException {
        return getActor(name.getName());
    }

    public Actor getActor(String name) throws SceneElementNotFoundException {
        var actor = actors.get(name);
        if (actor == null)
            throw new SceneElementNotFoundException(name, "Actor");
        return actor;
    }

    public Environment getEnvinronment(Label name) throws SceneElementNotFoundException {
        return getEnvinronment(name.getName());
    }

    public Environment getEnvinronment(String name) throws SceneElementNotFoundException {
        var location = envinronments.get(name);
        if (location == null)
            throw new SceneElementNotFoundException(name, "Envinronment");
        return location;
    }

    @Override
    public String toString() {
        return "Scene{" +
                "actors=" + actors +
                ", mainActor=" + mainActor +
                ", envinronments=" + envinronments +
                '}';
    }
}
