package org.itmo.prog.lab3.models.actions;

import org.itmo.prog.lab3.dictionaries.VerbDictionary;
import org.itmo.prog.lab3.models.text.interfaces.HasCases;

public class WantingToCheerUpAction extends GerundActionWithTargetInfinitiveActionFromVerb {
    public WantingToCheerUpAction(HasCases target) {
        super(VerbDictionary.Wanted, new InfinitiveActionWithTargetFromVerb(VerbDictionary.CheeredUp, target));
    }
}
