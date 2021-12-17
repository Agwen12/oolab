package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App extends Application {

    private GridPane gridPane = new GridPane();
    private GrassField map;
    private SimulationEngine engine;

    public void init() {
        try {

            this.map = new GrassField(14);
            List<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(5, 4)));
            this.engine = new SimulationEngine(this.map, positions);
//            this.engine.addObserver()

        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            System.exit(1);
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField movesInput = new TextField();



        Button startButton = new Button("Let's begin");
        startButton.setOnAction(action -> {
            String[] args = movesInput.getText().split(" ");
            List<MoveDirection> directions = OptionsParser.parse(args);
            ((SimulationEngine) this.engine).setDirections(directions);
            Thread engineThread = new Thread(engine);

        });


        HBox hBoxInterface = new HBox();
        hBoxInterface.getChildren().addAll(movesInput, startButton);

        displayMap();

        VBox vBox = new VBox();
        vBox.getChildren().addAll(this.gridPane, hBoxInterface);
        vBox.setAlignment(Pos.BASELINE_CENTER);
        Scene scene = new Scene(vBox, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private void fillCell(Map.Entry<Vector2d, AbstractWorldMapElement> entry, Vector2d upperRight, Vector2d lowerLeft) {
        VBox vBox = null;
        try {
            vBox = new GuiElementBox(entry.getValue()).getvBox();
            this.gridPane.add(vBox, entry.getKey().x - lowerLeft.x + 1, upperRight.y - entry.getKey().y + 1);
            GridPane.setHalignment(vBox, HPos.CENTER);
        } catch (FileNotFoundException e) {
            e.fillInStackTrace();
            System.exit(1);
        }
    }

    private void displayMap() {
//        if (map != null) ((GrassField) map).updateSize();

        Vector2d upperRight = this.map.getUpperRight();
        Vector2d lowerLeft = this.map.getLowerLeft();
        this.gridPane.getRowConstraints().clear();
        this.gridPane.getColumnConstraints().clear();
        this.gridPane.setGridLinesVisible(true);

        Label corner = new Label("y/x");
        this.gridPane.add(corner, 0, 0);
        GridPane.setHalignment(corner, HPos.CENTER);
        this.gridPane.getColumnConstraints().add(new ColumnConstraints(50));
        this.gridPane.getRowConstraints().add(new RowConstraints(50));

        for (int i = 0; i < upperRight.x - lowerLeft.x + 1; ++i) {
            Label number = new Label(Integer.toString(upperRight.x + 1));
            this.gridPane.add(number, 0, i + 1);
            this.gridPane.getColumnConstraints().add(new ColumnConstraints(50));
            GridPane.setHalignment(number, HPos.CENTER);
        }

        for (int i = 0; i < upperRight.x - lowerLeft.x + 1; ++i) {
            Label number = new Label(Integer.toString(upperRight.y - 1));
            this.gridPane.add(number, 0, i + 1);
            this.gridPane.getRowConstraints().add(new RowConstraints(50));
            GridPane.setHalignment(number, HPos.CENTER);
        }

        Map<Vector2d, AbstractWorldMapElement> objects = this.map.getElementMap();

        objects.entrySet().forEach(entry -> fillCell(entry, lowerLeft, upperRight));



    }
}
