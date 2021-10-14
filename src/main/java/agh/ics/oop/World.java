package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class World {
    public static void main(String[] args) {

////         Wersja bez streama
//        ArrayList<Direction> l = new ArrayList<>();
//        for (String string : args) {
//            switch (string) {
//                case "f" -> l.add(Direction.FORWARD);
//                case "b" -> l.add(Direction.BACKWARDS);
//                case "l" -> l.add(Direction.LEFT);
//                case "r" -> l.add(Direction.RIGHT);
//            }
//        }
//        System.out.println("Start");
//        World.run(l);
//        System.out.println("Stop");


        // konwersja i printowanie na jednym streamie
        Stream.of(args)
                .map(arg -> switch (arg) {
                    case "f" -> Direction.FORWARD;
                    case "b" -> Direction.BACKWARDS;
                    case "l" -> Direction.LEFT;
                    case "r" -> Direction.RIGHT;
                    default -> null;
                })
                .forEach(World::printAnimal);


        // stream "na dwa razy" z funkcja run
//        ArrayList<Direction> l = Stream.of(args)
//                .map(arg -> switch (arg) {
//                    case "f" -> Direction.FORWARD;
//                    case "b" -> Direction.BACKWARDS;
//                    case "l" -> Direction.LEFT;
//                    case "r" -> Direction.RIGHT;
//                    default -> null;
//                })
//                .collect(Collectors
//                        .toCollection(ArrayList::new));


//        System.out.println("Start");
//        World.run(l);
//        System.out.println("Stop");
    }

    public static void run(ArrayList<Direction> arg) {

//        System.out.println("animal goes forward");
//        for (int i = 0; i < arg.length; i++) {
//            System.out.print(arg[i]);
//            if (i != arg.length - 1) System.out.print(", ");
//    }

        Stream<Direction> stream = arg.stream();
        stream.forEach(World::printAnimal);

        for (Direction dir : arg) {
            String res = switch (dir) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARDS -> "Zwierzak idzie do tylu";
                case RIGHT -> "Zwierzak idzie w prawo";
                case LEFT -> "Zwierzak idzie w lewo";
            };


            System.out.println(res);

        }
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



