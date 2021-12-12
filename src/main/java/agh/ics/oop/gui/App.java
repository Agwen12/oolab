package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App extends Application {

    GridPane root = new GridPane();
    Scene scene = new Scene(this.root, 420, 420);


    public void init() {
        try {
            List<MoveDirection> directions = OptionsParser.parse(getParameters().getRaw().toArray(String[]::new));
            AbstractWorldMap map = new GrassField(14);
            List<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(5, 4)));
            IEngine engine = new SimulationEngine(directions, map, positions);

//            displayMap(map);
            engine.run();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            System.exit(1);
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String fillCell(AbstractWorldMap map, int x, int y, Vector2d upperRight, Vector2d lowerLeft) {
        int xMap = lowerLeft.x + x - 1;
        int yMap = upperRight.y - y + 1;
        if (x == 0 && y == 0) { return "y\\x";
        } else if (y == 0) { return Integer.toString(xMap);
        } else if (x == 0) { return Integer.toString(yMap);
        } else {
            Object o = map.objectAt(new Vector2d(xMap, yMap));
            if (o == null) return "";
            return o.toString();
        }
    }

    private void displayMap(AbstractWorldMap map) {
        if (map instanceof GrassField) ((GrassField) map).updateSize();

        Vector2d upperRight = map.getUpperRight();
        Vector2d lowerLeft = map.getLowerLeft();
        int xRange = upperRight.x - lowerLeft.x + 1;
        int yRange = upperRight.y - lowerLeft.y + 1;

        for (int x = 0; x < xRange + 1; ++x) {
            for (int y = 0; y < yRange + 1; ++y) {
                Label cell = new Label(fillCell(map, x, y, upperRight, lowerLeft));
                this.root.add(cell, x, y, 1, 1);
                GridPane.setValignment(cell, VPos.CENTER);
                GridPane.setHalignment(cell, HPos.CENTER);
            }
        }


        for (int i = 0; i < yRange + 1; ++i) {
            this.root.getRowConstraints().add(new RowConstraints(25));
        }

        for (int i = 0; i < xRange + 1; ++i) {
            this.root.getColumnConstraints().add(new ColumnConstraints(25));
        }
        this.root.setGridLinesVisible(true);
    }
}
