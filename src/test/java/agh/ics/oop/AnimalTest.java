package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AnimalTest {

    @Test
    void move() {
        Animal animal = new Animal();
        World.run(new String[]{"f", "f", "f", "f", "f", "f"}, animal);
        assertEquals("(2,4) Północ", animal.toString());

        World.run(new String[]{"b", "b", "b", "b", "b", "b"}, animal);
        assertEquals("(2,0) Północ", animal.toString());

        World.run(new String[]{"l", "f", "f", "f", "f", "f"}, animal);
        assertEquals("(0,0) Zachód", animal.toString());

        World.run(new String[]{"r", "r", "f", "f", "f", "f", "f", "f"}, animal);
        assertEquals("(4,0) Wschód", animal.toString());
    }
}