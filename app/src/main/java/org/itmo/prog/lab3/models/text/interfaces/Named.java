package org.itmo.prog.lab3.models.text.interfaces;

import org.itmo.prog.lab3.models.text.Case;

public interface Named extends HasCases {
    String getName();

    String getShortCased(Case c);
}
