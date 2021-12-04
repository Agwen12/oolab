package agh.ics.oop;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class World {
    public static void main(String[] args) {

        try {
            List<MoveDirection> directions = OptionsParser.parse(args);
            AbstractWorldMap map = new GrassField(14);
            List<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(4, 4), new Vector2d(5, 4)));
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            System.exit(1);
        }
    }


    public static void run(String[] args, Animal animal) {
        for (MoveDirection direction : OptionsParser.parse(args)) {
            animal.move(direction);
            System.out.println(animal.toString() + "  " + direction);
        }
    }
    
}



