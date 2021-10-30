package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parseTest() {
        String[] allWrong = {"da", "d", "as", "tad"};
        String[] empty = {};
        String[] strings = {"f", "l", "b", "r", null,"fdsa","ftas", "dsa"};
        assertEquals(new ArrayList<>(Arrays.asList(MoveDirection.FORWARD, MoveDirection.LEFT,
                MoveDirection.BACKWARD, MoveDirection.RIGHT)),
                OptionsParser.parse(strings)
        );

        assertEquals(new ArrayList<>(),
                OptionsParser.parse(empty));

        assertEquals(new ArrayList<>(),
                OptionsParser.parse(allWrong));

    }

}