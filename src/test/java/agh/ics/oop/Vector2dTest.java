package agh.ics.oop;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {


    @Test
    void testToString() {
        assertEquals("(1,2)", new Vector2d(1, 2).toString());
        assertEquals("(-3,-2)", new Vector2d(-3, -2).toString());
    }

    @Test
    void precedes() {
        assertTrue(new Vector2d(1, 1).precedes(new Vector2d(2, 2)));
        assertTrue(new Vector2d(1, 1).precedes(new Vector2d(2, 3)));
        assertTrue(new Vector2d(2, 2).precedes(new Vector2d(2, 3)));
        assertTrue(new Vector2d(2, 2).precedes(new Vector2d(2, 2)));
    }

    @Test
    void follows() {
        assertTrue(new Vector2d(3, 2).follows(new Vector2d(2, 2)));
        assertTrue(new Vector2d(3, 2).follows(new Vector2d(1, 1)));
        assertFalse(new Vector2d(2, 2).follows(new Vector2d(3, 2)));
        assertTrue(new Vector2d(2, 2).follows(new Vector2d(2, 2)));

    }

    @Test
    void upperRight() {
        assertEquals(new Vector2d(2, 2), new Vector2d(1,2).upperRight(new Vector2d(2, 1)));
        assertEquals(new Vector2d(1, 5), new Vector2d(-1,5).upperRight(new Vector2d(1, -1)));
        assertEquals(new Vector2d(-2, 1), new Vector2d(-2,-3).upperRight(new Vector2d(-4, 1)));
    }

    @Test
    void lowerLeft() {
        assertEquals(new Vector2d(1, 2), new Vector2d(1,9).lowerLeft(new Vector2d(8, 2)));
        assertEquals(new Vector2d(0, -19), new Vector2d(0,0).lowerLeft(new Vector2d(0, -19)));
        assertEquals(new Vector2d(6, 13), new Vector2d(100,100).lowerLeft(new Vector2d(6, 13)));
    }

    @Test
    void add() {
        assertEquals(new Vector2d(5, 8), new Vector2d(2, 1).add(new Vector2d(3, 7)));
        assertEquals(new Vector2d(0, 0), new Vector2d(0, 0).add(new Vector2d(0, 0)));
        assertEquals(new Vector2d(-15, -8), new Vector2d(-12, 2).add(new Vector2d(-3, -10)));
    }

    @Test
    void subtract() {
        assertEquals(new Vector2d(-1, -6), new Vector2d(2, 1).subtract(new Vector2d(3, 7)));
        assertEquals(new Vector2d(0, 0), new Vector2d(0, 0).subtract(new Vector2d(0, 0)));
        assertEquals(new Vector2d(-9, 12), new Vector2d(-12, 2).subtract(new Vector2d(-3, -10)));
    }

    @Test
    void testEquals() {
        assertEquals(new Vector2d(1, 2), new Vector2d(1, 2));
        assertNotEquals(new Vector2d(1, 2), new Vector2d(2, 2));
    }

    @Test
    void opposite() {
        assertEquals(new Vector2d(1, 1), new Vector2d(-1, -1).opposite());
        assertEquals(new Vector2d(3, -1), new Vector2d(-3, 1).opposite());
        assertEquals(new Vector2d(0, 0), new Vector2d(0, 0).opposite());
    }

//    @Test
//    void compareTo() {
//        assertEquals(-1, new Vector2d(2,2).compareTo(new Vector2d(3, 2)));
//        assertEquals(-1, new Vector2d(2,2).compareTo(new Vector2d(2, 3)));
//        assertEquals(1, new Vector2d(20,21).compareTo(new Vector2d(3, 2)));
//        assertEquals(1, new Vector2d(20,2).compareTo(new Vector2d(3, 2)));
//        assertEquals(1, new Vector2d(2,20).compareTo(new Vector2d(3, 2)));
//    }
}
