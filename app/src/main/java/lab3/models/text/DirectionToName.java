package lab3.models.text;

import javax.annotation.Nonnull;

import lab3.models.text.interfaces.Direction;

public class DirectionToName implements Direction {
    private final @Nonnull Name name;
    private final @Nonnull DirectionType directionType;

    public DirectionToName(@Nonnull Name name, @Nonnull DirectionType directionType) {
        this.name = name;
        this.directionType = directionType;
    }

    @Override
    public @Nonnull String getDirection() {
        return directionType.getPreposition() + " " + name.getCased(directionType.getCaseAfter());
    }
}
