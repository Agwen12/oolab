package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {

    @Test
    void run1() {
        List<MoveDirection> directions = OptionsParser.parse(new String[] {"f", "l", "f", "f", "l", "b", "l", "f", "b"});
        AbstractWorldMap map = new RectangularMap(10, 5);
        List<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(3, 4)));
        IEngine engine = new SimulationEngine(directions, map, positions, false);
        engine.run();
        assertTrue(Arrays.deepEquals(new Vector2d[] {new Vector2d(2, 4), new Vector2d(3, 4)}, ((SimulationEngine) engine).getAnimalsPositions()));

        List<MoveDirection> directions1 = OptionsParser.parse(new String[] {"b", "b", "l", "l", "b", "f", "f", "f", "f"});
        AbstractWorldMap map1 = new RectangularMap(5, 5);
        List<Vector2d> positions1 = new ArrayList<>(Arrays.asList(new Vector2d(1, 1), new Vector2d(2, 2)));
        IEngine engine1 = new SimulationEngine(directions1, map1, positions1, false);
        engine1.run();
        assertTrue(Arrays.deepEquals(new Vector2d[] {new Vector2d(0, 0), new Vector2d(0, 1)}, ((SimulationEngine) engine1).getAnimalsPositions()));

        List<MoveDirection> directions2 = OptionsParser.parse(new String[] {"f", "b", "r", "l"});
        AbstractWorldMap map2 = new RectangularMap(5, 5);
        List<Vector2d> positions2 = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(3, 4)));
        IEngine engine2 = new SimulationEngine(directions2, map2, positions2, false);
        engine2.run();
        assertTrue(Arrays.deepEquals(new Vector2d[] {new Vector2d(2, 3), new Vector2d(3, 3)}, ((SimulationEngine) engine2).getAnimalsPositions()));
    }

}