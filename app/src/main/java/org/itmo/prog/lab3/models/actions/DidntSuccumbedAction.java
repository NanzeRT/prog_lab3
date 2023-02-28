package org.itmo.prog.lab3.models.actions;

import org.itmo.prog.lab3.dictionaries.VerbDictionary;
import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.text.Verb;
import org.itmo.prog.lab3.models.text.interfaces.HasCases;

public class DidntSuccumbedAction extends BasicAction {
    private final HasCases thingToSuccumb;

    public DidntSuccumbedAction(HasCases thingToSuccumb) {
        this.thingToSuccumb = thingToSuccumb;
    }

    @Override
    public ActionResult execute(Actor actor) {
        return new ActionResult() {
            @Override
            public String getTextWithoutActor() {
                return "не " + VerbDictionary.Succumbed.getForm(actor.getGender()) + " " + thingToSuccumb.getCased(VerbDictionary.Succumbed.getTargetCase());
            }

            @Override
            public Actor getActor() {
                return actor;
            }

            @Override
            public Verb.TimeForm getTime() {
                return VerbDictionary.Succumbed.getTime();
            }

            @Override
            public String toString() {
                return getClass().getSimpleName() + '{' +
                        "actor=" + getActor() +
                        ", text='" + getTextWithoutActor() + '\'' +
                        ", time=" + getTime() +
                        ", thingToSuccumb=" + thingToSuccumb +
                        '}';
            }
        };
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + '{' +
                "thingToSuccumb=" + thingToSuccumb +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != getClass())
            return false;
        DidntSuccumbedAction action = (DidntSuccumbedAction) obj;
        return thingToSuccumb.equals(action.thingToSuccumb);
    }

    @Override
    public int hashCode() {
        return thingToSuccumb.hashCode();
    }
}
