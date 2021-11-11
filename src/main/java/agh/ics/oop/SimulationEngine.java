package agh.ics.oop;

import javax.swing.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimulationEngine implements IEngine {

    private final IWorldMap map;
    private final List<Animal> engineAnimals = new ArrayList<>();
    private final List<MoveDirection> directions;

    public SimulationEngine(List<MoveDirection> directions, IWorldMap map, List<Vector2d> positions) {
        this.directions = directions;
        this.map = map;
        for (Vector2d position: positions) {
            Animal animal = new Animal(map, position);
            if (map.place(animal)) engineAnimals.add(animal);

        }

    }

    @Override
    public void run() {
        JFrame frame = new MapVisualizerWidget();
        JTextArea area = (JTextArea) frame.getContentPane().getComponent(0);
        area.append(map.toString());
        for (int i = 0; i < directions.size(); i++) {
            this.engineAnimals.get(i % engineAnimals.size()).move(directions.get(i));
            area.setText("");
            area.append(map.toString());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
