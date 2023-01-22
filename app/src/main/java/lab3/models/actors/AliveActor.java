package lab3.models.actors;

import lab3.models.common.interfaces.HasAppearance;

public interface AliveActor extends Actor {
    boolean looksAlike(HasAppearance item1, HasAppearance item2);

    boolean looksSimilar(HasAppearance item1, HasAppearance item2);
}
