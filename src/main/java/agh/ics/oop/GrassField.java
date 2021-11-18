package agh.ics.oop;

import java.util.*;
import java.util.stream.IntStream;

public class GrassField implements IWorldMap {

    private final int grassPatchNumber;
    private final List<Grass> grassList = new ArrayList<>();
    private final List<Animal> animalList = new ArrayList<>();


    public GrassField(int grassPatchNumber) {
        this.grassPatchNumber = grassPatchNumber;
        double range = Math.sqrt(grassPatchNumber * 10);
        int grassCounter = 0;
        while (grassCounter < this.grassPatchNumber) {
            Vector2d pos = new Vector2d((int) (Math.random() * range), (int) (Math.random() * range));
            if (objectAt(pos) == null) {
                grassList.add(new Grass(pos));
                grassCounter++;
            }
        }
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return (objectAt(position) == null || objectAt(position).getClass() != Animal.class);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position =  animal.getPosition();
        if (!isOccupied(position) || objectAt(position).getClass() != Animal.class) {
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
        for (Grass grass: grassList) {
            if (position.equals(grass.getPosition())) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal: animalList) {
            if (animal.getPosition().equals(position)) return animal;
        }
        for (Grass grass: grassList) {
            if (position.equals(grass.getPosition())) return grass;
        }
        return null;
    }


    @Override
    public String toString() {
        MapVisualizer mapVisualizer =  new MapVisualizer(this);
        Vector2d topRight = new Vector2d((int) Math.sqrt(grassPatchNumber) + 1, (int) Math.sqrt(grassPatchNumber) + 1);
        Vector2d bottomLeft = new Vector2d(0, 0);
        for (Animal animal: animalList) {
            topRight = animal.getPosition().upperRight(topRight);
            bottomLeft = animal.getPosition().lowerLeft(bottomLeft);
        }
        for (Grass grass: grassList) {
            topRight = grass.getPosition().upperRight(topRight);
            bottomLeft = grass.getPosition().lowerLeft(bottomLeft);
        }

        return mapVisualizer.draw(bottomLeft, topRight);
    }
}
