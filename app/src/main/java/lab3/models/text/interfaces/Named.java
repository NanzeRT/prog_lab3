package lab3.models.text.interfaces;

import lab3.models.text.Case;

public interface Named extends HasCases {
    String getName();

    String getShortCased(Case c);
}
