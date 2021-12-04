package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parseTest() throws IllegalArgumentException {

        String[] allWrong = {"da", "d", "as", "tad"};
        String[] empty = {};
        String[] strings = {"f", "l", "b", "r"};
        assertEquals(new ArrayList<>(Arrays.asList(MoveDirection.FORWARD, MoveDirection.LEFT,
                MoveDirection.BACKWARD, MoveDirection.RIGHT)),
                OptionsParser.parse(strings)
        );

        assertEquals(new ArrayList<>(),
                OptionsParser.parse(empty));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            OptionsParser.parse(allWrong);
        });
        assertEquals("da is not legal move specification", exception.getMessage());



    }

}