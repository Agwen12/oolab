package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class World {
    public static void main(String[] args) {


        Animal animal = new Animal();
        System.out.println(animal.toString());
        run(args, animal);

    }

    public static void run(String[] args, Animal animal) {
//        ArrayList<MoveDirection> u = ;
        for (MoveDirection direction: OptionsParser.parse(args)) {
            animal.move(direction);
            System.out.println(animal.toString() + "  " + direction);
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



