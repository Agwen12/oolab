package agh.ics.oop;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {


    @Test
    void testToString() {
        assertEquals("(1,2)", new Vector2d(1, 2).toString());
    }

    @Test
    void precedes() {
        assertTrue(new Vector2d(1, 1).precedes(new Vector2d(2, 2)));
        assertTrue(new Vector2d(1, 1).precedes(new Vector2d(2, 3)));
        assertTrue(new Vector2d(2, 2).precedes(new Vector2d(2, 3)));
    }

    @Test
    void follows() {
        assertTrue(new Vector2d(3, 2).follows(new Vector2d(2, 2)));
        assertTrue(new Vector2d(3, 2).follows(new Vector2d(1, 1)));
        assertFalse(new Vector2d(2, 2).follows(new Vector2d(3, 2)));

    }

    @Test
    void upperRight() {
        assertEquals(new Vector2d(2, 2), new Vector2d(1,2).upperRight(new Vector2d(2, 1)));
    }

    @Test
    void lowerLeft() {
        assertEquals(new Vector2d(1, 1), new Vector2d(1,2).lowerLeft(new Vector2d(2, 1)));
    }

    @Test
    void add() {
        assertEquals(new Vector2d(5, 8), new Vector2d(2, 1).add(new Vector2d(3, 7)));
    }

    @Test
    void subtract() {
        assertEquals(new Vector2d(4, 1), new Vector2d(4, 2).subtract(new Vector2d(0, 1)));
    }

    @Test
    void testEquals() {
        assertEquals(new Vector2d(1, 2), new Vector2d(1, 2));
        assertNotEquals(new Vector2d(1, 2), new Vector2d(2, 2));
    }

    @Test
    void opposite() {
        assertEquals(new Vector2d(1, 1), new Vector2d(-1, -1).opposite());
    }
}
