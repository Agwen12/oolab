package agh.ics.oop;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimulationEngine implements IEngine, Runnable {

    private final AbstractWorldMap map;
    private final List<Animal> engineAnimals = new ArrayList<>();
    private List<MoveDirection> directions;
    private boolean verbose = true;
    private int moveDelay = 300;

    public SimulationEngine(List<MoveDirection> directions, AbstractWorldMap map, List<Vector2d> positions) {
        this.directions = directions;
        this.map = map;
        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);

            if (map.place(animal))  {
                engineAnimals.add(animal);
                animal.addObserver(this.map);
            }
        }
    }

    public SimulationEngine(List<MoveDirection> directions, AbstractWorldMap map, List<Vector2d> positions, boolean verbose) {
        this.directions = directions;
        this.map = map;
        this.verbose = verbose;
        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);
            if (map.place(animal)) {
                engineAnimals.add(animal);
                animal.addObserver(this.map);
            }
        }
    }

    public SimulationEngine(AbstractWorldMap map, List<Vector2d> positions) {
        this.map = map;
        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);
            if (map.place(animal)) {
                engineAnimals.add(animal);
                animal.addObserver(this.map);
            }
        }
    }

    // just for testing purposes
    public Vector2d[] getAnimalsPositions() {
        return this.engineAnimals.stream()
                .map(Animal::getPosition)
                .toArray(Vector2d[]::new);
    }

    public Animal[] getAnimals() {
        return this.engineAnimals.toArray(Animal[]::new);
//                .stream()
//                .toArray(Animal[]::new);
    }


    public void setDirections(List<MoveDirection> directions) {
        this.directions = directions;
    }

    @Override
    public void run() {

        for (int i = 0; i < directions.size(); i++) {
            this.engineAnimals.get(i % engineAnimals.size()).move(directions.get(i));


//            System.out.println(map.toString());
            try {
                TimeUnit.MILLISECONDS.sleep(this.moveDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.err.println("Program has finished!");
    }


}
