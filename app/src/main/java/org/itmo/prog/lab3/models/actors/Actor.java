package org.itmo.prog.lab3.models.actors;

import org.itmo.prog.lab3.models.actions.interfaces.Action;
import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.text.Case;
import org.itmo.prog.lab3.models.text.GenderOrPlural;
import org.itmo.prog.lab3.models.text.interfaces.Named;

public interface Actor extends Named {
    GenderOrPlural getGender();
    String getPronoun(Case c);

    ActionResult doAction(Action action);
}
