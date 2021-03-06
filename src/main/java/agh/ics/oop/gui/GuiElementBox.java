package agh.ics.oop.gui;

import agh.ics.oop.AbstractWorldMapElement;
import agh.ics.oop.Grass;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {

    private final VBox vBox;

    public GuiElementBox (AbstractWorldMapElement element) throws FileNotFoundException {
        Image image = new Image(new FileInputStream(element.getName()));
        ImageView view = new ImageView(image);
        view.setFitHeight(20);
        view.setFitWidth(20);

        Label imageLabel;
        if (element instanceof Grass) imageLabel = new Label("Grass" );
        else imageLabel = new Label("A"+ element.getPosition().toString());

//        Label positionLabel = new Label();

        this.vBox = new VBox();
        this.vBox.getChildren().add(view);
        this.vBox.getChildren().add(imageLabel);
//        this.vBox.getChildren().add(positionLabel);

        this.vBox.setAlignment(Pos.CENTER);
    }

    public VBox getvBox() {
        return vBox;
    }
}
