package org.itmo.prog.lab3.models.actions;

import org.itmo.prog.lab3.dictionaries.VerbDictionary;

public class DidntOpenedItselfAction extends NegativeActionFromVerb {
    public DidntOpenedItselfAction() {
        super(VerbDictionary.OpenedItself);
    }
}
