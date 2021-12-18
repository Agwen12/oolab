package agh.ics.oop;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    private final SortedSet<Vector2d> xSet = new TreeSet<>((o1, o2) -> {
        if (o1.x > o2.x) return 1;
        else if (o1.x < o2.x) return -1;
        else if (o1.equals(o2)) return 0;
        else {
            if (o1.y > o2.y) return 1;
            return -1;
        }
    });

    private final SortedSet<Vector2d> ySet = new TreeSet<>((o1, o2) -> {
        if (o1.y > o2.y) return 1;
        else if (o1.y < o2.y) return -1;
        else if (o1.equals(o2)) return 0;
        else {
            if (o1.x > o2.x) return 1;
            return -1;
        }
    });

    public MapBoundary() {

    }

    public void addElement(Vector2d element) {
        xSet.add(element);
        ySet.add(element);
    }

    public void removeElement(Vector2d element) {
        xSet.remove(element);
        ySet.remove(element);
    }


    @Override
    public boolean positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if (!(oldPosition.equals(newPosition))) {
            removeElement(oldPosition);
            addElement(newPosition);
            return true;
        }
        return false;
    }


    public Vector2d getLowerLeft() {
        return new Vector2d(xSet.first().x, ySet.first().y);
    }

    public Vector2d getUpperRight() {
        return new Vector2d(xSet.last().x, ySet.last().y);
    }


}
