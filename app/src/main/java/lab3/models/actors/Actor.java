package lab3.models.actors;

import lab3.models.common.interfaces.HasAppearance;
import lab3.models.text.GenderOrMultiple;
import lab3.models.text.interfaces.Named;

public interface Actor extends Named {
    GenderOrMultiple getGender();

    boolean looksAlike(HasAppearance item1, HasAppearance item2);

    boolean looksSimilar(HasAppearance item1, HasAppearance item2);
}
