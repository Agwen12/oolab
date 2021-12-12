package agh.ics.oop;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimulationEngine implements IEngine {

    private final AbstractWorldMap map;
    private final List<Animal> engineAnimals = new ArrayList<>();
    private final List<MoveDirection> directions;
    private boolean verbose = true;

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

    // just for testing purposes
    public Vector2d[] getAnimalsPositions() {
        return this.engineAnimals.stream()
                .map(Animal::getPosition)
                .toArray(Vector2d[]::new);
    }

    @Override
    public void run() {

        JFrame frame = new MapVisualizerWidget();
//        frame.setVisible(verbose);
        frame.setVisible(false);
        JTextArea area = (JTextArea) frame.getContentPane().getComponent(0);
        area.append(map.toString());
        if (verbose) {
            System.out.println(map.toString());
        }

        for (int i = 0; i < directions.size(); i++) {
            this.engineAnimals.get(i % engineAnimals.size()).move(directions.get(i));

            if (verbose) {
                System.out.println(map.toString());
                area.setText("");
                area.append(map.toString());

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.err.println("Program has finished!");
    }


}
