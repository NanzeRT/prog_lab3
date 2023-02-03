package org.itmo.prog.lab3.models.actions;

import org.itmo.prog.lab3.dictionaries.VerbDictionary;
import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.text.Verb;

public class SweptAction extends BasicAction {
    @Override
    public ActionResult execute(Actor actor) {
        return new ActionResult() {
            @Override
            public String getTextWithoutActor() {
                return VerbDictionary.Raced.getForm(actor.getGender());
            }

            @Override
            public Actor getActor() {
                return actor;
            }

            @Override
            public Verb.TimeForm getTime() {
                return VerbDictionary.Raced.getTime();
            }
        };
    }
}
