package org.itmo.prog.lab3.models.actors;

import org.itmo.prog.lab3.models.actions.interfaces.Action;
import org.itmo.prog.lab3.models.actions.results.ActionResult;
import org.itmo.prog.lab3.models.common.Appearance;
import org.itmo.prog.lab3.models.common.interfaces.HasAppearance;
import org.itmo.prog.lab3.models.text.Case;
import org.itmo.prog.lab3.models.text.GenderOrPlural;
import org.itmo.prog.lab3.models.text.Name;

public class Shorty implements AliveActor {
    private final Name name;
    private final Sense sense;
    private final GenderOrPlural gender;

    public Shorty(Name name, GenderOrPlural gender, Sense sence) {
        this.name = name;
        this.sense = sence;
        this.gender = gender;
    }

    @Override
    public String getName() {
        return name.getCased(Case.NOMINATIVE);
    }

    @Override
    public String getShortCased(Case c) {
        return name.getShortCased(c);
    }

    @Override
    public String getCased(Case c) {
        return name.getCased(c);
    }

    @Override
    public GenderOrPlural getGender() {
        return gender;
    }

    @Override
    public String getPronoun(Case c) {
        return getGender().getPronoun().getCased(c);
    }

    @Override
    public boolean looksAlike(HasAppearance item1, HasAppearance item2) {
        return item1.getAppearance().like(item2.getAppearance(), sense);
    }

    @Override
    public boolean looksSimilar(HasAppearance item1, HasAppearance item2) {
        return item1.getAppearance().similar(item2.getAppearance(), sense);
    }

    @Override
    public ActionResult doAction(Action action) {
        return action.execute(this);
    }

    @Override
    public Appearance getAppearance() {
        return name.getAppearance();
    }
}
