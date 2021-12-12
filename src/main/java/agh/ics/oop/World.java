package agh.ics.oop;
import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class World {
    public static void main(String[] args) {
        Application.launch(App.class, args);
    }


    public static void run(String[] args, Animal animal) {
        for (MoveDirection direction : OptionsParser.parse(args)) {
            animal.move(direction);
            System.out.println(animal.toString() + "  " + direction);
        }
    }
    
}



