package org.itmo.prog.lab3.models.actions;

import org.itmo.prog.lab3.dictionaries.VerbDictionary;
import org.itmo.prog.lab3.models.text.interfaces.HasCases;

public class HuggedAction extends ActionWithTargetFromVerb {
    public HuggedAction(HasCases target) {
        super(VerbDictionary.Hugged, target);
    }
}
