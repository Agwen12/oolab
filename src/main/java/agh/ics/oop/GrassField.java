package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class GrassField implements IWorldMap {

    private final int grassPatchNumber;
    private final List<Grass> grassList = new ArrayList<>();
    private final List<Animal> animalList = new ArrayList<>();


    public GrassField(int grassPatchNumber) {
        this.grassPatchNumber = grassPatchNumber;

        double range = Math.sqrt(grassPatchNumber * 10);
        for (int i = 0; i < grassPatchNumber; i++) {
            grassList.add(new Grass(new Vector2d((int) (Math.random() * range), (int) (Math.random() * range))));
        }
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return (objectAt(position) == null || objectAt(position).getClass() == Grass.class);
    }

    @Override
    public boolean place(Animal animal) {
        if (!isOccupied(animal.getPosition())) {
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
        for (Grass grass: grassList) {
            if (grass.getPosition().equals(position)) return grass;
        }

        return null;
    }


    @Override
    public String toString() {
        MapVisualizer mapVisualizer =  new MapVisualizer(this);
        int width = animalList.stream().mapToInt(value -> value.getPosition().x).max().orElseThrow(NoSuchElementException::new);
        int height = animalList.stream().mapToInt(value -> value.getPosition().y).max().orElseThrow(NoSuchElementException::new);
        return mapVisualizer.draw(new Vector2d(0, 0), new Vector2d(width, height));
    }
}
