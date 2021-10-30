package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionsParser {

    public static ArrayList<MoveDirection> parse(String[] strings) {
        if (strings.length < 1) return new ArrayList<>();
        return Arrays.stream(strings)
                .filter(Objects::nonNull)
                .map(arg -> switch (arg) {
                    case "f" -> MoveDirection.FORWARD;
                    case "b" -> MoveDirection.BACKWARD;
                    case "l" -> MoveDirection.LEFT;
                    case "r" -> MoveDirection.RIGHT;
                    default -> null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
