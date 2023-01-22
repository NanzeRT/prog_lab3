package lab3.models.actors;

import lab3.models.actions.interfaces.Action;
import lab3.models.actions.results.ActionResult;
import lab3.models.text.Case;
import lab3.models.text.GenderOrMultiple;
import lab3.models.text.interfaces.Named;

public interface Actor extends Named {
    GenderOrMultiple getGender();
    String getPronoun(Case c);

    ActionResult doAction(Action action);
}
