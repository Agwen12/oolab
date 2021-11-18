package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractWorldMap {
    protected List<Animal> animalList = new ArrayList<>();






    public Object objectAt(Vector2d position) {
        for (Animal animal: animalList) {
            if (animal.getPosition().equals(position)) return animal;
        }
        return null;
    }
}
