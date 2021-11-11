package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void canMoveTo() {
        RectangularMap map = new RectangularMap(8, 8);
        assertTrue(map.canMoveTo(new Vector2d(0, 0)));
        assertTrue(map.canMoveTo(new Vector2d(7, 7)));
        assertTrue(map.canMoveTo(new Vector2d(0, 7)));
        assertTrue(map.canMoveTo(new Vector2d(7, 0)));
        assertFalse(map.canMoveTo(new Vector2d(-1, 2)));
        assertFalse(map.canMoveTo(new Vector2d(2, -1)));
        assertFalse(map.canMoveTo(new Vector2d(0, -1)));
        assertFalse(map.canMoveTo(new Vector2d(-3, -1)));
    }

    @Test
    void place() {
        RectangularMap map = new RectangularMap(9, 9);
        assertTrue(map.place(new Animal(map)));
        assertFalse(map.place(new Animal(map)));
        assertTrue(map.place(new Animal(map, new Vector2d(0, 0))));
        assertFalse(map.place(new Animal(map, new Vector2d(-1, -1))));
        assertTrue(map.place(new Animal(map, new Vector2d(8, 8))));
    }

    @Test
    void isOccupied() {
        RectangularMap map = new RectangularMap(6, 6);
        map.place(new Animal(map));
        assertFalse(map.isOccupied(new Vector2d(0, 0)));
        assertTrue(map.isOccupied(new Vector2d(2, 2)));

    }

    @Test
    void objectAt() {
        RectangularMap map = new RectangularMap(7, 7);
        Animal animal = new Animal(map, new Vector2d(3, 1));
        map.place(animal);
        assertEquals(animal, map.objectAt(new Vector2d(3, 1)));
        assertNull(map.objectAt(new Vector2d(0, 0)));

    }
}