package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class AnimalTest {

    @Test
    void move() {
        Animal animal1 = new Animal();
        ArrayList<MoveDirection> u = new ArrayList(Arrays.asList(MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD));
        for (MoveDirection direction: u) {
            animal1.move(direction);
        }
        Animal animal2 = new Animal();
        animal2.setPosition(new Vector2d(2, 4));
        assertEquals(animal1, animal2);
        animal1.move(MoveDirection.LEFT);
        animal2.setOrientation(MapDirection.WEST);
        assertEquals(animal2.getOrientation(), animal1.getOrientation());

    }
}