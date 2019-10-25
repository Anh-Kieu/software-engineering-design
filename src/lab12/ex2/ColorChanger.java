package lab12.ex2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class ColorChanger extends Application {

    HBox root;
    Button greenBtn;
    Button redBtn;
    Rectangle rec;
    Sphere sphere;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        root = new HBox();

        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);

        // add objects
        addGreenButton();
        addRedButton();
        addRectangle();
        addSphere();

        // handle actions

        handleGreen();
        handleRed();
        revertColor();

        // Add the scene graph to the stage
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();

        // set the title for the main window
        primaryStage.setTitle("Color Changer");

        // Display
        primaryStage.show();
    }

    /**
     * Add a sphere
     */
    private void addSphere() {
        sphere = new Sphere(50);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.GREY);
        material.setSpecularColor(Color.GREY);
        sphere.setMaterial(material);
        root.getChildren().add(sphere);
    }

    /**
     * Revert the original color when clicked anywhere in the box
     */
    private void revertColor() {
        PhongMaterial material = (PhongMaterial) sphere.getMaterial();
        root.setOnMouseClicked(event -> {
            rec.setFill(Color.GREY);
            material.setDiffuseColor(Color.GREY);
            material.setSpecularColor(Color.GREY);
        });
    }

    /**
     * Handle clicking the green button
     */
    private void handleGreen() {
        PhongMaterial material = (PhongMaterial) sphere.getMaterial();
        greenBtn.setOnAction(event -> {
            rec.setFill(Color.GREEN);
            material.setDiffuseColor(Color.GREEN);
            material.setSpecularColor(Color.GREEN);
        });
    }

    /**
     * Handle clicking the red button
     */
    private void handleRed() {
        PhongMaterial material = (PhongMaterial) sphere.getMaterial();
        redBtn.setOnAction(event -> {
            rec.setFill(Color.RED);
            material.setDiffuseColor(Color.RED);
            material.setSpecularColor(Color.RED);
        });
    }

    /**
     * Add the green button to change color of the rectangle
     */
    private void addGreenButton() {
        greenBtn = new Button("Green");
        root.getChildren().add(greenBtn);

    }

    /**
     * Add the red button to change color of the rectangle
     */
    private void addRedButton() {
        redBtn = new Button("Red");
        root.getChildren().add(redBtn);
    }

    /**
     * Add a rectangle
     */
    private void addRectangle() {
        rec = new Rectangle();
        rec.setWidth(100);
        rec.setHeight(100);
        rec.setFill(Color.GREY);
        rec.setStroke(Color.BLACK);
        rec.setStrokeWidth(2);
        root.getChildren().add(rec);
    }
}
