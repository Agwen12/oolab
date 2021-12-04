package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionsParser {

    public static List<MoveDirection> parse(String[] strings) throws IllegalArgumentException {
        if (strings.length < 1) return new ArrayList<>();
        return Arrays.stream(strings)
                .filter(Objects::nonNull)
                .map(arg -> switch (arg) {
                    case "f", "forward" -> MoveDirection.FORWARD;
                    case "b", "backward" -> MoveDirection.BACKWARD;
                    case "l", "left" -> MoveDirection.LEFT;
                    case "r", "right" -> MoveDirection.RIGHT;
                    default -> throw new IllegalArgumentException(arg + " is not legal move specification");
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
