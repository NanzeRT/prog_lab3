package lab3.models.actors;

import java.util.List;



import lab3.models.common.interfaces.HasAppearance;
import lab3.models.text.Case;
import lab3.models.text.GenderOrMultiple;

public class Group {
    private List<Actor> actors;

    public Group(Actor... actors) throws GroupTooSmallException {
        var actorsList = List.of(actors);
        if (actorsList == null)
            throw new IllegalArgumentException("actors is null");
        this.actors = actorsList;
        if (this.actors.size() < 2)
            throw new GroupTooSmallException();
    }

    public Group(List<Actor> actors) throws GroupTooSmallException {
        this.actors = actors;
        if (actors.size() < 2)
            throw new GroupTooSmallException();
    }

    public class GroupTooSmallException extends RuntimeException {
        public GroupTooSmallException() {
            super("Group too small");
        }
    }

    public String getName() {
        return listWithAnd(actors.stream().map(Actor::getName).toList());
    }

    public GenderOrMultiple getGender() {
        return GenderOrMultiple.Multiple;
    }

    public boolean looksAlike(HasAppearance item1, HasAppearance item2) {
        return actors.stream().anyMatch(a -> a.looksAlike(item1, item2));
    }

    public boolean looksSimilar(HasAppearance item1, HasAppearance item2) {
        return actors.stream().allMatch(a -> a.looksSimilar(item1, item2));
    }

    public String getShortCased(Case c) {
        return listWithAnd(actors.stream().map(a -> a.getShortCased(c)).toList());
    }

    public String getCased(Case c) {
        return listWithAnd(actors.stream().map(a -> a.getCased(c)).toList());
    }

    private String listWithAnd(List<String> list) {
        if (list.size() < 2)
            throw new IllegalArgumentException("List too small");
        
        var sb = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i));
            sb.append(", ");
        }
        sb.append("и ");
        sb.append(list.get(list.size() - 1));
        var result = sb.toString();
        if (result == null)
            throw new AssertionError();
        return result;
    }
}
