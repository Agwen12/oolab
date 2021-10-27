package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parseTest() {
        String[] strings = {"f", "l", "b", "r", null,"fdsa","ftas", "dsa"};
        ArrayList<MoveDirection> test = new ArrayList<>(Arrays.asList(MoveDirection.FORWARD, MoveDirection.LEFT,
                MoveDirection.BACKWARD, MoveDirection.RIGHT));
        ArrayList<MoveDirection> u = OptionsParser.parse(strings);
        assertEquals(test, u);
    }

}