package org.itmo.prog.lab3.models.actions;

import org.itmo.prog.lab3.dictionaries.VerbDictionary;
import org.itmo.prog.lab3.models.text.interfaces.HasCases;

public class PressedAction extends ActionWithTargetFromVerb {
    public PressedAction(HasCases target) {
        super(VerbDictionary.Pressed, target);
    }
}
