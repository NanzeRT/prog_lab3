package org.itmo.prog.lab3.models.environment;

import org.itmo.prog.lab3.models.common.Appearance;
import org.itmo.prog.lab3.models.text.Name;

public class Sky extends Environment {
    public Sky(Name name) {
        super(name);
    }

    public Sky(Name name, Appearance appearance) {
        super(name, appearance);
    }
}
