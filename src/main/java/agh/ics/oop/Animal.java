package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWorldMapElement {
    private MapDirection orientation = MapDirection.NORTH;
    private final AbstractWorldMap map;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(AbstractWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }

    public Animal(AbstractWorldMap map) {
        this.map = map;
        this.position = new Vector2d(2, 2);
    }

    public Animal() {
        this.position = new Vector2d(2, 2);
        this.map = new RectangularMap(5, 5);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case LEFT -> orientation = orientation.previous();
            case RIGHT -> orientation = orientation.next();
            case FORWARD -> {
                Vector2d temp = this.position.add(this.orientation.toUnitVector());
                if (map.canMoveTo(temp)) {
                    positionChanged(this.position, temp);
                    this.position = temp;
                }
            }
            case BACKWARD -> {
                Vector2d temp = this.position.subtract(this.orientation.toUnitVector());
                if (map.canMoveTo(temp)) {
                    positionChanged(this.position, temp);
                    this.position = temp;
                }
            }
        }
    }

    public void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer: observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (!position.equals(animal.position)) return false;
        return orientation == animal.orientation;
    }

    @Override
    public int hashCode() {
        int result = position.hashCode();
        result = 31 * result + orientation.hashCode();
        return result;
    }


    @Override
    public String toString() {
        return switch (this.orientation) {
            case SOUTH -> "v";
            case NORTH -> "^";
            case WEST -> "<";
            case EAST -> ">";
        };
    }

    @Override
    public String getName() {
        return switch (this.orientation) {
            case SOUTH -> "src/main/resources/down.png";
            case NORTH -> "src/main/resources/up.png";
            case WEST -> "src/main/resources/left.png";
            case EAST -> "src/main/resources/right.png";
        };
    }
}
