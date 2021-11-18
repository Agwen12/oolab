package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractWorldMap {
    protected List<AbstractWorldMapElement> elementList = new ArrayList<>();
    protected Vector2d lowerLeft = new Vector2d(0, 0);
    protected Vector2d upperRight = new Vector2d(0, 0);
    protected MapVisualizer mapVisualizer;

    public boolean canMoveTo(Vector2d position) {
        return (objectAt(position) == null ||
                objectAt(position).getClass() != Animal.class);
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            elementList.add(animal);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        for (AbstractWorldMapElement element: elementList) {
            if (position.equals(element.getPosition())) return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (AbstractWorldMapElement element: elementList) if (position.equals(element.getPosition())) return element;
        return null;
    }

    public String toString() {
        return mapVisualizer.draw(this.lowerLeft, this.upperRight);
    }
}
