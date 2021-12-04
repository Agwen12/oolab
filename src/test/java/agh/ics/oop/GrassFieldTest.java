package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void canMoveTo() {
        GrassField map = new GrassField(5);
        Animal a1 = new Animal(map, new Vector2d(2, 2));
        Animal a2 = new Animal(map, new Vector2d(1, 2));
        map.place(a1);
        map.place(a2);
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
        assertTrue(map.canMoveTo(new Vector2d(2, -1)));
    }

    @Test
    void place() {
        GrassField map = new GrassField(10);
        assertTrue(map.place(new Animal(map)));
        assertThrows(IllegalArgumentException.class , () -> map.place(new Animal(map)));
        assertTrue(map.place(new Animal(map, new Vector2d(0, 0))));
        assertTrue(map.place(new Animal(map, new Vector2d(8, 8))));
    }

    @Test
    void isOccupied() {
        GrassField map = new GrassField(10);
        map.place(new Animal(map));
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
    }

    @Test
    void objectAt() {
        GrassField map = new GrassField(10);
        Animal animal = new Animal(map, new Vector2d(3, 1));
        map.place(animal);
        assertEquals(animal, map.objectAt(new Vector2d(3, 1)));
        assertNull(map.objectAt(new Vector2d(-1, -1)));
    }
}