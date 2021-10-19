package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class World {
    public static void main(String[] args) {


//        run(args);
//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));
        System.out.println(MapDirection.EAST.next());
        System.out.println(MapDirection.EAST.previous());
        System.out.println(MapDirection.EAST.toUnitVector());
        System.out.println(MapDirection.EAST.toString());

    }

    public static void run(String[] args) {
        Stream.of(args)
                .map(arg -> switch (arg) {
                    case "f" -> Direction.FORWARD;
                    case "b" -> Direction.BACKWARDS;
                    case "l" -> Direction.LEFT;
                    case "r" -> Direction.RIGHT;
                    default -> null;
                })
                .filter(Objects::nonNull)
                .forEach(World::printAnimal);

    }

    private static void printAnimal(Direction dir) {
        String res = switch (dir) {
            case FORWARD -> "Zwierzak idzie do przodu";
            case BACKWARDS -> "Zwierzak idzie do tylu";
            case RIGHT -> "Zwierzak idzie w prawo";
            case LEFT -> "Zwierzak idzie w lewo";
        };
        System.out.println(res);
    }
}



