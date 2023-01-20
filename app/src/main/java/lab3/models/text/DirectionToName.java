package lab3.models.text;

import lab3.models.text.interfaces.Direction;

public class DirectionToName implements Direction {
    private final Name name;
    private final DirectionType directionType;

    public DirectionToName(Name name, DirectionType directionType) {
        this.name = name;
        this.directionType = directionType;
    }

    @Override
    public String getDirection() {
        return directionType.getPreposition() + " " + name.getCased(directionType.getCaseAfter());
    }
}
