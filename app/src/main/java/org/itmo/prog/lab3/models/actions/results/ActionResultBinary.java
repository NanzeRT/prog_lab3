package org.itmo.prog.lab3.models.actions.results;

public abstract class ActionResultBinary extends ActionResult {
    public abstract boolean isPositive();

    @Override
    public String toString() {
        return getClass().getSimpleName() + '{' +
                "actor=" + getActor() +
                ", text='" + getTextWithoutActor() + '\'' +
                ", time=" + getTime() +
                ", positive=" + isPositive() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != getClass())
            return false;
        ActionResultBinary other = (ActionResultBinary) obj;
        return super.equals(obj) && isPositive() == other.isPositive();
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (isPositive() ? 1 : 0);
    }
}
