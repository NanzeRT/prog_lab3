package org.itmo.prog.lab3.models.actors;

import java.util.List;

import org.itmo.prog.lab3.models.actions.interfaces.Action;
import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.text.Case;
import org.itmo.prog.lab3.models.text.GenderOrMultiple;

public class Group implements Actor {
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

    @Override
    public String getName() {
        return listWithAnd(actors.stream().map(Actor::getName).toList());
    }

    @Override
    public GenderOrMultiple getGender() {
        return GenderOrMultiple.Multiple;
    }

    @Override
    public String getShortCased(Case c) {
        return listWithAnd(actors.stream().map(a -> a.getShortCased(c)).toList());
    }

    @Override
    public String getCased(Case c) {
        return listWithAnd(actors.stream().map(a -> a.getCased(c)).toList());
    }

    @Override
    public String getPronoun(Case c) {
        return getGender().getPronoun().getCased(c);
    }

    private String listWithAnd(List<String> list) {
        if (list.size() < 2)
            throw new IllegalArgumentException("List too small");

        var sb = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i));
            sb.append(", ");
        }
        sb.append(" и ");
        sb.append(list.get(list.size() - 1));
        var result = sb.toString();
        if (result == null)
            throw new AssertionError();
        return result;
    }

    @Override
    public ActionResult doAction(Action action) {
        return action.execute(this);
    }
}
