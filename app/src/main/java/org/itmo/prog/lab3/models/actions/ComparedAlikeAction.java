package org.itmo.prog.lab3.models.actions;

import org.itmo.prog.lab3.dictionaries.VerbDictionary;
import org.itmo.prog.lab3.models.actions.results.ActionResultBinary;
import org.itmo.prog.lab3.models.actors.Actor;
import org.itmo.prog.lab3.models.actors.AliveActor;
import org.itmo.prog.lab3.models.text.Verb.TimeForm;
import org.itmo.prog.lab3.models.text.interfaces.Named;

public class ComparedAlikeAction extends BasicAction {
    private Named thing1;
    private Named thing2;

    public ComparedAlikeAction(Named thing1, Named thing2) {
        this.thing1 = thing1;
        this.thing2 = thing2;
    }

    @Override
    public ActionResultBinary execute(AliveActor actor) {
        boolean result = actor.looksAlike(thing1, thing2);

        return new ActionResultBinary() {
            @Override
            public String getTextWithoutActor() {
                return VerbDictionary.Compared.getForm(actor.getGender()) + " " + thing1.getName() + " и "
                        + thing2.getName();
            }

            @Override
            public Actor getActor() {
                return actor;
            }

            @Override
            public TimeForm getTime() {
                return TimeForm.PRESENT;
            }

            @Override
            public boolean isPositive() {
                return result;
            }
        };
    }
}
