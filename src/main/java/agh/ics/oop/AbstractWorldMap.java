package agh.ics.oop;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

abstract public class AbstractWorldMap {
    protected Map<Vector2d, AbstractWorldMapElement> elementMap = new LinkedHashMap<>();
    protected Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
    protected MapVisualizer mapVisualizer;

    public boolean canMoveTo(Vector2d position) {
        return (!(objectAt(position) instanceof Animal));
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            elementMap.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        AbstractWorldMapElement elem = elementMap.get(position);
        return elem != null && position.equals(elem.getPosition());
    }

    public Object objectAt(Vector2d position) {
//        Object obj = null;
////        for (AbstractWorldMapElement element : elementMap) {
//            if (position.equals(elementMap.get(position).getPosition())) {
//                if (element instanceof Animal) {
//                    return element;
//                } else {
//                    obj = element;
////                }
//            }
//        }
//        return obj;
        return elementMap.get(position);
    }

    public String toString() {
        return mapVisualizer.draw(this.lowerLeft, this.upperRight);
    }

    public abstract boolean positionChanged(Vector2d oldPosition, Vector2d newPosition);
}
