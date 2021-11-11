package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AnimalTest {

    @Test
    void move() {
        Animal animal = new Animal();
        World.run(new String[]{"f", "f", "f", "f", "f", "f"}, animal);
        assertEquals(new Vector2d(2,4), animal.getPosition());

        World.run(new String[]{"b", "b", "b", "b", "b", "b"}, animal);
        assertEquals(new Vector2d(2,0), animal.getPosition());

        World.run(new String[]{"l", "f", "f", "f", "f", "f"}, animal);
        assertEquals(new Vector2d(0,0), animal.getPosition());

        World.run(new String[]{"r", "r", "f", "f", "f", "f", "f", "f"}, animal);
        assertEquals(new Vector2d(4,0), animal.getPosition());
    }
}