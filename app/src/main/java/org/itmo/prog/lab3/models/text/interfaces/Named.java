package org.itmo.prog.lab3.models.text.interfaces;

import org.itmo.prog.lab3.models.common.interfaces.HasAppearance;
import org.itmo.prog.lab3.models.text.Case;

public interface Named extends HasCases, HasAppearance {
    String getName();

    String getShortCased(Case c);
}
