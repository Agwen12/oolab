package agh.ics.oop;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class World {
    public static void main(String[] args) {

        List<MoveDirection> directions = OptionsParser.parse(args);
//        IWorldMap map = new RectangularMap(10, 5);
        IWorldMap map = new GrassField(10);
        List<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(3, 4)));
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }


    public static void run(String[] args, Animal animal) {
        for (MoveDirection direction : OptionsParser.parse(args)) {
            animal.move(direction);
            System.out.println(animal.toString() + "  " + direction);
        }
    }
}



