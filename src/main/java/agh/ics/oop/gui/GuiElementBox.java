package agh.ics.oop.gui;

import agh.ics.oop.AbstractWorldMapElement;
import agh.ics.oop.Grass;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class GuiElementBox {

    public GuiElementBox (AbstractWorldMapElement element) {
        Image image = new Image(element.getName());
        ImageView view = new ImageView(image);
        view.setFitHeight(20);
        view.setFitWidth(20);

        Label imageLabel;
        if (element instanceof Grass) imageLabel = new Label("Grass");
        else imageLabel = new Label("Animal");

        VBox vBox = new VBox();
        vBox.getChildren().add(view);
        vBox.getChildren().add(imageLabel);

        vBox.setAlignment(Pos.CENTER);
    }
}
