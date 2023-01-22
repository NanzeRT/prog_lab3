package org.itmo.prog.lab3.models.environment;

import org.itmo.prog.lab3.models.common.Appearance;
import org.itmo.prog.lab3.models.common.Property;
import org.itmo.prog.lab3.models.text.Name;

public class Valley extends Environment {
    public Valley(Name name) {
        super(name);
    }

    public Valley(Name name, Appearance appearance) {
        super(name, appearance);
    }

    @Override
    protected Appearance defaultAppearance() {
        return new Appearance(Property.Static);
    }
}
