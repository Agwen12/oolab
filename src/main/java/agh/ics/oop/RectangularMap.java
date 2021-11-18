package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {

    private final int width;
    private final int height;
    private final List<Animal> animalList = new ArrayList<>();

    public RectangularMap(int width, int height) {
        this.width = width - 1;
        this.height = height - 1;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (position.precedes(new Vector2d(width, height)) &&
                position.follows(new Vector2d(0, 0))) &&
                !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (!isOccupied(animal.getPosition()) && animal.getPosition().precedes(new Vector2d(width, height)) &&
                animal.getPosition().follows(new Vector2d(0, 0))) {
            animalList.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal1: animalList) {
            if (animal1.getPosition().equals(position)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal: animalList) {
            if (animal.getPosition().equals(position)) return animal;
        }
        return null;
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer =  new MapVisualizer(this);
        return mapVisualizer.draw(new Vector2d(0, 0), new Vector2d(width, height));
    }
}
